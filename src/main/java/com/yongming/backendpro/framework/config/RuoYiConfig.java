package com.yongming.backendpro.framework.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 *
 * @author ruoyi
 */
@Component
@Data
public class RuoYiConfig {
  /** 上传路径 */
  @Value("${project.profile}")
  private static String profile;
  /** 获取地址开关 */
  @Value("${project.addressEnabled}")
  private static boolean addressEnabled;
  /** 项目名称 */
  @Value("${project.name}")
  private String name;
  /** 版本 */
  @Value("${project.version}")
  private String version;
  /** 版权年份 */
  @Value("${project.copyrightYear}")
  private String copyrightYear;
  /** 实例演示开关 */
  @Value("${project.demoEnabled}")
  private boolean demoEnabled;

  /** 获取头像上传路径 */
  public static String getAvatarPath() {
    return profile + "/avatar";
  }

  /** 获取下载路径 */
  public static String getDownloadPath() {
    return profile + "/download/";
  }

  /** 获取上传路径 */
  public static String getUploadPath() {
    return profile + "/upload";
  }
  /** 上传路径 */
  public static String getProfile() {
    return profile;
  }
  /** 获取地址开关 */
  public static boolean isAddressEnabled() {
    return addressEnabled;
  }
}
