/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.lov.Params_Lov", {
	extend: "e4e.lov.AbstractCombo",
	alias: "widget.ad_Params_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:350, maxHeight:200
	},
	_editFrame_: {
		name: "seava.ad.ui.extjs.frame.MyParam_Ui",
		bundle: "seava.mod.ad"
	},
	recordModel: seava.ad.ui.extjs.ds.ParamLov_Ds
});
