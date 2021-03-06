/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.DsReportParam_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_DsReportParam_Ds"
	},
	
	
	fields: [
		{name:"dsReportId", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"reportId", type:"string"},
		{name:"reportCode", type:"string"},
		{name:"paramId", type:"string"},
		{name:"param", type:"string"},
		{name:"paramTitle", type:"string"},
		{name:"dsField", type:"string"},
		{name:"staticValue", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"version", type:"int", useNull:true},
		{name:"refid", type:"string"},
		{name:"entityAlias", type:"string"},
		{name:"entityFqn", type:"string"}
	]
});
