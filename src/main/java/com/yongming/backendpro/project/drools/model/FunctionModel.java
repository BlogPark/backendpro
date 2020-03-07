package com.yongming.backendpro.project.drools.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FunctionModel {
  /** 自增主键 */
  private int id;
  /** 函数名称 */
  private String functionName;
  /** 函数描述 */
  private String functionDesc;
  /** 函数内容 */
  private String functionContent;
  /** 引入实体集合 */
  private String quoteEntities;
  /** 返回值类型 */
  private String returnType;
  /** 函数参数描述 */
  private String functionParamterDesc;
  /** 使用示例 */
  private String usageExample;
  /** 分组ID */
  private int groupId;
  /** f分组名称 */
  private String groupName;
  /** 创建时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;
}
