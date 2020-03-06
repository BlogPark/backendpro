package com.yongming.backendpro.project.drools.vo;

import lombok.Data;

@Data
public class EntityVO {
  private int id;
  private String entityName;
  private int groupId;
  private String groupName;
  private int pageIndex;
  private int pageSize;
}
