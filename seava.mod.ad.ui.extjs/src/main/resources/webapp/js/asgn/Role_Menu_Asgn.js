/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

/* model */
Ext.define(Main.ns.ad + "Role_Menu_Asgn$Model", {
	extend: 'Ext.data.Model',
	fields:  [
		{name:"id",type:"string"},
		{name:"name",type:"string"},
		{name:"title",type:"string"}
	]
});

/* lists */
Ext.define( Main.ns.ad + "Role_Menu_Asgn$List", {
	extend: "e4e.asgn.AbstractAsgnGrid",
	alias:[ "widget.ad_Role_Menu_Asgn$Left","widget.ad_Role_Menu_Asgn$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({name:"id", dataIndex:"id", hidden:true})
		.addTextColumn({name:"name", dataIndex:"name"})
		.addTextColumn({name:"title", dataIndex:"title"})
	} 
});
	
/* ui-window */
Ext.define(Main.ns.ad + "Role_Menu_Asgn$Ui", {
	extend: "e4e.asgn.AbstractAsgnUi",
	width:700,
	height:400,
	title:"Assign menus to role",
	_filterFields_: [
		["id"],
		["name"],
		["title"]
	],
	_defaultFilterField_ : "name",

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"ad_Role_Menu_Asgn$Left"})
			.addRightGrid({ xtype:"ad_Role_Menu_Asgn$Right"})
	}
});
