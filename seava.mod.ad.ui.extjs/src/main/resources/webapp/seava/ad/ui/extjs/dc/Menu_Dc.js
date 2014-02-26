/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.Menu_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.Menu_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.Menu_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_Menu_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"name", dataIndex:"name", xtype:"ad_Menus_Lov",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"title", dataIndex:"title"})
		.addCombo({ xtype:"combo", name:"tag", dataIndex:"tag", store:[ "top", "left"]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "title"])
		.addChildrenTo("col2", ["tag", "active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define("seava.ad.ui.extjs.dc.Menu_Dc$EditList", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_Menu_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70 })
		.addTextColumn({name:"name", dataIndex:"name", width:100})
		.addTextColumn({name:"title", dataIndex:"title", width:200})
		.addComboColumn({name:"tag", dataIndex:"tag", width:80, 
			editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "top", "left"]}})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});
