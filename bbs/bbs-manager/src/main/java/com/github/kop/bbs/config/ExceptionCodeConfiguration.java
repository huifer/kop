package com.github.kop.bbs.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "ex")
@PropertySource(value = "classpath:/exception-code.properties")
@Component
public class ExceptionCodeConfiguration {

  private Map<Integer, String> codes = new HashMap<>();

  public Map<Integer, String> getCodes() {
    return codes;
  }

  public void setCodes(Map<Integer, String> codes) {
    this.codes = codes;
  }

  public String getMessage(int code) {
    return codes.get(code);
  }
}
