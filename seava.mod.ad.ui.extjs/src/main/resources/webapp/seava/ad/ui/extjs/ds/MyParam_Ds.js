/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.MyParam_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_MyParam_Ds"
	},
	
	
	validations: [
			{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"defaultValue", type:"string"},
		{name:"listOfValues", type:"string"},
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

Ext.define("seava.ad.ui.extjs.ds.MyParam_DsParam", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"validFrom", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Main.MODEL_DATE_FORMAT}
	]
});
