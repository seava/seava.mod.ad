/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.Menu;
import seava.ad.domain.impl.security.MenuItem;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractType_Ds;

@Ds(entity = MenuItem.class, sort = {@SortField(field = MenuItem_Ds.f_name)})
@RefLookups({
		@RefLookup(refId = MenuItem_Ds.f_menuItemId, namedQuery = MenuItem.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = MenuItem_Ds.f_menuItem)}),
		@RefLookup(refId = MenuItem_Ds.f_menuId, namedQuery = Menu.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = MenuItem_Ds.f_menu)})})
public class MenuItem_Ds extends AbstractType_Ds<MenuItem> {

	public static final String ALIAS = "ad_MenuItem_Ds";

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_title = "title";
	public static final String f_frame = "frame";
	public static final String f_bundle = "bundle";
	public static final String f_iconUrl = "iconUrl";
	public static final String f_separatorBefore = "separatorBefore";
	public static final String f_separatorAfter = "separatorAfter";
	public static final String f_menuId = "menuId";
	public static final String f_menu = "menu";
	public static final String f_menuItemId = "menuItemId";
	public static final String f_menuItem = "menuItem";

	@DsField
	private Integer sequenceNo;

	@DsField
	private String title;

	@DsField
	private String frame;

	@DsField
	private String bundle;

	@DsField
	private String iconUrl;

	@DsField
	private Boolean separatorBefore;

	@DsField
	private Boolean separatorAfter;

	@DsField(join = "left", path = "menu.id")
	private String menuId;

	@DsField(join = "left", path = "menu.name")
	private String menu;

	@DsField(join = "left", path = "menuItem.id")
	private String menuItemId;

	@DsField(join = "left", path = "menuItem.name")
	private String menuItem;

	public MenuItem_Ds() {
		super();
	}

	public MenuItem_Ds(MenuItem e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getBundle() {
		return this.bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Boolean getSeparatorBefore() {
		return this.separatorBefore;
	}

	public void setSeparatorBefore(Boolean separatorBefore) {
		this.separatorBefore = separatorBefore;
	}

	public Boolean getSeparatorAfter() {
		return this.separatorAfter;
	}

	public void setSeparatorAfter(Boolean separatorAfter) {
		this.separatorAfter = separatorAfter;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenu() {
		return this.menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getMenuItemId() {
		return this.menuItemId;
	}

	public void setMenuItemId(String menuItemId) {
		this.menuItemId = menuItemId;
	}

	public String getMenuItem() {
		return this.menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}
}
