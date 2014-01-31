/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Main.ns.ad + "DbChangeLog_Ui" , {
	extend: "e4e.ui.AbstractUi",
	alias: "widget.DbChangeLog_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("dblog", Ext.create(Main.ns.ad + "DbChangeLog_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("dblog", {name:"dblogFilter", xtype:"ad_DbChangeLog_Dc$Filter"})
		.addDcGridView("dblog", {name:"dblogList", xtype:"ad_DbChangeLog_Dc$List"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["dblogFilter", "dblogList"], ["north", "center"])
		.addToolbarTo("main", "tlbdblogList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbdblogList", {dc: "dblog"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addReports()
		.end();
	}

});
