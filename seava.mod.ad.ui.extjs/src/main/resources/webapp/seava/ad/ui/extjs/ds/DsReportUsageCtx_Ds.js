/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.DsReportUsageCtx_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"dsReportId", type:"string"},
		{name:"reportId", type:"string"},
		{name:"report", type:"string"},
		{name:"frameName", type:"string"},
		{name:"toolbarKey", type:"string"},
		{name:"dcKey", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
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
