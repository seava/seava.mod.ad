/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.TargetRule_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.TargetRule_Ds
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define("seava.ad.ui.extjs.dc.TargetRule_Dc$EditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_TargetRule_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"targetAlias", dataIndex:"targetAlias", width:200})
		.addTextColumn({name:"targetType", dataIndex:"targetType", width:200})
		.addTextColumn({name:"sourceRefId", dataIndex:"sourceRefId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
