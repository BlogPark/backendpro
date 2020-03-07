package com.yongming.backendpro.project.drools.vo;

import lombok.Data;

@Data
public class FunctionVO {
  private int id;
  private String functionName;
  private String functionDesc;
  private String groupName;
  private int pageIndex;
  private int pageSize;
}
