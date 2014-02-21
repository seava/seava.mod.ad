/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.DsReportUsage_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.DsReportUsage_Ds
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define("seava.ad.ui.extjs.dc.DsReportUsage_Dc$CtxEditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_DsReportUsage_Dc$CtxEditList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"frameName", dataIndex:"frameName", width:200})
		.addTextColumn({name:"dcKey", dataIndex:"dcKey", width:200})
		.addTextColumn({name:"toolbarKey", dataIndex:"toolbarKey", width:200})
		.addDefaults();
	}
});
