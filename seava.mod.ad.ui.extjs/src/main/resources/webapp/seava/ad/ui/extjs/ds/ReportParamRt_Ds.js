/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.ReportParamRt_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_ReportParamRt_Ds"
	},
	
	
	validations: [
			{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"reportId", type:"string"},
		{name:"report", type:"string"},
		{name:"value", type:"string"},
		{name:"dataType", type:"string"},
		{name:"title", type:"string"},
		{name:"listOfValues", type:"string"},
		{name:"noEdit", type:"boolean"},
		{name:"mandatory", type:"boolean"},
		{name:"sequenceNo", type:"int", useNull:true},
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
