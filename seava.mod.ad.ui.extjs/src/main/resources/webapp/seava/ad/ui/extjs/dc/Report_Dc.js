/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.Report_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.Report_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.Report_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_Report_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
		.addLov({name:"reportServer", dataIndex:"reportServer", xtype:"ad_ReportServers_Lov",
			retFieldMapping: [{lovField:"id", dsField: "reportServerId"} ]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addTextField({ name:"contextPath", dataIndex:"contextPath"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["name", "code"])
		.addChildrenTo("col2", ["reportServer", "contextPath"])
		.addChildrenTo("col3", ["active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define("seava.ad.ui.extjs.dc.Report_Dc$List", {
	extend: "e4e.dc.view.AbstractDcvGrid",
	alias: "widget.ad_Report_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"code", dataIndex:"code", width:120})
		.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
		.addTextColumn({ name:"reportServer", dataIndex:"reportServer", width:200})
		.addTextColumn({ name:"contextPath", dataIndex:"contextPath", width:200})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"reportServerId", dataIndex:"reportServerId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define("seava.ad.ui.extjs.dc.Report_Dc$Edit", {
	extend: "e4e.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_Report_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
		.addTextField({ name:"code", dataIndex:"code", allowBlank:false, caseRestriction:"uppercase"})
		.addTextField({ name:"contextPath", dataIndex:"contextPath"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addTextArea({ name:"notes", dataIndex:"notes", height:60})
		.addLov({name:"reportServer", dataIndex:"reportServer", allowBlank:false, xtype:"ad_ReportServers_Lov",
			retFieldMapping: [{lovField:"id", dsField: "reportServerId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"})
		.addPanel({ name:"col2", width:500, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "code", "reportServer", "active"])
		.addChildrenTo("col2", ["contextPath", "notes"]);
	}
});
