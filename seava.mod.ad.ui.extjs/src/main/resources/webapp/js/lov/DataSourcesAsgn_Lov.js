/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "DataSourcesAsgn_Lov" , {
	extend: "e4e.lov.AbstractCombo",
	alias: "widget.ad_DataSourcesAsgn_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
	return '<span>{name}, {description}</span>';
	},
	width:250, maxHeight:350
	},
	_editDialog_: {
		name: "DataSource_Ui",
		bundle: Main.bundle.ad
	},
	recordModel: Main.ns.ad + "DataSourceAsgnLov_Ds"
});
