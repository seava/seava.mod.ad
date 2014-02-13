/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.AccessControlDs_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "dsName", type: 'presence'}
	],
	
	fields: [
		{name:"dsName", type:"string"},
		{name:"queryAllowed", type:"boolean"},
		{name:"insertAllowed", type:"boolean"},
		{name:"updateAllowed", type:"boolean"},
		{name:"deleteAllowed", type:"boolean"},
		{name:"importAllowed", type:"boolean"},
		{name:"exportAllowed", type:"boolean"},
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
