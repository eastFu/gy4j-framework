package cn.gyyx.rbac.entity;

import cn.gyyx.framework.mybatis.annotations.TableField;
import cn.gyyx.framework.mybatis.annotations.TableId;
import cn.gyyx.framework.mybatis.annotations.TableName;
import cn.gyyx.framework.mybatis.entity.BaseEntity;
import cn.gyyx.framework.mybatis.enums.IdType;

/**
 * <p>
 * 按钮权限表
 * </p>
 *
 * @author east.Fu
 * @since 2017-10-24
 */
@TableName("rbac_button")
public class RbacButton extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 按钮主键id
     */
	@TableId(value="button_id", type= IdType.AUTO)
	private Integer buttonId;
    /**
     * 按钮名称
     */
	@TableField("button_name")
	private String buttonName;
    /**
     * 图标
     */
	@TableField("button_icon")
	private String buttonIcon;
    /**
     * 所属菜单id
     */
	@TableField("menu_id_f")
	private Integer menuIdF;
    /**
     * 按钮事件url
     */
	@TableField("button_url")
	private String buttonUrl;
    /**
     * 启用状态（0：正常，1：禁用）
     */
	@TableField("button_status")
	private Integer buttonStatus;
    /**
     * 点击按钮执行的js函数名称
     */
	@TableField("button_handler")
	private String buttonHandler;


	public Integer getButtonId() {
		return buttonId;
	}

	public void setButtonId(Integer buttonId) {
		this.buttonId = buttonId;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getButtonIcon() {
		return buttonIcon;
	}

	public void setButtonIcon(String buttonIcon) {
		this.buttonIcon = buttonIcon;
	}

	public Integer getMenuIdF() {
		return menuIdF;
	}

	public void setMenuIdF(Integer menuIdF) {
		this.menuIdF = menuIdF;
	}

	public String getButtonUrl() {
		return buttonUrl;
	}

	public void setButtonUrl(String buttonUrl) {
		this.buttonUrl = buttonUrl;
	}

	public Integer getButtonStatus() {
		return buttonStatus;
	}

	public void setButtonStatus(Integer buttonStatus) {
		this.buttonStatus = buttonStatus;
	}

	public String getButtonHandler() {
		return buttonHandler;
	}

	public void setButtonHandler(String buttonHandler) {
		this.buttonHandler = buttonHandler;
	}


}
