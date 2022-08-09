package com.github.kop.customer.service.impl;

import com.github.kop.customer.service.DatabaseService;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseServiceImpl implements DatabaseService {
  private final DataSource dataSource;

  private final JdbcTemplate jdbcTemplate;

  public DatabaseServiceImpl(DataSource dataSource) {
    this.dataSource = dataSource;
    jdbcTemplate = new JdbcTemplate(this.dataSource);
  }

  @Override
  public List<String> tables(String dbName) {
    return jdbcTemplate.query("show tables ", (rs, rowNum) -> rs.getString(1));
  }

  @Override
  public String getCreateTableSql(String tableName) {
    List<String> query =
        jdbcTemplate.query(" SHOW CREATE TABLE  " + tableName, (rs, rowNum) -> rs.getString(2));
    return query.get(0);
  }

  @Override
  public void execute(String sql) {
    jdbcTemplate.execute(sql);
  }
}
