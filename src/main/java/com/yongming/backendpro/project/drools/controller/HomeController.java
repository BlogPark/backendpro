package com.yongming.backendpro.project.drools.controller;

import com.yongming.backendpro.framework.web.domain.AjaxResult;
import com.yongming.backendpro.project.drools.droolsmodel.DroolsTestModel;
import com.yongming.backendpro.project.drools.model.*;
import com.yongming.backendpro.project.drools.service.droolsBusinessService;
import com.yongming.backendpro.project.drools.service.droolsService;
import com.yongming.backendpro.project.drools.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("规则引擎相关接口")
@RestController
@RequestMapping("/drools")
public class HomeController {

  @Autowired private droolsBusinessService droolsBusinessService;

  @Autowired private droolsService droolsService;

  @ApiOperation("写入新规则")
  @GetMapping("/write")
  public AjaxResult writeRule() {
    droolsBusinessService.buildRules("");
    ResultModel resultModel = new ResultModel();
    resultModel.setMessage("success");
    return AjaxResult.success(resultModel);
  }

  @GetMapping("/create")
  public AjaxResult createRuleFile() {
    String result = droolsBusinessService.createRuleFile("");
    ResultModel resultModel = new ResultModel();
    resultModel.setMessage("success");
    return AjaxResult.success(resultModel);
  }

  @GetMapping("/execute")
  public AjaxResult execRuleFile() {
    DroolsTestModel droolsTestModel = droolsBusinessService.fireRuleFile("");
    ResultModel resultModel = new ResultModel();
    resultModel.setMessage(droolsTestModel.getName());
    return AjaxResult.success(resultModel);
  }

  // region 实体信息
  @PostMapping("/entitylist")
  public AjaxResult getEntityList(@RequestBody EntityVO entityVO) {
    return AjaxResult.success(droolsService.getEntityList(entityVO));
  }
  // 查询实体下详细字段信息
  @GetMapping("/entityinfo")
  public AjaxResult getEntityInfo(@RequestParam("id") String id) {
    return AjaxResult.success(droolsService.getEntityInfo(id));
  }
  // 查询单个实体信息
  @GetMapping("/getentity")
  public AjaxResult getsingleEntity(@RequestParam("id") String id) {
    return AjaxResult.success(droolsService.getSingleEntity(id));
  }
  // 按照ids查询实体列表
  @PostMapping("/getentitisbyids")
  public AjaxResult getEntityByIds(@RequestBody CommonRequestVO commonRequestVO) {
    return AjaxResult.success(droolsService.getEntitiesByIds(commonRequestVO));
  }
  // endregion
  // region 规则信息
  @PostMapping("/rulelist")
  public AjaxResult getRuleList(@RequestBody RuleVO ruleVO) {
    return AjaxResult.success(droolsService.getAllRulesForPage(ruleVO));
  }

  @GetMapping("/selectsinglerule")
  public AjaxResult selectSingleRuleInfo(@RequestParam("id") String id) {
    return AjaxResult.success(droolsService.getSingleRule(id));
  }

  @PostMapping("/addrule")
  public AjaxResult addRule(@RequestBody RuleModel ruleModel) {
    if (droolsService.addNewRule(ruleModel) > 0) {
      return AjaxResult.success("success");
    } else {
      return AjaxResult.error("添加失败");
    }
  }

  @PostMapping("/editrule")
  public AjaxResult editRule(@RequestBody RuleModel ruleModel) {
    if (droolsService.editRule(ruleModel) > 0) {
      return AjaxResult.success("success");
    } else {
      return AjaxResult.error("添加失败");
    }
  }

  @PostMapping("/getruleids")
  public AjaxResult getRuleListByIds(@RequestBody CommonRequestVO commonRequestVO) {
    return AjaxResult.success(droolsService.getRuleByIds(commonRequestVO));
  }
  // endregion
  // region 模板信息
  @PostMapping("/templatelist")
  public AjaxResult getTemplatesList(@RequestBody TemplateVO templateVO) {
    return AjaxResult.success(droolsService.getTemplateList(templateVO));
  }

  @GetMapping("/gettemplate")
  public AjaxResult getSingleTemplate(@RequestParam("id") String id) {
    return AjaxResult.success(droolsService.getSingleTemplate(id));
  }

  @PostMapping("/addtemplate")
  public AjaxResult addTemplate(@RequestBody TemplatesModel templatesModel) {
    return AjaxResult.success(droolsService.addNewTemplate(templatesModel));
  }

  @PostMapping("/updatetemplate")
  public AjaxResult updateTemplate(@RequestBody TemplatesModel templatesModel) {
    return AjaxResult.success(droolsService.editTemplate(templatesModel));
  }

  @GetMapping("/gettemplatelist")
  public AjaxResult getSelectTemplates() {
    return AjaxResult.success(droolsService.getTemplateForSelect());
  }
  // endregion
  // region 函数信息
  @PostMapping("/functionlist")
  public AjaxResult getFunctionList(@RequestBody FunctionVO functionVO) {
    return AjaxResult.success(droolsService.getFunctionList(functionVO));
  }
  // 查询单个函数信息
  @GetMapping("/getfunction")
  public AjaxResult getSingleFunction(@RequestParam("id") String id) {
    return AjaxResult.success(droolsService.getSingleFunction(id));
  }
  // 查询所有函数
  @PostMapping("/getfunctionids")
  public AjaxResult getFunctionListByIds(@RequestBody CommonRequestVO commonRequestVO) {
    return AjaxResult.success(droolsService.getFunctionByIds(commonRequestVO));
  }
  // 添加函数信息
  @PostMapping("/addfunction")
  public AjaxResult addNewFunction(@RequestBody FunctionModel functionModel) {
    if (droolsService.addNewFunction(functionModel) > 0) {
      return AjaxResult.success("success");
    } else {
      return AjaxResult.error("添加失败！");
    }
  }
  // 编辑函数信息
  @PostMapping("/editfunction")
  public AjaxResult editFunction(@RequestBody FunctionModel functionModel) {
    if (droolsService.editFunction(functionModel) > 0) {
      return AjaxResult.success("success");
    } else {
      return AjaxResult.error("编辑失败");
    }
  }

  @GetMapping("/getsinglefunction")
  public AjaxResult getFunction(@RequestParam("id") String id) {
    return AjaxResult.success(droolsService.getFunctionById(id));
  }
  // endregion
  // region 分组信息
  @PostMapping("/grouplist")
  public AjaxResult getGroupList(@RequestBody GroupVO groupVO) {
    return AjaxResult.success(droolsService.getGroupList(groupVO));
  }

  @GetMapping("/getsinglegroup")
  public AjaxResult getSingleGroup(@RequestParam("id") String id) {
    return AjaxResult.success(droolsService.getSingleGroup(id));
  }

  @PostMapping("/addgroup")
  public AjaxResult addNewGroup(@RequestBody GroupModel groupModel) {
    if (droolsService.addNewGroup(groupModel) > 0) {
      return AjaxResult.success("success");
    } else {
      return AjaxResult.error("添加失败");
    }
  }

  @PostMapping("/updategroup")
  public AjaxResult updateGroup(@RequestBody GroupModel groupModel) {
    if (droolsService.editGroup(groupModel) > 0) {
      return AjaxResult.success("success");
    } else {
      return AjaxResult.error("更新失败");
    }
  }

  @GetMapping("/selectgrouplist")
  public AjaxResult selectGroupList() {
    return AjaxResult.success(droolsService.getGroupListForSelect());
  }
  // endregion
  // region 产品信息
  @PostMapping("/getproductlist")
  public AjaxResult getProductListForPage(@RequestBody ProductVO productVO) {
    return AjaxResult.success(droolsService.getProductListForPage(productVO));
  }

  @PostMapping("/addproduct")
  public AjaxResult addNewProduct(@RequestBody ProductModel productModel) {
    if (droolsService.addNewProduct(productModel) > 0) {
      return AjaxResult.success("success");
    } else {
      return AjaxResult.error("添加产品失败");
    }
  }

  @PostMapping("/editprosuct")
  public AjaxResult editProduct(@RequestBody ProductModel productModel) {
    if (droolsService.editProduct(productModel) > 0) {
      return AjaxResult.success("success");
    } else {
      return AjaxResult.error("修改失败");
    }
  }

  @GetMapping("getproductinfo")
  public AjaxResult getSingleProduct(@RequestParam("id") String id) {
    return AjaxResult.success(droolsService.getSingleProduct(id));
  }
  // endregion

  @PostMapping("/getquotelist")
  private AjaxResult getListData(@RequestBody CommonRequestVO commonRequestVO) {
    return AjaxResult.success(droolsService.getList(commonRequestVO));
  }

  @PostMapping("/buildrule")
  private AjaxResult buildProductRule(@RequestBody BuildVO buildVO) {
    String result = droolsBusinessService.buildRuleToRedis(buildVO.getProductCode());
    if (result.equals("success")) {
      return AjaxResult.success("操作成功");
    } else {
      return AjaxResult.error("操作失败！");
    }
  }

  @PostMapping("/execrule")
  private AjaxResult execProductRule(@RequestBody BuildVO buildVO) {
    String result = droolsBusinessService.fireRuleFormRedis(buildVO.getProductCode());
    if (result.equals("success")) {
      return AjaxResult.success("操作成功");
    } else {
      return AjaxResult.error("操作失败！");
    }
  }
}
