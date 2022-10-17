package com.github.huifer.pm.plugin;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProjectList {

  private JTextField taskNameInput;
  private JRadioButton radioButton1;
  private JRadioButton radioButton2;
  private JRadioButton radioButton3;
  private JLabel taskType;
  private JPanel main;

  public JTextField getTaskNameInput() {
    return taskNameInput;
  }

  public JRadioButton getRadioButton1() {
    return radioButton1;
  }

  public JRadioButton getRadioButton2() {
    return radioButton2;
  }

  public JRadioButton getRadioButton3() {
    return radioButton3;
  }

  public JLabel getTaskType() {
    return taskType;
  }

  public JPanel getMain() {
    return main;
  }
}
