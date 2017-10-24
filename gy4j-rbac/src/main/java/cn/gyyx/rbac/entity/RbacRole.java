package cn.gyyx.rbac.entity;

import cn.gyyx.framework.mybatis.annotations.TableField;
import cn.gyyx.framework.mybatis.annotations.TableId;
import cn.gyyx.framework.mybatis.annotations.TableName;
import cn.gyyx.framework.mybatis.entity.BaseEntity;
import cn.gyyx.framework.mybatis.enums.IdType;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@TableName("rbac_role")
public class RbacRole extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
	@TableId(value="role_id", type= IdType.AUTO)
	private Integer roleId;
	@TableField("role_name")
	private String roleName;
    /**
     * 角色描述
     */
	@TableField("role_describe")
	private String roleDescribe;
    /**
     * 创建时间
     */
	@TableField("role_create_time")
	private String roleCreateTime;
	@TableField("role_create_user_name")
	private String roleCreateUserName;
    /**
     * 是否为系统角色（0：否，1：是）
     */
	@TableField("is_system")
	private Integer isSystem;
    /**
     * 该角色的用户数
     */
	@TableField("user_count")
	private Integer userCount;
    /**
     * 该角色的状态（0：正常，1禁用）
     */
	@TableField("role_status")
	private Integer roleStatus;


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescribe() {
		return roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}

	public String getRoleCreateTime() {
		return roleCreateTime;
	}

	public void setRoleCreateTime(String roleCreateTime) {
		this.roleCreateTime = roleCreateTime;
	}

	public String getRoleCreateUserName() {
		return roleCreateUserName;
	}

	public void setRoleCreateUserName(String roleCreateUserName) {
		this.roleCreateUserName = roleCreateUserName;
	}

	public Integer getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public Integer getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}

}
