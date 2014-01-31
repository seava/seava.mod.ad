/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Main.ns.ad + "ViewStateRtLov_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"cmp", type:"string"},
		{name:"cmpType", type:"string"},
		{name:"value", type:"string"},
		{name:"owner", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"refid", type:"string"}
	]
});

Ext.define(Main.ns.ad + "ViewStateRtLov_DsParam", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"hideMine", type:"boolean"},
		{name:"hideOthers", type:"boolean"}
	]
});
