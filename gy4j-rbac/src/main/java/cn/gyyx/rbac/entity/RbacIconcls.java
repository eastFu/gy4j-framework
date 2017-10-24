package cn.gyyx.rbac.entity;

import cn.gyyx.framework.mybatis.annotations.TableName;
import cn.gyyx.framework.mybatis.entity.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@TableName("rbac_iconcls")
public class RbacIconcls extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 图标样式的class名称
     */
	private String iconCls;


	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}


}
