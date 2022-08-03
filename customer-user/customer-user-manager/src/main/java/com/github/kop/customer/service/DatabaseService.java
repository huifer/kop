package com.github.kop.customer.service;

import java.util.List;

public interface DatabaseService {
  /** 获取数据下所有表名称 */
  List<String> tables(String dbName);

  /** 获取建表语句 */
  String getCreateTableSql(String tableName);

  void execute(String sql);
}
