/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.ParamValue_Dc", {
	extend: "e4e.dc.AbstractDc",
	paramModel: seava.ad.ui.extjs.ds.ParamValue_DsParam,
	recordModel: seava.ad.ui.extjs.ds.ParamValue_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.ParamValue_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_ParamValue_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"sysparam", dataIndex:"sysParam", xtype:"ad_Params_Lov", caseRestriction:"uppercase"})
		.addDateField({name:"validAt", paramIndex:"validAt"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["sysparam"])
		.addChildrenTo("col2", ["validAt"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define("seava.ad.ui.extjs.dc.ParamValue_Dc$EditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_ParamValue_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"sysparam", dataIndex:"sysParam", width:250, xtype:"gridcolumn", 
			editor:{xtype:"ad_Params_Lov", caseRestriction:"uppercase"}})
		.addTextColumn({name:"value", dataIndex:"value", width:350, 
			editor: { xtype:"textfield"}})
		.addDateColumn({name:"validFrom", dataIndex:"validFrom", _mask_: Masks.DATE })
		.addDateColumn({name:"validTo", dataIndex:"validTo", _mask_: Masks.DATE })
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define("seava.ad.ui.extjs.dc.ParamValue_Dc$CtxEditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_ParamValue_Dc$CtxEditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"value", dataIndex:"value", width:350, 
			editor: { xtype:"textfield"}})
		.addDateColumn({name:"validFrom", dataIndex:"validFrom", _mask_: Masks.DATE })
		.addDateColumn({name:"validTo", dataIndex:"validTo", _mask_: Masks.DATE })
		.addDefaults();
	}
});
