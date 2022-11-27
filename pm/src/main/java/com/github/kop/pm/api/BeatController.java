package com.github.kop.pm.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BeatController {

  @RequestMapping("/beat")
  public String beat() {
    return "beat";
  }

}
