package com.yongming.backendpro.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取代码生成相关配置
 *
 * @author ruoyi
 */
@Component
public class GenConfig {
  /** 作者 */
  @Value("${gen.author}")
  public static String author;

  /** 生成包路径 */
  @Value("${gen.packageName}")
  public static String packageName;

  /** 自动去除表前缀，默认是true */
  @Value("${gen.autoRemovePre}")
  public static boolean autoRemovePre;

  /** 表前缀(类名不会包含表前缀) */
  @Value("${gen.tablePrefix}")
  public static String tablePrefix;
}
