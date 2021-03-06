/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.lov.Jobs_Lov", {
	extend: "e4e.lov.AbstractCombo",
	alias: "widget.ad_Jobs_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250, maxHeight:350
	},
	_editFrame_: {
		name: "seava.ad.ui.extjs.frame.Job_Ui",
		bundle: "seava.mod.ad"
	},
	recordModel: seava.ad.ui.extjs.ds.JobLov_Ds
});
