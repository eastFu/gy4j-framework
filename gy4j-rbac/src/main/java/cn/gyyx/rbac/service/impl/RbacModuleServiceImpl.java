package cn.gyyx.rbac.service.impl;

import cn.gyyx.rbac.entity.RbacModule;
import cn.gyyx.rbac.mapper.RbacModuleMapper;
import cn.gyyx.rbac.service.IRbacModuleService;
import cn.gyyx.framework.mybatis.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模块权限类 服务实现类
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@Service
public class RbacModuleServiceImpl extends ServiceImpl<RbacModuleMapper, RbacModule> implements IRbacModuleService {
	
}
