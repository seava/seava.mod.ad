/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.DsReport_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.DsReport_Ds
});

/* ================= EDIT-GRID: ReportCtxList ================= */

Ext.define("seava.ad.ui.extjs.dc.DsReport_Dc$ReportCtxList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_DsReport_Dc$ReportCtxList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"reportId", dataIndex:"reportId", hidden:true, width:100, 
			editor: { xtype:"textfield"}})
		.addLov({name:"dataSource", dataIndex:"dataSource", width:200, noUpdate: true, xtype:"gridcolumn", 
			editor:{xtype:"ad_DataSources_Lov", noUpdate:true}})
		.addDefaults();
	}
});
