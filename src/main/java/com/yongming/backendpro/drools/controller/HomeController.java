package com.yongming.backendpro.drools.controller;

import com.yongming.backendpro.drools.droolsmodel.DroolsTestModel;
import com.yongming.backendpro.drools.model.ResultModel;
import com.yongming.backendpro.drools.service.droolsBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drools")
public class HomeController {

  @Autowired private droolsBusinessService droolsBusinessService;

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
}
