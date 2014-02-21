/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.DsReportParamRt_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"dsReportId", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"reportId", type:"string"},
		{name:"reportCode", type:"string"},
		{name:"paramId", type:"string"},
		{name:"param", type:"string"},
		{name:"paramDataType", type:"string"},
		{name:"paramMandatory", type:"boolean"},
		{name:"paramDefaultValue", type:"string"},
		{name:"paramListOfValues", type:"string"},
		{name:"paramNoEdit", type:"boolean"},
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
