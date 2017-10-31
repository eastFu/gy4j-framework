package cn.gyyx.rbac.mapper;

import cn.gyyx.rbac.entity.RbacRolePermissions;
import cn.gyyx.framework.mybatis.mapper.BaseMapper;
import cn.gyyx.framework.mybatis.annotations.MyBatisDao;
/**
 * <p>
  * 角色-权限中间表 Mapper 接口
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@MyBatisDao
public interface RbacRolePermissionsMapper extends BaseMapper<RbacRolePermissions> {

}