package cn.gyyx.rbac.entity;

import cn.gyyx.framework.mybatis.annotations.TableField;
import cn.gyyx.framework.mybatis.annotations.TableId;
import cn.gyyx.framework.mybatis.annotations.TableName;
import cn.gyyx.framework.mybatis.entity.BaseEntity;
import cn.gyyx.framework.mybatis.enums.IdType;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@TableName("rbac_menu")
public class RbacMenu extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 菜单主键id
     */
	@TableId(value="menu_id", type= IdType.AUTO)
	private Integer menuId;
    /**
     * 菜单名称
     */
	@TableField("menu_name")
	private String menuName;
    /**
     * 菜单时间url
     */
	@TableField("menu_url")
	private String menuUrl;
    /**
     * 所属模块id
     */
	@TableField("module_id_f")
	private Integer moduleIdF;
    /**
     * 在同级中的排序
     */
	@TableField("menu_sort")
	private Integer menuSort;
    /**
     * 图标
     */
	@TableField("menu_icon")
	private String menuIcon;
    /**
     * 启用状态（0：正常，1：禁用）
     */
	@TableField("menu_status")
	private Integer menuStatus;


	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getModuleIdF() {
		return moduleIdF;
	}

	public void setModuleIdF(Integer moduleIdF) {
		this.moduleIdF = moduleIdF;
	}

	public Integer getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(Integer menuStatus) {
		this.menuStatus = menuStatus;
	}


}
