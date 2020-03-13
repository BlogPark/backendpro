package com.yongming.backendpro.project.drools.controller;

import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.framework.web.domain.AjaxResult;
import com.yongming.backendpro.project.drools.droolsmodel.DroolsTestModel;
import com.yongming.backendpro.project.drools.model.*;
import com.yongming.backendpro.project.drools.service.droolsBusinessService;
import com.yongming.backendpro.project.drools.service.droolsService;
import com.yongming.backendpro.project.drools.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  // region 实体信息
  @PostMapping("/entitylist")
  public PageInfo<EntityModel> getEntityList(@RequestBody EntityVO entityVO) {
    return droolsService.getEntityList(entityVO);
  }
  // 查询实体下详细字段信息
  @GetMapping("/entityinfo")
  public List<EntityDetailModel> getEntityInfo(@RequestParam("id") String id) {
    return droolsService.getEntityInfo(id);
  }
  // 查询单个实体信息
  @GetMapping("/getentity")
  public EntityModel getsingleEntity(@RequestParam("id") String id) {
    return droolsService.getSingleEntity(id);
  }
  // 按照ids查询实体列表
  @PostMapping("/getentitisbyids")
  public List<EntityModel> getEntityByIds(@RequestBody CommonRequestVO commonRequestVO) {
    return droolsService.getEntitiesByIds(commonRequestVO);
  }
  // endregion

  // region 规则信息
  @PostMapping("/rulelist")
  public PageInfo<RuleModel> getRuleList(@RequestBody RuleVO ruleVO) {
    return droolsService.getAllRulesForPage(ruleVO);
  }
  // endregion
  // region 模板信息
  @PostMapping("/templatelist")
  public PageInfo<TemplatesModel> getTemplatesList(@RequestBody TemplateVO templateVO) {
    return droolsService.getTemplateList(templateVO);
  }

  @GetMapping("/gettemplate")
  public TemplateResponseVO getSingleTemplate(@RequestParam("id") String id) {
    return droolsService.getSingleTemplate(id);
  }

  @PostMapping("/addtemplate")
  public int addTemplate(@RequestBody TemplatesModel templatesModel) {
    return droolsService.addNewTemplate(templatesModel);
  }

  @PostMapping("/updatetemplate")
  public int updateTemplate(@RequestBody TemplatesModel templatesModel) {
    return droolsService.editTemplate(templatesModel);
  }
  // endregion
  // region 函数信息
  @PostMapping("/functionlist")
  public PageInfo<FunctionModel> getFunctionList(@RequestBody FunctionVO functionVO) {
    return droolsService.getFunctionList(functionVO);
  }
  // 查询单个函数信息
  @GetMapping("/getfunction")
  public FunctionModel getSingleFunction(@RequestParam("id") String id) {
    return droolsService.getSingleFunction(id);
  }

  @PostMapping("/getfunctionids")
  public List<FunctionModel> getFunctionListByIds(@RequestBody CommonRequestVO commonRequestVO) {
    return droolsService.getFunctionByIds(commonRequestVO);
  }
  // endregion
  // region 分组信息
  @PostMapping("/grouplist")
  public PageInfo<GroupModel> getGroupList(@RequestBody GroupVO groupVO) {
    return droolsService.getGroupList(groupVO);
  }

  @GetMapping("/getsinglegroup")
  public GroupModel getSingleGroup(@RequestParam("id") String id) {
    return droolsService.getSingleGroup(id);
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
  // endregion

  @PostMapping("/getquotelist")
  private PageInfo<CommonResponseVO> getListData(@RequestBody CommonRequestVO commonRequestVO) {
    return droolsService.getList(commonRequestVO);
  }
}
