/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.JobLogMessage_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.JobLogMessage_Ds
});

/* ================= GRID: List ================= */

Ext.define("seava.ad.ui.extjs.dc.JobLogMessage_Dc$List", {
	extend: "e4e.dc.view.AbstractDcvGrid",
	alias: "widget.ad_JobLogMessage_Dc$List",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"messageType", dataIndex:"messageType", hidden:true, width:80})
		.addTextColumn({ name:"message", dataIndex:"message", width:400})
		.addDefaults();
	}
});
