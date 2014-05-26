/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.Client_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_Client_Ds"
	},
	
	
	validations: [
			{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"workspacePath", type:"string"},
		{name:"importPath", type:"string"},
		{name:"exportPath", type:"string"},
		{name:"tempPath", type:"string"},
		{name:"adminRole", type:"string"},
		{name:"id", type:"string"},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"createdAt", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"refid", type:"string"},
		{name:"entityAlias", type:"string"},
		{name:"entityFqn", type:"string"}
	]
});

Ext.define("seava.ad.ui.extjs.ds.Client_DsParam", {
	extend: 'Ext.data.Model',
	
	initParam: function() {
		this.set("adminUserCode", "ADMIN");
		this.set("adminUserName", "Administrator");
		this.set("adminUserLogin", "admin");
	},
	
	fields: [
		{name:"adminPassword", type:"string"},
		{name:"adminUserCode", type:"string"},
		{name:"adminUserLogin", type:"string"},
		{name:"adminUserName", type:"string"},
		{name:"initFileLocation", type:"string"}
	]
});
