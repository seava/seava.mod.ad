/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.DsReportParam_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.DsReportParam_Ds
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define("seava.ad.ui.extjs.dc.DsReportParam_Dc$CtxEditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_DsReportParam_Dc$CtxEditList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"param", dataIndex:"param", width:200, xtype:"gridcolumn", 
			editor:{xtype:"ad_ReportParams_Lov",
				retFieldMapping: [{lovField:"id", dsField: "paramId"} ,{lovField:"title", dsField: "paramTitle"} ],
				filterFieldMapping: [{lovField:"reportId", dsField: "reportId"} ]}})
		.addTextColumn({name:"paramTitle", dataIndex:"paramTitle", width:200, noEdit: true})
		.addLov({name:"dsField", dataIndex:"dsField", width:200, xtype:"gridcolumn", 
			editor:{xtype:"ad_DataSourceFields_Lov",
				filterFieldMapping: [{lovField:"dataSourceName", dsField: "dataSource"} ]}})
		.addTextColumn({name:"staticValue", dataIndex:"staticValue", width:200, 
			editor: { xtype:"textfield"}})
		.addDefaults();
	}
});
