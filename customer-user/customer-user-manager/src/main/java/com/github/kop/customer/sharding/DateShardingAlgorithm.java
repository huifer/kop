package com.github.kop.customer.sharding;

import cn.hutool.core.date.DateUtil;
import com.github.kop.customer.service.DatabaseService;
import com.github.kop.customer.utils.CtxUtil;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/** 日期分表策略 */
public class DateShardingAlgorithm implements PreciseShardingAlgorithm<LocalDateTime> {

  private static final HashSet<String> tableNameCache = new HashSet<>();

  public boolean shardingTablesExistsCheck(String resultTableName) {
    return tableNameCache.contains(resultTableName);
  }

  /** 获取指定分表 */
  @Override
  public String doSharding(
      Collection<String> availableTargetNames,
      PreciseShardingValue<LocalDateTime> preciseShardingValue) {
    DatabaseService databaseService = CtxUtil.get(DatabaseService.class);
    String logicTableName = preciseShardingValue.getLogicTableName();
    String resultTableName =
        preciseShardingValue.getLogicTableName()
            + DateUtil.format(preciseShardingValue.getValue(), "_yyyy_MM_dd");
    synchronized (logicTableName.intern()) {
      if (shardingTablesExistsCheck(resultTableName)) {
        return resultTableName;
      }
      String sql = databaseService.getCreateTableSql(logicTableName);
      sql = sql.replace("CREATE TABLE", "CREATE TABLE IF NOT EXISTS");
      sql = sql.replace(logicTableName, resultTableName);
      databaseService.execute(sql);
      tableNameCache.add(resultTableName);
    }
    return resultTableName;
  }
}
