/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "UserGroups_Lov" , {
	extend: "e4e.lov.AbstractCombo",
	alias: "widget.ad_UserGroups_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
	return '<span>{code}, {name}</span>';
	},
	width:250, maxHeight:350
	},
	_editDialog_: {
		name: "UserGroup_Ui",
		bundle: Main.bundle.ad
	},
	recordModel: Main.ns.ad + "UserGroupLov_Ds"
});
