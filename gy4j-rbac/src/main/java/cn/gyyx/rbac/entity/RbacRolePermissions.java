package cn.gyyx.rbac.entity;

import cn.gyyx.framework.mybatis.annotations.TableField;
import cn.gyyx.framework.mybatis.annotations.TableId;
import cn.gyyx.framework.mybatis.annotations.TableName;
import cn.gyyx.framework.mybatis.entity.BaseEntity;
import cn.gyyx.framework.mybatis.enums.IdType;

/**
 * <p>
 * 角色-权限中间表
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@TableName("rbac_role_permissions")
public class RbacRolePermissions extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 角色-权限中间表，主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 角色id
     */
	@TableField("role_id")
	private Integer roleId;
    /**
     * 权限id
     */
	@TableField("permissions_id")
	private Integer permissionsId;
    /**
     * 权限类型（1：模块，2：菜单，3：按钮）
     */
	@TableField("permissions_type")
	private Integer permissionsType;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionsId() {
		return permissionsId;
	}

	public void setPermissionsId(Integer permissionsId) {
		this.permissionsId = permissionsId;
	}

	public Integer getPermissionsType() {
		return permissionsType;
	}

	public void setPermissionsType(Integer permissionsType) {
		this.permissionsType = permissionsType;
	}

}
