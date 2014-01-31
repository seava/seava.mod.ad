/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Main.ns.ad + "JobLog_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"startTime", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"endTime", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"jobContextId", type:"string"},
		{name:"jobContext", type:"string"},
		{name:"jobName", type:"string"},
		{name:"jobTimerId", type:"string"},
		{name:"jobTimer", type:"string"},
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

Main.createFilterModelFromRecordModel({
	fields: [
		{name:"startTime_From",type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"startTime_To",type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"endTime_From",type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"endTime_To",type:"date", dateFormat:Main.MODEL_DATE_FORMAT}
	],
	recordModelFqn: Main.ns.ad + "JobLog_Ds"
});
