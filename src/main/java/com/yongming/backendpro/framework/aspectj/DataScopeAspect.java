package com.yongming.backendpro.framework.aspectj;

import com.yongming.backendpro.common.utils.ServletUtils;
import com.yongming.backendpro.common.utils.StringUtils;
import com.yongming.backendpro.common.utils.spring.SpringUtils;
import com.yongming.backendpro.framework.aspectj.lang.annotation.DataScope;
import com.yongming.backendpro.framework.security.LoginUser;
import com.yongming.backendpro.framework.security.service.TokenService;
import com.yongming.backendpro.framework.web.domain.BaseEntity;
import com.yongming.backendpro.project.system.model.SysRole;
import com.yongming.backendpro.project.system.model.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据过滤处理
 *
 * @author ruoyi
 */
@Aspect
@Component
public class DataScopeAspect {
  /** 全部数据权限 */
  public static final String DATA_SCOPE_ALL = "1";

  /** 自定数据权限 */
  public static final String DATA_SCOPE_CUSTOM = "2";

  /** 部门数据权限 */
  public static final String DATA_SCOPE_DEPT = "3";

  /** 部门及以下数据权限 */
  public static final String DATA_SCOPE_DEPT_AND_CHILD = "4";

  /** 仅本人数据权限 */
  public static final String DATA_SCOPE_SELF = "5";

  /**
   * 数据范围过滤
   *
   * @param joinPoint 切点
   * @param user 用户
   */
  public static void dataScopeFilter(
      JoinPoint joinPoint, SysUser user, String deptAlias, String userAlias) {
    StringBuilder sqlString = new StringBuilder();

    for (SysRole role : user.getRoles()) {
      String dataScope = role.getDataScope();
      if (DATA_SCOPE_ALL.equals(dataScope)) {
        sqlString = new StringBuilder();
        break;
      } else if (DATA_SCOPE_CUSTOM.equals(dataScope)) {
        sqlString.append(
            StringUtils.format(
                " OR {}.dept_id IN ( SELECT dept_id FROM sys_role_dept WHERE role_id = {} ) ",
                deptAlias,
                role.getRoleId()));
      } else if (DATA_SCOPE_DEPT.equals(dataScope)) {
        sqlString.append(StringUtils.format(" OR {}.dept_id = {} ", deptAlias, user.getDeptId()));
      } else if (DATA_SCOPE_DEPT_AND_CHILD.equals(dataScope)) {
        sqlString.append(
            StringUtils.format(
                " OR {}.dept_id IN ( SELECT dept_id FROM sys_dept WHERE dept_id = {} or find_in_set( {} , ancestors ) )",
                deptAlias,
                user.getDeptId(),
                user.getDeptId()));
      } else if (DATA_SCOPE_SELF.equals(dataScope)) {
        if (StringUtils.isNotBlank(userAlias)) {
          sqlString.append(StringUtils.format(" OR {}.user_id = {} ", userAlias, user.getUserId()));
        } else {
          // 数据权限为仅本人且没有userAlias别名不查询任何数据
          sqlString.append(" OR 1=0 ");
        }
      }
    }

    if (StringUtils.isNotBlank(sqlString.toString())) {
      BaseEntity baseEntity = (BaseEntity) joinPoint.getArgs()[0];
      baseEntity.setDataScope(" AND (" + sqlString.substring(4) + ")");
    }
  }

  // 配置织入点
  @Pointcut("@annotation(com.yongming.backendpro.framework.aspectj.lang.annotation.DataScope)")
  public void dataScopePointCut() {}

  @Before("dataScopePointCut()")
  public void doBefore(JoinPoint point) throws Throwable {
    handleDataScope(point);
  }

  protected void handleDataScope(final JoinPoint joinPoint) {
    // 获得注解
    DataScope controllerDataScope = getAnnotationLog(joinPoint);
    if (controllerDataScope == null) {
      return;
    }
    // 获取当前的用户
    LoginUser loginUser =
        SpringUtils.getBean(TokenService.class).getLoginUser(ServletUtils.getRequest());
    SysUser currentUser = loginUser.getUser();
    if (currentUser != null) {
      // 如果是超级管理员，则不过滤数据
      if (!currentUser.isAdmin()) {
        dataScopeFilter(
            joinPoint,
            currentUser,
            controllerDataScope.deptAlias(),
            controllerDataScope.userAlias());
      }
    }
  }

  /** 是否存在注解，如果存在就获取 */
  private DataScope getAnnotationLog(JoinPoint joinPoint) {
    Signature signature = joinPoint.getSignature();
    MethodSignature methodSignature = (MethodSignature) signature;
    Method method = methodSignature.getMethod();

    if (method != null) {
      return method.getAnnotation(DataScope.class);
    }
    return null;
  }
}
