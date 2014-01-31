/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "AccessControlDsRpc_Dc" , {
	extend: "e4e.dc.AbstractDc",
	recordModel: Main.ns.ad + "AccessControlDsRpc_Ds"
});

/* ================= FILTER FORM: Filter ================= */

Ext.define(Main.ns.ad + "AccessControlDsRpc_Dc$Filter" , {
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

Ext.define(Main.ns.ad + "AccessControlDsRpc_Dc$EditList" , {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControlDsRpc_Dc$EditList",

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
		.addLov({name:"serviceMethod", dataIndex:"serviceMethod", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_DataSourceRpcs_Lov", selectOnFocus:true,
				filterFieldMapping: [{lovField:"dataSourceName", dsField: "dsName"} ]}})
		.addTextColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Main.ns.ad + "AccessControlDsRpc_Dc$CtxEditList" , {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControlDsRpc_Dc$CtxEditList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_DataSourcesDs_Lov", selectOnFocus:true}})
		.addLov({name:"serviceMethod", dataIndex:"serviceMethod", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_DataSourceRpcs_Lov", selectOnFocus:true,
				filterFieldMapping: [{lovField:"dataSourceName", dsField: "dsName"} ]}})
		.addTextColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
