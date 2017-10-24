package cn.gyyx.rbac.service.impl;

import cn.gyyx.rbac.entity.RbacUserRole;
import cn.gyyx.rbac.mapper.RbacUserRoleMapper;
import cn.gyyx.rbac.service.IRbacUserRoleService;
import cn.gyyx.framework.mybatis.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色中间表 服务实现类
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@Service
public class RbacUserRoleServiceImpl extends ServiceImpl<RbacUserRoleMapper, RbacUserRole> implements IRbacUserRoleService {
	
}
