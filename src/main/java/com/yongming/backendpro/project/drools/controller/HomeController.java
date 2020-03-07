package com.yongming.backendpro.project.drools.controller;

import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.project.drools.droolsmodel.DroolsTestModel;
import com.yongming.backendpro.project.drools.model.EntityDetailModel;
import com.yongming.backendpro.project.drools.model.EntityModel;
import com.yongming.backendpro.project.drools.model.ResultModel;
import com.yongming.backendpro.project.drools.model.RuleModel;
import com.yongming.backendpro.project.drools.vo.EntityVO;
import com.yongming.backendpro.project.drools.vo.RuleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drools")
public class HomeController {

  @Autowired
  private com.yongming.backendpro.project.drools.service.droolsBusinessService
      droolsBusinessService;

  @Autowired private com.yongming.backendpro.project.drools.service.droolsService droolsService;

  @GetMapping("/write")
  public ResultModel writeRule() {
    droolsBusinessService.buildRules("");
    ResultModel resultModel = new ResultModel();
    resultModel.setMessage("success");
    return resultModel;
  }

  @GetMapping("/create")
  public ResultModel createRuleFile() {
    String result = droolsBusinessService.createRuleFile("");
    ResultModel resultModel = new ResultModel();
    resultModel.setMessage("success");
    return resultModel;
  }

  @GetMapping("/execute")
  public ResultModel execRuleFile() {
    DroolsTestModel droolsTestModel = droolsBusinessService.fireRuleFile("");
    ResultModel resultModel = new ResultModel();
    resultModel.setMessage(droolsTestModel.getName());
    return resultModel;
  }

  // region 实体信息
  @PostMapping("/entitylist")
  public PageInfo<EntityModel> getEntityList(@RequestBody EntityVO entityVO) {
    return droolsService.getEntityList(entityVO);
  }

  @GetMapping("/entityinfo")
  public List<EntityDetailModel> getEntityInfo(@RequestParam("id") String id) {
    return droolsService.getEntityInfo(id);
  }
  // endregion

  // region 规则信息
  @PostMapping("/rulelist")
  public PageInfo<RuleModel> getRuleList(@RequestBody RuleVO ruleVO) {
    return droolsService.getAllRulesForPage(ruleVO);
  }
  // endregion
}
