package com.github.kop.bbs.service;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpLocationServiceTest {

  @Resource private IpLocationService ipLocationService;

  @Test
  public void testIpLocationS() {
    System.out.println(ipLocationService.getLocation("223.104.165.165"));
  }
}
