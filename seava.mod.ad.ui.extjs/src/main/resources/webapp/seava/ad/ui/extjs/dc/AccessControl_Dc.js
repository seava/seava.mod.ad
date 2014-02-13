/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.AccessControl_Dc", {
	extend: "e4e.dc.AbstractDc",
	paramModel: seava.ad.ui.extjs.ds.AccessControl_DsParam,
	recordModel: seava.ad.ui.extjs.ds.AccessControl_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControl_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_AccessControl_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"name", dataIndex:"name", xtype:"ad_AccessControls_Lov",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({name:"withRole", paramIndex:"withRole", xtype:"ad_Roles_Lov",
			retFieldMapping: [{lovField:"id", dsParam: "withRoleId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "withRole"])
		.addChildrenTo("col2", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControl_Dc$EditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControl_Dc$EditList",
	_bulkEditFields_: ["active","description"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"description", dataIndex:"description", width:300})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});

/* ================= EDIT FORM: CopyRulesFromSource ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControl_Dc$CopyRulesFromSource", {
	extend: "e4e.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_AccessControl_Dc$CopyRulesFromSource",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"copyFrom", paramIndex:"copyFrom", xtype:"ad_AccessControls_Lov",
			retFieldMapping: [{lovField:"id", dsParam: "copyFromId"} ]})
		.addBooleanField({ name:"skipDs", paramIndex:"skipDs"})
		.addBooleanField({ name:"skipAsgn", paramIndex:"skipAsgn"})
		.addBooleanField({ name:"resetRules", paramIndex:"resetRules"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["copyFrom", "skipDs", "skipAsgn", "resetRules"]);
	}
});
