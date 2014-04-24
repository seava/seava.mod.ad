/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.AttachmentType_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.AttachmentType_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.AttachmentType_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_AttachmentType_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addCombo({ xtype:"combo", name:"category", dataIndex:"category", store:[ "link", "upload"]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "category"])
		.addChildrenTo("col2", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define("seava.ad.ui.extjs.dc.AttachmentType_Dc$EditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AttachmentType_Dc$EditList",
	_bulkEditFields_: ["active","description","category","uploadPath","baseUrl"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"name", dataIndex:"name", width:200, 
			editor: { xtype:"textfield"}})
		.addTextColumn({name:"description", dataIndex:"description", width:200, 
			editor: { xtype:"textfield"}})
		.addComboColumn({name:"category", dataIndex:"category", width:80, 
			editor:{xtype:"combo", mode: 'local', triggerAction:'all', forceSelection:true, store:[ "link", "upload"]}})
		.addTextColumn({name:"uploadPath", dataIndex:"uploadPath", width:200, 
			editor: { xtype:"textfield"}})
		.addTextColumn({name:"baseUrl", dataIndex:"baseUrl", width:100, 
			editor: { xtype:"textfield"}})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});
