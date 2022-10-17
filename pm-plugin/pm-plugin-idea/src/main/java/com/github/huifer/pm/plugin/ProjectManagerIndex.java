package com.github.huifer.pm.plugin;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ProjectManagerIndex {

  private JTable projectTable;
  private JPanel main;

  public JTable getTable1() {
    return projectTable;
  }

  public JPanel getPanel1() {
    return main;
  }


  private void createUIComponents() {
    projectTable = new JTable();
    DefaultTableModel model =(DefaultTableModel)this.projectTable.getModel();		//获取表格模型
    model.setColumnIdentifiers(new Object[] {"文件名" , "文件大小(B)" , "修改时间"});//修改表头内容

    this.projectTable.setModel(model);

  }
}
