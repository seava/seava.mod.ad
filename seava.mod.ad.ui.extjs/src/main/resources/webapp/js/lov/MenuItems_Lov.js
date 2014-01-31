/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "MenuItems_Lov" , {
	extend: "e4e.lov.AbstractCombo",
	alias: "widget.ad_MenuItems_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
	return '<span>{name}, {description}, {title}</span>';
	},
	width:250, maxHeight:350
	},
	_editDialog_: {
		name: "Menu_Ui",
		bundle: Main.bundle.ad
	},
	recordModel: Main.ns.ad + "MenuItemLov_Ds"
});
