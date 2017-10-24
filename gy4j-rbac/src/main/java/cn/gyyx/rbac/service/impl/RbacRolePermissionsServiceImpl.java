package cn.gyyx.rbac.service.impl;

import cn.gyyx.rbac.entity.RbacRolePermissions;
import cn.gyyx.rbac.mapper.RbacRolePermissionsMapper;
import cn.gyyx.rbac.service.IRbacRolePermissionsService;
import cn.gyyx.framework.mybatis.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-权限中间表 服务实现类
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@Service
public class RbacRolePermissionsServiceImpl extends ServiceImpl<RbacRolePermissionsMapper, RbacRolePermissions> implements IRbacRolePermissionsService {
	
}
