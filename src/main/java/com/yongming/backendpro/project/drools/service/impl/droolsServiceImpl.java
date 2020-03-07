package com.yongming.backendpro.project.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.project.drools.mapper.EntityDetailMapper;
import com.yongming.backendpro.project.drools.mapper.EntityMapper;
import com.yongming.backendpro.project.drools.mapper.RuleMapper;
import com.yongming.backendpro.project.drools.model.EntityDetailModel;
import com.yongming.backendpro.project.drools.model.EntityModel;
import com.yongming.backendpro.project.drools.model.RuleModel;
import com.yongming.backendpro.project.drools.service.droolsService;
import com.yongming.backendpro.project.drools.vo.EntityVO;
import com.yongming.backendpro.project.drools.vo.RuleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class droolsServiceImpl implements droolsService {
  @Autowired EntityMapper entityMapper;
  @Autowired EntityDetailMapper entityDetailMapper;
  @Autowired RuleMapper ruleMapper;

  @Override
  public PageInfo<RuleModel> getAllRulesForPage(RuleVO ruleVO) {
    PageHelper.startPage(ruleVO.getPageIndex(), ruleVO.getPageSize());
    RuleModel ruleModel = new RuleModel();
    ruleModel.setId(ruleVO.getId());
    ruleModel.setRuleCode(ruleVO.getRuleCode());
    ruleModel.setRuleName(ruleVO.getRuleName());
    ruleModel.setRuleGroup(ruleVO.getGroupName());
    List<RuleModel> list = ruleMapper.getRuleList(ruleModel);
    // 用PageInfo对结果进行包装
    PageInfo<RuleModel> page = new PageInfo<RuleModel>(list);
    return page;
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

  @Override
  public List<EntityDetailModel> getEntityInfo(String id) {
    return entityDetailMapper.getEntityDetailsByEntityID(id);
  }
}
