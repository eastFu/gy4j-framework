package cn.gyyx.rbac.service.impl;

import cn.gyyx.rbac.entity.RbacRole;
import cn.gyyx.rbac.mapper.RbacRoleMapper;
import cn.gyyx.rbac.service.IRbacRoleService;
import cn.gyyx.framework.mybatis.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@Service
public class RbacRoleServiceImpl extends ServiceImpl<RbacRoleMapper, RbacRole> implements IRbacRoleService {
	
}
