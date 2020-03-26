package com.yongming.backendpro.project.drools.vo;

import com.yongming.backendpro.project.drools.model.EntityModel;
import com.yongming.backendpro.project.drools.model.FunctionModel;
import lombok.Data;

import java.util.List;

@Data
public class FunctionResponVO {
  private FunctionModel functionModel;
  private List<EntityModel> quoteEntities;
}
