package cn.gyyx.rbac.entity;

import cn.gyyx.framework.mybatis.annotations.TableField;
import cn.gyyx.framework.mybatis.annotations.TableId;
import cn.gyyx.framework.mybatis.annotations.TableName;
import cn.gyyx.framework.mybatis.entity.BaseEntity;
import cn.gyyx.framework.mybatis.enums.IdType;

/**
 * <p>
 * 模块权限类
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@TableName("rbac_module")
public class RbacModule extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 模块主键id
     */
	@TableId(value="module_id", type= IdType.AUTO)
	private Integer moduleId;
    /**
     * 模块名称
     */
	@TableField("module_name")
	private String moduleName;
    /**
     * 图标
     */
	@TableField("module_icon")
	private String moduleIcon;
    /**
     * 排序
     */
	@TableField("module_sort")
	private Integer moduleSort;
    /**
     * 启用状态（0：正常，1：禁用）
     */
	@TableField("module_status")
	private Integer moduleStatus;


	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleIcon() {
		return moduleIcon;
	}

	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}

	public Integer getModuleSort() {
		return moduleSort;
	}

	public void setModuleSort(Integer moduleSort) {
		this.moduleSort = moduleSort;
	}

	public Integer getModuleStatus() {
		return moduleStatus;
	}

	public void setModuleStatus(Integer moduleStatus) {
		this.moduleStatus = moduleStatus;
	}


}
