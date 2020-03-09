package com.yongming.backendpro.project.drools.vo;

import com.yongming.backendpro.project.drools.model.EntityModel;
import com.yongming.backendpro.project.drools.model.FunctionModel;
import com.yongming.backendpro.project.drools.model.TemplatesModel;
import lombok.Data;

import java.util.List;

@Data
public class TemplateResponseVO {
  /** 模板实体 */
  private TemplatesModel templatesModel;
  /** 函数实体列表 */
  private List<FunctionModel> functionModelList;
  /** 实体列表 */
  private List<EntityModel> entityModelList;
}
