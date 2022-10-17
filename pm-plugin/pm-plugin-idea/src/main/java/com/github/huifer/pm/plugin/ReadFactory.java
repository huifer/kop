package com.github.huifer.pm.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class ReadFactory implements ToolWindowFactory {

  private final ProjectManagerIndex projectManagerIndex = new ProjectManagerIndex();
  private final ProjectList projectList = new ProjectList();
  @Override
  public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    // 获取内容工厂的实例
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    // 获取 ToolWindow 显示的内容
    Content content = contentFactory.createContent(projectList.getMain(), "", false);
    // 设置 ToolWindow 显示的内容
    toolWindow.getContentManager().addContent(content);
  }

}