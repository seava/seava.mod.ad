/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.DsReportUsageCtx_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.DsReportUsageCtx_Ds
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define("seava.ad.ui.extjs.dc.DsReportUsageCtx_Dc$EditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_DsReportUsageCtx_Dc$EditList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"frameName", dataIndex:"frameName", width:250})
		.addTextColumn({name:"dcKey", dataIndex:"dcKey", width:80})
		.addTextColumn({name:"toolbarKey", dataIndex:"toolbarKey", width:80})
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:80 })
		.addDefaults();
	}
});
