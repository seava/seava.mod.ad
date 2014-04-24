/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.frame.ReportServer_Ui", {
	extend: "e4e.ui.AbstractUi",
	alias: "widget.ReportServer_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_().addDc("m", Ext.create(seava.ad.ui.extjs.dc.ReportServer_Dc,{multiEdit: true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("m", {name:"mFilter", height:80, xtype:"ad_ReportServer_Dc$Filter"})
		.addDcEditGridView("m", {name:"mEditList", xtype:"ad_ReportServer_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvas1"])
		.addChildrenTo("canvas1", ["mFilter", "mEditList"], ["north", "center"])
		.addToolbarTo("canvas1", "tlbMEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbMEditList", {dc: "m"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDelete().addCancel()
			.addReports()
		.end();
	}

});
