package cn.gyyx.test;

import cn.gyyx.gy4j.model.RbacUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/17 14:51
 */
@Service
public class UserService{

    @Autowired
    protected UserMapper baseMapper;

    public void query(){
        List<RbacUser> user = baseMapper.selectList(null);
        System.out.println(user.size());

        System.out.println(baseMapper.selectCount(null));

        System.out.println(baseMapper.selectById(145));
    }
}
