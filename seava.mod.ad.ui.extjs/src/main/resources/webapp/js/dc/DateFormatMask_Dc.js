/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "DateFormatMask_Dc" , {
	extend: "e4e.dc.AbstractDc",
	recordModel: Main.ns.ad + "DateFormatMask_Ds"
});

/* ================= FILTER FORM: Filter ================= */

Ext.define(Main.ns.ad + "DateFormatMask_Dc$Filter" , {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_DateFormatMask_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"dateFormat", dataIndex:"dateFormat", xtype:"ad_DateFormats_Lov",
			retFieldMapping: [{lovField:"id", dsField: "dateFormatId"} ]})
		.addTextField({ name:"mask", dataIndex:"mask", maxLength:32, caseRestriction:"uppercase"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["dateFormat", "mask"])
		.addChildrenTo("col2", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Main.ns.ad + "DateFormatMask_Dc$EditList" , {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_DateFormatMask_Dc$EditList",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"dateFormat", dataIndex:"dateFormat", width:100, noEdit: true})
		.addTextColumn({name:"mask", dataIndex:"mask", width:250, maxLength:32, caseRestriction:"uppercase", noEdit: true})
		.addTextColumn({name:"value", dataIndex:"value", width:300})
		.addTextColumn({name:"dateFormatId", dataIndex:"dateFormatId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Main.ns.ad + "DateFormatMask_Dc$CtxEditList" , {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_DateFormatMask_Dc$CtxEditList",
	_noImport_: true,
	_noPrint_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"mask", dataIndex:"mask", width:250, maxLength:32, caseRestriction:"uppercase", noEdit: true})
		.addTextColumn({name:"value", dataIndex:"value", width:300})
		.addTextColumn({name:"dateFormatId", dataIndex:"dateFormatId", hidden:true, width:100})
		.addDefaults();
	}
});
