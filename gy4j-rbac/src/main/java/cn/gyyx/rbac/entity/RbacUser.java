package cn.gyyx.rbac.entity;

import cn.gyyx.framework.mybatis.annotations.TableField;
import cn.gyyx.framework.mybatis.annotations.TableId;
import cn.gyyx.framework.mybatis.annotations.TableName;
import cn.gyyx.framework.mybatis.entity.BaseEntity;
import cn.gyyx.framework.mybatis.enums.IdType;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@TableName("rbac_user")
public class RbacUser extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 用户表主键id
     */
	@TableId(value="user_id", type= IdType.AUTO)
	private Integer userId;
    /**
     * 来自center_app的user唯一标识
     */
	@TableField("center_user_id")
	private Integer centerUserId;
    /**
     * 用户名称
     */
	@TableField("user_name")
	private String userName;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 密码
     */
	private String password;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private String createTime;
    /**
     * 创建人
     */
	@TableField("create_user_name")
	private String createUserName;
    /**
     * 用户数据来源
     */
	@TableField("user_from")
	private String userFrom;
    /**
     * 用户更新时间
     */
	@TableField("update_time")
	private String updateTime;
    /**
     * 上次登录时间
     */
	@TableField("last_login_time")
	private String lastLoginTime;
    /**
     * 上次登录ip地址
     */
	@TableField("last_login_ip")
	private String lastLoginIp;
    /**
     * 登录次数
     */
	@TableField("login_count")
	private Integer loginCount;
    /**
     * 用户状态（0：正常，1：禁用）
     */
	private Integer status;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCenterUserId() {
		return centerUserId;
	}

	public void setCenterUserId(Integer centerUserId) {
		this.centerUserId = centerUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
