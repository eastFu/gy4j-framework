package cn.gyyx.rbac.service.impl;

import cn.gyyx.rbac.entity.RbacMenu;
import cn.gyyx.rbac.mapper.RbacMenuMapper;
import cn.gyyx.rbac.service.IRbacMenuService;
import cn.gyyx.framework.mybatis.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@Service
public class RbacMenuServiceImpl extends ServiceImpl<RbacMenuMapper, RbacMenu> implements IRbacMenuService {
	
}
