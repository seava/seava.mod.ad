/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "Params_Lov" , {
	extend: "e4e.lov.AbstractCombo",
	alias: "widget.ad_Params_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
	return '<span>{code}, {name}</span>';
	},
	width:350, maxHeight:200
	},
	_editDialog_: {
		name: "MyParam_Ui",
		bundle: Main.bundle.ad
	},
	recordModel: Main.ns.ad + "ParamLov_Ds"
});
