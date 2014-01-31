/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "JobContextParam_Dc" , {
	extend: "e4e.dc.AbstractDc",
	recordModel: Main.ns.ad + "JobContextParam_Ds"
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Main.ns.ad + "JobContextParam_Dc$CtxEditList" , {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_JobContextParam_Dc$CtxEditList",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"paramName", dataIndex:"paramName", width:200, noEdit: true})
		.addTextColumn({name:"dataType", dataIndex:"dataType", width:150, noEdit: true})
		.addTextColumn({name:"value", dataIndex:"value", width:200})
		.addDefaults();
	}
});
