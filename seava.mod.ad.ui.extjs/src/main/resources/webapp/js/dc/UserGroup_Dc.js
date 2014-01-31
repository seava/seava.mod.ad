/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "UserGroup_Dc" , {
	extend: "e4e.dc.AbstractDc",
	recordModel: Main.ns.ad + "UserGroup_Ds"
});

/* ================= FILTER FORM: Filter ================= */

Ext.define(Main.ns.ad + "UserGroup_Dc$Filter" , {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_UserGroup_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"code", dataIndex:"code", xtype:"ad_UserGroups_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:280, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Main.ns.ad + "UserGroup_Dc$EditList" , {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_UserGroup_Dc$EditList",
	_bulkEditFields_: ["active"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});
