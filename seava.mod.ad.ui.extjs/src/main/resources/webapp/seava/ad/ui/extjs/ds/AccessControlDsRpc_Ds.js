/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.AccessControlDsRpc_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_AccessControlDsRpc_Ds"
	},
	
	
	validations: [
		{field: "dsName", type: 'presence'},
		{field: "serviceMethod", type: 'presence'}
	],
	
	fields: [
		{name:"dsName", type:"string"},
		{name:"serviceMethod", type:"string"},
		{name:"accessControlId", type:"string"},
		{name:"accessControl", type:"string"},
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
