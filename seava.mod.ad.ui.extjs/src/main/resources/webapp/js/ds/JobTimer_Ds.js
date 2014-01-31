/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Main.ns.ad + "JobTimer_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
			{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"startTime", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"endTime", type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"type", type:"string"},
		{name:"cronExpression", type:"string"},
		{name:"repeatCount", type:"int", useNull:true},
		{name:"repeatInterval", type:"int", useNull:true},
		{name:"repeatIntervalType", type:"string"},
		{name:"jobContextId", type:"string"},
		{name:"jobContext", type:"string"},
		{name:"jobName", type:"string"},
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

Main.createFilterModelFromRecordModel({
	fields: [
		{name:"startTime_From",type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"startTime_To",type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"endTime_From",type:"date", dateFormat:Main.MODEL_DATE_FORMAT},
		{name:"endTime_To",type:"date", dateFormat:Main.MODEL_DATE_FORMAT}
	],
	recordModelFqn: Main.ns.ad + "JobTimer_Ds"
});
