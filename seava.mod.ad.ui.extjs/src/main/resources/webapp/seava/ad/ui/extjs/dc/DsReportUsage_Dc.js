/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.DsReportUsage_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.DsReportUsage_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.DsReportUsage_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_DsReportUsage_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"report", dataIndex:"report", xtype:"ad_Reports_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "reportId"} ]})
		.addLov({name:"reportName", dataIndex:"reportName", xtype:"ad_ReportsName_Lov",
			retFieldMapping: [{lovField:"id", dsField: "reportId"} ]})
		.addLov({name:"dataSource", dataIndex:"dataSource", xtype:"ad_DataSources_Lov"})
		.addTextField({ name:"frameName", dataIndex:"frameName"})
		.addTextField({ name:"toolbarKey", dataIndex:"toolbarKey"})
		.addTextField({ name:"dcKey", dataIndex:"dcKey"})
		.addNumberField({name:"sequenceNo", dataIndex:"sequenceNo"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["report", "reportName"])
		.addChildrenTo("col2", ["dataSource", "frameName"])
		.addChildrenTo("col3", ["toolbarKey", "dcKey"]);
	}
});

/* ================= EDIT-GRID: List ================= */

Ext.define("seava.ad.ui.extjs.dc.DsReportUsage_Dc$List", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_DsReportUsage_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"report", dataIndex:"report", width:120, xtype:"gridcolumn", 
			editor:{xtype:"ad_Reports_Lov", caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "reportId"} ,{lovField:"name", dsField: "reportName"} ]}})
		.addTextColumn({name:"reportName", dataIndex:"reportName", width:200, noEdit: true})
		.addLov({name:"dataSource", dataIndex:"dataSource", width:150, xtype:"gridcolumn", 
			editor:{xtype:"ad_DsReports_Lov",
				retFieldMapping: [{lovField:"id", dsField: "dsReportId"} ],
				filterFieldMapping: [{lovField:"reportId", dsField: "reportId"} ]}})
		.addTextColumn({name:"frameName", dataIndex:"frameName", width:200, 
			editor: { xtype:"textfield"}})
		.addTextColumn({name:"toolbarKey", dataIndex:"toolbarKey", width:120, 
			editor: { xtype:"textfield"}})
		.addTextColumn({name:"dcKey", dataIndex:"dcKey", width:120, 
			editor: { xtype:"textfield"}})
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", width:80, align:"right" })
		.addTextColumn({name:"dsReportId", dataIndex:"dsReportId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"reportId", dataIndex:"reportId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
