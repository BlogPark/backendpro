package com.yongming.backendpro.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.drools.mapper.EntityMapper;
import com.yongming.backendpro.drools.model.EntityModel;
import com.yongming.backendpro.drools.model.RuleModel;
import com.yongming.backendpro.drools.service.droolsService;
import com.yongming.backendpro.drools.vo.EntityVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class droolsServiceImpl implements droolsService {
  @Autowired EntityMapper entityMapper;

  @Override
  public PageInfo<RuleModel> getAllRulesForPage() {
    return null;
  }

  @Override
  public PageInfo<EntityModel> getEntityList(EntityVO entityVO) {
    PageHelper.startPage(entityVO.getPageIndex(), entityVO.getPageSize());
    EntityModel entityModel = new EntityModel();
    entityModel.setId(entityVO.getId());
    entityModel.setEntityName(entityVO.getEntityName());
    entityModel.setGroupId(entityVO.getGroupId());
    entityModel.setGroupName(entityVO.getGroupName());
    List<EntityModel> list = entityMapper.getEntityList(entityModel);
    // 用PageInfo对结果进行包装
    PageInfo<EntityModel> page = new PageInfo<EntityModel>(list);
    return page;
  }
}
