/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.DsReportLov_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_DsReportLov_Ds"
	},
	
	
	fields: [
		{name:"reportId", type:"string"},
		{name:"reportCode", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"refid", type:"string"}
	]
});
