/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "DataSource_Dc" , {
	extend: "e4e.dc.AbstractDc",
	recordModel: Main.ns.ad + "DataSource_Ds"
});

/* ================= FILTER FORM: Filter ================= */

Ext.define(Main.ns.ad + "DataSource_Dc$Filter" , {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_DataSource_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"name", dataIndex:"name", xtype:"ad_DataSources_Lov",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"model", dataIndex:"model"})
		.addBooleanField({ name:"isAsgn", dataIndex:"isAsgn"})
		
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
		.addChildrenTo("col1", ["name", "model"])
		.addChildrenTo("col2", ["isAsgn"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Main.ns.ad + "DataSource_Dc$List" , {
	extend: "e4e.dc.view.AbstractDcvGrid",
	alias: "widget.ad_DataSource_Dc$List",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"model", dataIndex:"model", width:450})
		.addBooleanColumn({ name:"isAsgn", dataIndex:"isAsgn"})
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
		.addDefaults();
	}
});
