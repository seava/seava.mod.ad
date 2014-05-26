/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.DataSourceFieldLov_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_DataSourceFieldLov_Ds"
	},
	
	
	fields: [
		{name:"dataType", type:"string"},
		{name:"dataSourceId", type:"string"},
		{name:"dataSourceName", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"refid", type:"string"}
	]
});
