package com.github.kop.pm.service;


import com.github.kop.pm.Main;
import com.github.kop.pm.http.vo.ProjectBindUserVO;
import com.github.kop.pm.http.vo.ProjectBugExecutorVO;
import com.github.kop.pm.http.vo.ProjectBugVO;
import com.github.kop.pm.http.vo.ProjectEditionUpdateVO;
import com.github.kop.pm.http.vo.ProjectEditionVO;
import com.github.kop.pm.http.vo.ProjectFeatureUserVO;
import com.github.kop.pm.http.vo.ProjectFeatureVO;
import com.github.kop.pm.http.vo.ProjectProgrammeVO;
import com.github.kop.pm.http.vo.ProjectTaskVO;
import com.github.kop.pm.http.vo.ProjectVO;
import com.github.kop.pm.http.vo.UserVO;
import com.github.kop.pm.module.enums.ProjectTaskType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Main.class})
class ProjectServiceTest {

  @Autowired
  private ProjectService projectService;
  @Autowired
  private ProjectEditionService projectEditionService;
  @Autowired
  private UserService userService;
  @Autowired
  private ProjectBindUserService projectBindUserService;
  @Autowired
  private ProjectProgrammeService projectProgrammeService;
  @Autowired
  private ProjectFeatureUserService projectFeatureUserService;
  @Autowired
  private ProjectFeatureService projectFeatureService;
  @Autowired
  private ProjectBugService projectBugService;
  @Autowired
  private ProjectBugExecutorService bugExecutorService;
  @Autowired
  private ProjectTaskService projectTaskService;

  @Test
  void create() {

    // 1. 创建项目
    ProjectVO vO = new ProjectVO();
    vO.setName("测试项目");

    Integer projectId = projectService.save(vO);
    // 2. 创建项目版本

    ProjectEditionVO vO1 = new ProjectEditionVO();
    vO1.setEdition("v1.0.0");
    vO1.setStartTime(LocalDate.now());
    vO1.setEndTime(LocalDate.now());
    vO1.setProjectId(projectId);

    Integer projectEditionId = projectEditionService.save(vO1);

    // 3. 创建人员

    List<Integer> userIds = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      UserVO vO2 = new UserVO();
      vO2.setUsername("张三" + (i + 1));
      Integer save2 = userService.save(vO2);
      userIds.add(save2);
    }

    // 4. 项目和人员绑定
    for (Integer userId : userIds) {
      ProjectBindUserVO vO2 = new ProjectBindUserVO();
      vO2.setProjectId(projectId);
      vO2.setUserId(userId);
      projectBindUserService.save(vO2);
    }

    // 5. 创建项目git工程
    ProjectProgrammeVO vO2 = new ProjectProgrammeVO();
    vO2.setName("uname");
    vO2.setGitUrl("u-git");
    vO2.setProjectId(projectId);
    projectProgrammeService.save(vO2);

    // 6. 创建功能

    for (Integer userId : userIds) {
      ProjectFeatureVO vO3 = new ProjectFeatureVO();
      vO3.setProjectId(projectId);
      vO3.setProjectEditionId(projectEditionId);
      vO3.setName("功能1");
      vO3.setDesc("功能1");
      vO3.setLink("功能1");
      Integer featId = projectFeatureService.save(vO3);

      // 选择参与人
      ProjectFeatureUserVO vO4 = new ProjectFeatureUserVO();
      vO4.setProjectId(projectId);
      vO4.setProjectEditionId(projectEditionId);
      vO4.setProjectFeatureId(featId);
      vO4.setUserId(userId);
      projectFeatureUserService.save(vO4);

      // TODO: 2022/10/24  创建参与人任务列表

      ProjectTaskVO vO7 = new ProjectTaskVO();
      vO7.setProjectId(projectId);
      vO7.setProjectEditionId(projectEditionId);
      vO7.setName("系统分配功能任务");
      vO7.setDesc("系统分配功能任务");
      vO7.setType(ProjectTaskType.SYS_BUG.getCode());
      vO7.setLink("");
      vO7.setStartTime(LocalDateTime.now());
      vO7.setEndTime(LocalDateTime.now());
      vO7.setExpectedStartTime(LocalDateTime.now());
      vO7.setExpectedEndTime(LocalDateTime.now());
      vO7.setCompile(0);

      projectTaskService.save(vO7);

      // 7 创建bug
      ProjectBugVO vO5 = new ProjectBugVO();
      vO5.setProjectId(projectId);
      vO5.setProjectEditionId(projectEditionId);
      vO5.setName("bug");
      vO5.setDesc("bug");
      vO5.setProjectFeatureId(featId);

      Integer bugId = projectBugService.save(vO5);

      ProjectBugExecutorVO vO6 = new ProjectBugExecutorVO();
      vO6.setProjectId(projectId);
      vO6.setProjectEditionId(projectEditionId);
      vO6.setProjectBugId(bugId);
      vO6.setUserId(userId);

      bugExecutorService.save(vO6);
      // TODO: 2022/10/24  创建参与人任务列表
      ProjectTaskVO vO8 = new ProjectTaskVO();
      vO8.setProjectId(projectId);
      vO8.setProjectEditionId(projectEditionId);
      vO8.setName("系统分配bug修复任务");
      vO8.setDesc("系统分配bug修复任务");
      vO8.setType(ProjectTaskType.SYS_FEAT.getCode());
      vO8.setLink("");
      vO8.setStartTime(LocalDateTime.now());
      vO8.setEndTime(LocalDateTime.now());
      vO8.setExpectedStartTime(LocalDateTime.now());
      vO8.setExpectedEndTime(LocalDateTime.now());
      vO8.setCompile(0);
      projectTaskService.save(vO8);
    }

    System.out.println();
  }

}