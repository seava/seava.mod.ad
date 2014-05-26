/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.MenuItem_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_MenuItem_Ds"
	},
	
	
	validations: [
		{field: "sequenceNo", type: 'presence'},
		{field: "name", type: 'presence'},
		{field: "title", type: 'presence'}
	],
	
	fields: [
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"title", type:"string"},
		{name:"frame", type:"string"},
		{name:"bundle", type:"string"},
		{name:"iconUrl", type:"string"},
		{name:"separatorBefore", type:"boolean"},
		{name:"separatorAfter", type:"boolean"},
		{name:"menuId", type:"string"},
		{name:"menu", type:"string"},
		{name:"menuItemId", type:"string"},
		{name:"menuItem", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"clientId", type:"string"},
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

Ext.define("seava.ad.ui.extjs.ds.MenuItem_DsParam", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"foldersOnly", type:"boolean", forFilter:true},
		{name:"framesOnly", type:"boolean", forFilter:true}
	]
});
