/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.DataSourceRpc_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.DataSourceRpc_Ds
});

/* ================= GRID: CtxList ================= */

Ext.define("seava.ad.ui.extjs.dc.DataSourceRpc_Dc$CtxList", {
	extend: "e4e.dc.view.AbstractDcvGrid",
	alias: "widget.ad_DataSourceRpc_Dc$CtxList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addDefaults();
	}
});
