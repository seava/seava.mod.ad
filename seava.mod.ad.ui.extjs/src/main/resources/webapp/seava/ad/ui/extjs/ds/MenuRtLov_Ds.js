/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.MenuRtLov_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_MenuRtLov_Ds"
	},
	
	
	fields: [
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"title", type:"string"},
		{name:"tag", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"refid", type:"string"}
	]
});
