/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.frame.ReportUsage_Ui", {
	extend: "e4e.ui.AbstractUi",
	alias: "widget.ReportUsage_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("ru", Ext.create(seava.ad.ui.extjs.dc.DsReportUsage_Dc,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("ru", {name:"ruFilter", xtype:"ad_DsReportUsage_Dc$Filter"})
		.addDcEditGridView("ru", {name:"ruList", xtype:"ad_DsReportUsage_Dc$List", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["ruFilter", "ruList"], ["north", "center"])
		.addToolbarTo("main", "tlbRuList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbRuList", {dc: "ru"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDelete().addCancel()
			.addReports()
		.end();
	}

});
