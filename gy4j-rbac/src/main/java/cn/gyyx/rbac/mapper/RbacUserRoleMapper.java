package cn.gyyx.rbac.mapper;

import cn.gyyx.rbac.entity.RbacUserRole;
import cn.gyyx.framework.mybatis.mapper.BaseMapper;
import cn.gyyx.framework.mybatis.annotations.MyBatisDao
/**
 * <p>
  * 用户-角色中间表 Mapper 接口
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@MyBatisDao
public interface RbacUserRoleMapper extends BaseMapper<RbacUserRole> {

}