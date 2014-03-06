/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.lov.DsReports_Lov", {
	extend: "e4e.lov.AbstractCombo",
	alias: "widget.ad_DsReports_Lov",
	displayField: "dataSource",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{dataSource}</span>';
		},
		width:250, maxHeight:350
	},
	_editFrame_: {
		name: "seava.ad.ui.extjs.frame.Report_Ui",
		bundle: "seava.mod.ad"
	},
	recordModel: seava.ad.ui.extjs.ds.DsReportLov_Ds
});
