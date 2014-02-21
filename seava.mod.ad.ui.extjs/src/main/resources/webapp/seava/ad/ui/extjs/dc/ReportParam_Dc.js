/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.ReportParam_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.ReportParam_Ds
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define("seava.ad.ui.extjs.dc.ReportParam_Dc$CtxEditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_ReportParam_Dc$CtxEditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"reportCode", dataIndex:"reportCode", hidden:true, width:60, caseRestriction:"uppercase"})
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right" })
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"title", dataIndex:"title", width:200})
		.addComboColumn({name:"dataType", dataIndex:"dataType", width:100, 
			editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "string", "text", "integer", "decimal", "boolean", "date"]}})
		.addTextColumn({name:"listOfValues", dataIndex:"listOfValues", width:100})
		.addTextColumn({name:"defaultValue", dataIndex:"defaultValue", width:100})
		.addBooleanColumn({name:"mandatory", dataIndex:"mandatory", width:60})
		.addBooleanColumn({name:"noEdit", dataIndex:"noEdit", width:60})
		.addBooleanColumn({name:"active", dataIndex:"active", width:60})
		.addTextColumn({name:"notes", dataIndex:"notes", hidden:true, width:200})
		.addDefaults();
	}
});
