/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

/* model */
Ext.define("seava.ad.ui.extjs.asgn.Role_User_Asgn$Model", {
	extend: 'Ext.data.Model',
	statics: {
		ALIAS: "ad_Role_User_Asgn"
	},
	fields:  [
		{name:"id",type:"string"},
		{name:"code",type:"string"},
		{name:"name",type:"string"},
		{name:"description",type:"string"}
	]
});

/* lists */
Ext.define( "seava.ad.ui.extjs.asgn.Role_User_Asgn$List", {
	extend: "e4e.asgn.AbstractAsgnGrid",
	alias:[ "widget.ad_Role_User_Asgn$Left","widget.ad_Role_User_Asgn$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({name:"id", dataIndex:"id", hidden:true})
		.addTextColumn({name:"code", dataIndex:"code", width:120})
		.addTextColumn({name:"name", dataIndex:"name"})
		.addTextColumn({name:"description", dataIndex:"description", hidden:true})
	} 
});
	
/* ui-window */
Ext.define("seava.ad.ui.extjs.asgn.Role_User_Asgn$Ui", {
	extend: "e4e.asgn.AbstractAsgnUi",
	width:800,
	height:400,
	title:"Assign users to role",
	_filterFields_: [
		["id"],
		["code"],
		["name"]
	],
	_defaultFilterField_ : "code",

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"ad_Role_User_Asgn$Left"})
			.addRightGrid({ xtype:"ad_Role_User_Asgn$Right"})
	}
});
