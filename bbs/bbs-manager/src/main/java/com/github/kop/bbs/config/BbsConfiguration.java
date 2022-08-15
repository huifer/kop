package com.github.kop.bbs.config;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bbs")
@Data
public class BbsConfiguration {

  /** token 过期时间 */
  private Long expireSec;
  /** token 秘钥 */
  private String secret;

  /** 环境 */
  private BBSEnv env;
  /** url 相关配置 */
  private Url url;

  public enum BBSEnv {
    DEV,
    PROD
  }

  @Data
  public static class Url {

    /** 白名单 */
    private List<String> white;
  }
}
