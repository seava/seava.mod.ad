/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.frame.AccessControlDsRpc_Ui", {
	extend: "e4e.ui.AbstractUi",
	alias: "widget.AccessControlDsRpc_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("dsAccess", Ext.create(seava.ad.ui.extjs.dc.AccessControlDsRpc_Dc,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("dsAccess", {name:"dsAccessFilter", height:80, xtype:"ad_AccessControlDsRpc_Dc$Filter"})
		.addDcEditGridView("dsAccess", {name:"dsAccessEditList", xtype:"ad_AccessControlDsRpc_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["dsAccessFilter", "dsAccessEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbDsAccessEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbDsAccessEditList", {dc: "dsAccess"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDelete().addCancel()
			.addReports()
		.end();
	}

});
