/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.AccessControlDsRpc_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.AccessControlDsRpc_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControlDsRpc_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_AccessControlDsRpc_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"dsName", dataIndex:"dsName", xtype:"ad_DataSourcesDs_Lov"})
		.addLov({name:"accessControl", dataIndex:"accessControl", xtype:"ad_AccessControls_Lov",
			retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1"])
		.addChildrenTo("col1", ["accessControl", "dsName"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControlDsRpc_Dc$EditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControlDsRpc_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"accessControl", dataIndex:"accessControl", width:200, xtype:"gridcolumn", 
			editor:{xtype:"ad_AccessControls_Lov",
				retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]}})
		.addLov({name:"dsName", dataIndex:"dsName", width:200, xtype:"gridcolumn", 
			editor:{xtype:"ad_DataSourcesDs_Lov"}})
		.addLov({name:"serviceMethod", dataIndex:"serviceMethod", width:200, xtype:"gridcolumn", 
			editor:{xtype:"ad_DataSourceRpcs_Lov",
				filterFieldMapping: [{lovField:"dataSourceName", dsField: "dsName"} ]}})
		.addTextColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define("seava.ad.ui.extjs.dc.AccessControlDsRpc_Dc$CtxEditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControlDsRpc_Dc$CtxEditList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"dsName", dataIndex:"dsName", width:200, xtype:"gridcolumn", 
			editor:{xtype:"ad_DataSourcesDs_Lov"}})
		.addLov({name:"serviceMethod", dataIndex:"serviceMethod", width:200, xtype:"gridcolumn", 
			editor:{xtype:"ad_DataSourceRpcs_Lov",
				filterFieldMapping: [{lovField:"dataSourceName", dsField: "dsName"} ]}})
		.addTextColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
