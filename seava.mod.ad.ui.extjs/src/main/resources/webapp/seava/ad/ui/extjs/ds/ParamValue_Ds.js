/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.ParamValue_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "sysParam", type: 'presence'},
		{field: "validFrom", type: 'presence'},
		{field: "validTo", type: 'presence'}
	],
	
	fields: [
		{name:"sysParam", type:"string"},
		{name:"value", type:"string"},
		{name:"validFrom", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
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

Ext.define("seava.ad.ui.extjs.ds.ParamValue_DsParam", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"validAt", type:"date", forFilter:true, dateFormat:Main.MODEL_DATE_FORMAT}
	]
});
