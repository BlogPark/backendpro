package com.yongming.backendpro.project.drools.vo;

import com.yongming.backendpro.project.drools.model.EntityModel;
import com.yongming.backendpro.project.drools.model.FunctionModel;
import com.yongming.backendpro.project.drools.model.RuleModel;
import com.yongming.backendpro.project.drools.model.TemplatesModel;
import lombok.Data;

import java.util.List;

@Data
public class RuleResponVO {
  private RuleModel rule;
  private List<EntityModel> quoteEntities;
  private List<FunctionModel> quoteFunctions;
  private TemplatesModel template;
}
