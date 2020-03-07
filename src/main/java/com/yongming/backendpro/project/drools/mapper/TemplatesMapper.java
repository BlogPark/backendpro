package com.yongming.backendpro.project.drools.mapper;

import com.yongming.backendpro.project.drools.model.TemplatesModel;

import java.util.List;

public interface TemplatesMapper {
  /**
   * 查询模板列表
   *
   * @return
   */
  List<TemplatesModel> getTemplateList(TemplatesModel templatesModel);

  /**
   * 查询模板
   *
   * @return
   */
  TemplatesModel getTemplateModel();

  /**
   * 添加模板
   *
   * @param templatesModel
   * @return
   */
  int addNewTemplate(TemplatesModel templatesModel);

  /**
   * 修改模板
   *
   * @param templatesModel
   * @return
   */
  int updateTemplate(TemplatesModel templatesModel);
}
