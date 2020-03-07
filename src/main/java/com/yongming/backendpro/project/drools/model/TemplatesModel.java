package com.yongming.backendpro.project.drools.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TemplatesModel {
  /** 自增主键 */
  private int id;
  /** 模板名称 */
  private String templateName;
  /** 模板描述 */
  private String templateDesc;
  /** 引用实体集合 */
  private String quoteEntities;
  /** 是否可改动 */
  private int canChanged;
  /** 模板内容 */
  private String templateContent;
  /** 引用函数集合 */
  private String quoteFunctions;
  /** 创建时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;
}
