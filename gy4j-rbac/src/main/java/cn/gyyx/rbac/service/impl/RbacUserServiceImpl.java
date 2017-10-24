package cn.gyyx.rbac.service.impl;

import cn.gyyx.rbac.entity.RbacUser;
import cn.gyyx.rbac.mapper.RbacUserMapper;
import cn.gyyx.rbac.service.IRbacUserService;
import cn.gyyx.framework.mybatis.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@Service
public class RbacUserServiceImpl extends ServiceImpl<RbacUserMapper, RbacUser> implements IRbacUserService {
	
}
