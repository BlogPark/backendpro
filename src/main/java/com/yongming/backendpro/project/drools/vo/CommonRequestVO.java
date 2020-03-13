package com.yongming.backendpro.project.drools.vo;

import lombok.Data;

import java.util.List;

@Data
public class CommonRequestVO {
  private int type;
  private String name;
  private int pageIndex;
  private int pageSize;
  private List<String> idList;
}
