package cn.gyyx.rbac.mapper;

import cn.gyyx.rbac.entity.RbacRole;
import cn.gyyx.framework.mybatis.mapper.BaseMapper;
import cn.gyyx.framework.mybatis.annotations.MyBatisDao;
/**
 * <p>
  * 系统角色表 Mapper 接口
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@MyBatisDao
public interface RbacRoleMapper extends BaseMapper<RbacRole> {

}