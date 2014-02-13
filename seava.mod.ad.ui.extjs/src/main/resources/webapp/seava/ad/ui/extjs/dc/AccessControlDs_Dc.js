/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.AccessControlDs_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.AccessControlDs_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControlDs_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_AccessControlDs_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"dsName", dataIndex:"dsName", xtype:"ad_DataSourcesDs_Lov"})
		.addLov({name:"accessControl", dataIndex:"accessControl", xtype:"ad_AccessControls_Lov",
			retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]})
		.addBooleanField({ name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanField({ name:"insertAllowed", dataIndex:"insertAllowed"})
		.addBooleanField({ name:"updateAllowed", dataIndex:"updateAllowed"})
		.addBooleanField({ name:"deleteAllowed", dataIndex:"deleteAllowed"})
		.addBooleanField({ name:"importAllowed", dataIndex:"importAllowed"})
		.addBooleanField({ name:"exportAllowed", dataIndex:"exportAllowed"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:180, layout:"form"})
		.addPanel({ name:"col3", width:180, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["accessControl", "dsName"])
		.addChildrenTo("col2", ["queryAllowed", "importAllowed", "exportAllowed"])
		.addChildrenTo("col3", ["insertAllowed", "updateAllowed", "deleteAllowed"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControlDs_Dc$EditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControlDs_Dc$EditList",
	_bulkEditFields_: ["queryAllowed","insertAllowed","updateAllowed","deleteAllowed","importAllowed","exportAllowed"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"accessControl", dataIndex:"accessControl", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_AccessControls_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]}})
		.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_DataSourcesDs_Lov", selectOnFocus:true}})
		.addBooleanColumn({name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({name:"insertAllowed", dataIndex:"insertAllowed"})
		.addBooleanColumn({name:"updateAllowed", dataIndex:"updateAllowed"})
		.addBooleanColumn({name:"deleteAllowed", dataIndex:"deleteAllowed"})
		.addBooleanColumn({name:"importAllowed", dataIndex:"importAllowed"})
		.addBooleanColumn({name:"exportAllowed", dataIndex:"exportAllowed"})
		.addTextColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControlDs_Dc$CtxEditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControlDs_Dc$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	_bulkEditFields_: ["queryAllowed","insertAllowed","updateAllowed","deleteAllowed","importAllowed","exportAllowed"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_DataSourcesDs_Lov", selectOnFocus:true}})
		.addBooleanColumn({name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({name:"insertAllowed", dataIndex:"insertAllowed"})
		.addBooleanColumn({name:"updateAllowed", dataIndex:"updateAllowed"})
		.addBooleanColumn({name:"deleteAllowed", dataIndex:"deleteAllowed"})
		.addBooleanColumn({name:"importAllowed", dataIndex:"importAllowed"})
		.addBooleanColumn({name:"exportAllowed", dataIndex:"exportAllowed"})
		.addTextColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
