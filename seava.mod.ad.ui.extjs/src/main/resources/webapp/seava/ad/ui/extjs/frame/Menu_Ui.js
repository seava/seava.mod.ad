/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.frame.Menu_Ui", {
	extend: "e4e.ui.AbstractUi",
	alias: "widget.Menu_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_().addDc("menuitem", Ext.create(seava.ad.ui.extjs.dc.MenuItem_Dc,{multiEdit: true}))
		.addDc("menu", Ext.create(seava.ad.ui.extjs.dc.Menu_Dc,{multiEdit: true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnAsgnItemRoles", disabled:true, handler: this.onBtnAsgnItemRoles,
				stateManager:{ name:"selected_one_clean", dc:"menuitem" }, scope:this})
		.addButton({name:"btnAsgnMenuRoles", disabled:true, handler: this.onBtnAsgnMenuRoles,
				stateManager:{ name:"selected_one_clean", dc:"menu" }, scope:this})
		.addDcFilterFormView("menu", {name:"menuFilter", xtype:"ad_Menu_Dc$Filter"})
		.addDcEditGridView("menu", {name:"menuEditList", xtype:"ad_Menu_Dc$EditList", frame:true})
		.addDcFilterFormView("menuitem", {name:"menuitemFilter", xtype:"ad_MenuItem_Dc$Filter"})
		.addDcEditGridView("menuitem", {name:"menuitemList", xtype:"ad_MenuItem_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvasMenu", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvasItem", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}}).addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
					listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
			})
		.addToc(["canvasItem:menuitem","canvasMenu:menu"]);
		this._mainViewName_  = "_main_with_toc_";
		;
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvasItem", "canvasMenu"])
		.addChildrenTo("canvasMenu", ["menuFilter", "menuEditList"], ["north", "center"])
		.addChildrenTo("canvasItem", ["menuitemFilter", "menuitemList"], ["north", "center"])
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
		.addToolbarTo("canvasMenu", "tlbMenuEditList")
		.addToolbarTo("canvasItem", "tlbMenuitemList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbMenuEditList", {dc: "menu"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDelete().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnAsgnMenuRoles") ])
			.addReports()
		.end()
		.beginToolbar("tlbMenuitemList", {dc: "menuitem"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDelete().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnAsgnItemRoles") ])
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnAsgnItemRoles
	 */
	,onBtnAsgnItemRoles: function() {
		this._showAsgnWindow_("seava.ad.ui.extjs.asgn.MenuItem_Role_Asgn$Ui" ,{dc: "menuitem", objectIdField: "id"});
	}
	
	/**
	 * On-Click handler for button btnAsgnMenuRoles
	 */
	,onBtnAsgnMenuRoles: function() {
		this._showAsgnWindow_("seava.ad.ui.extjs.asgn.Menu_Role_Asgn$Ui" ,{dc: "menu", objectIdField: "id"});
	}
});
