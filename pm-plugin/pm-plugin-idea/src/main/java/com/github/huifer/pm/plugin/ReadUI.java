package com.github.huifer.pm.plugin;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ReadUI {

  private JPanel mainPanel;
  private JTextPane textContent;

  public JComponent getComponent() {
    return mainPanel;
  }

  public JTextPane getTextContent() {
    return textContent;
  }

}