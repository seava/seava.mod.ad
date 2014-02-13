/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

/* model */
Ext.define("seava.ad.ui.extjs.asgn.Role_AccessControl_Asgn$Model", {
	extend: 'Ext.data.Model',
	fields:  [
		{name:"id",type:"string"},
		{name:"name",type:"string"},
		{name:"description",type:"string"}
	]
});

/* lists */
Ext.define( "seava.ad.ui.extjs.asgn.Role_AccessControl_Asgn$List", {
	extend: "e4e.asgn.AbstractAsgnGrid",
	alias:[ "widget.ad_Role_AccessControl_Asgn$Left","widget.ad_Role_AccessControl_Asgn$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({name:"id", dataIndex:"id", hidden:true})
		.addTextColumn({name:"name", dataIndex:"name", width:120})
		.addTextColumn({name:"description", dataIndex:"description"})
	} 
});
	
/* ui-window */
Ext.define("seava.ad.ui.extjs.asgn.Role_AccessControl_Asgn$Ui", {
	extend: "e4e.asgn.AbstractAsgnUi",
	width:800,
	height:400,
	title:"Assign privileges to role",
	_filterFields_: [
		["id"],
		["name"]
	],
	_defaultFilterField_ : "name",

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"ad_Role_AccessControl_Asgn$Left"})
			.addRightGrid({ xtype:"ad_Role_AccessControl_Asgn$Right"})
	}
});
