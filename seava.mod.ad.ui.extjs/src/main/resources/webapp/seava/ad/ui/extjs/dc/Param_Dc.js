/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.Param_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.Param_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.Param_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_Param_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"code", dataIndex:"code", xtype:"ad_Params_Lov", caseRestriction:"uppercase"})
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"defaultValue", dataIndex:"defaultValue"})
		.addTextField({ name:"description", dataIndex:"description"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:220, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["description", "defaultValue"]);
	}
});

/* ================= GRID: List ================= */

Ext.define("seava.ad.ui.extjs.dc.Param_Dc$List", {
	extend: "e4e.dc.view.AbstractDcvGrid",
	alias: "widget.ad_Param_Dc$List",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:200})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"description", dataIndex:"description", width:300})
		.addTextColumn({ name:"defaultValue", dataIndex:"defaultValue", width:200})
		.addTextColumn({ name:"listOfValues", dataIndex:"listOfValues", width:200})
		.addDefaults();
	}
});
