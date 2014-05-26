/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define("seava.ad.ui.extjs.ds.FrameExtension_Ds", {
	extend: 'Ext.data.Model',
	
	statics: {
		ALIAS: "ad_FrameExtension_Ds"
	},
	
	
	validations: [
		{field: "frame", type: 'presence'},
		{field: "sequenceNo", type: 'presence'},
		{field: "fileLocation", type: 'presence'}
	],
	
	fields: [
		{name:"frame", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"fileLocation", type:"string"},
		{name:"relativePath", type:"boolean"},
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
