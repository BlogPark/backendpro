package com.yongming.backendpro.drools.controller;

import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.drools.droolsmodel.DroolsTestModel;
import com.yongming.backendpro.drools.model.EntityModel;
import com.yongming.backendpro.drools.model.ResultModel;
import com.yongming.backendpro.drools.service.droolsBusinessService;
import com.yongming.backendpro.drools.service.droolsService;
import com.yongming.backendpro.drools.vo.EntityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drools")
public class HomeController {

  @Autowired private droolsBusinessService droolsBusinessService;
  @Autowired private droolsService droolsService;

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

  @PostMapping("/entitylist")
  public PageInfo<EntityModel> getEntityList(@RequestBody EntityVO entityVO) {
    return droolsService.getEntityList(entityVO);
  }
}
