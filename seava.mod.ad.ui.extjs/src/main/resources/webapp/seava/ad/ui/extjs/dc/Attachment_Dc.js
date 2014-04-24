/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.Attachment_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.Attachment_Ds,
		
			/* ================ Business functions ================ */
	
	doNew: function() {
		
		if (this._doNewWdw_ == null ) {
			this._doNewWdw_ = Ext.create("Ext.window.Window", {
				width:400, 
				height:200, 
				closable: false,
				closeAction: "hide",
				resizable:true, 
				layout:"fit", 
				modal:true,
				items: {
					_controller_:this,
					xtype:"ad_Attachment_Dc$Create"
				}	
			});
		}
		this._doNewWdw_.show();
		this.commands.doNew.execute();
	},
	
	afterDoSaveSuccess: function() {
		if (this._doNewWdw_ != null) {this._doNewWdw_.close();}
	}

});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.Attachment_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_Attachment_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({name:"type", dataIndex:"type", xtype:"ad_AttachmentTypes_Lov",
			retFieldMapping: [{lovField:"id", dsField: "typeId"} ]})
		.addTextField({ name:"targetType", dataIndex:"targetType"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "type"])
		.addChildrenTo("col2", ["targetType"]);
	}
});

/* ================= GRID: List ================= */

Ext.define("seava.ad.ui.extjs.dc.Attachment_Dc$List", {
	extend: "e4e.dc.view.AbstractDcvGrid",
	alias: "widget.ad_Attachment_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"type", dataIndex:"type", width:200})
		.addTextColumn({ name:"name", dataIndex:"name", width:200, renderer: function(v, md, rec, ri, ci, store) {return '<a href="javascript:void(0);"  onClick=\'javascript: window.open("'+rec.data.url+'", "Attachment", "location=1,status=1,scrollbars=1,width=660,height=500");\'>'+  rec.data.name  +'</a>';} })
		.addTextColumn({ name:"url", dataIndex:"url", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Create ================= */

Ext.define("seava.ad.ui.extjs.dc.Attachment_Dc$Create", {
	extend: "e4e.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_Attachment_Dc$Create",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addButton({name:"btnUpload", scope: this, handler: this._createContinue_, text: "Select file", _enableFn_: function(dc, rec) { return rec.data.category != 'link' ; } })
		.addButton({name:"btnSave", scope: this, handler: this._save_, text: "Save", _enableFn_: function(dc, rec) { return rec.data.category == 'link' ; } })
		.addButton({name:"btnCancel", scope: this, handler: this._cancel_, text: "Cancel"})
		.addLov({name:"type", dataIndex:"type", allowBlank:false, xtype:"ad_AttachmentTypes_Lov",
			retFieldMapping: [{lovField:"id", dsField: "typeId"} ,{lovField:"category", dsField: "category"} ],
			filterFieldMapping: [{lovField:"targetAlias", dsField: "targetAlias"}, {lovField:"targetType", dsField: "targetType"} ],listeners:{
			change:{scope:this, fn:this.onTypeChange}
		}})
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"location", dataIndex:"location", _enableFn_: function(dc, rec) { return rec.data.category == 'link' ; } })
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, buttons: [this._getConfig_("btnUpload"),this._getConfig_("btnSave"),this._getConfig_("btnCancel")],  xtype:"panel", buttonAlign:"center", layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["type", "name", "location"]);
	},
	/* ==================== Business functions ==================== */
	
	onTypeChange: function() {
		var rec = this._getController_().getRecord();		 
		this._setFieldsEnabledState_(["location","btnUpload","btnSave"], rec);
	},
	
	_save_: function() {
		
		if (this.isValid()) { 
			this._controller_.doSave();
		}
	},
	
	_cancel_: function() {
		
		this.up("window").hide();
		this._controller_.doCancel();
	},
	
	_createContinue_: function() {
		
		var rd = this._controller_.record.data;
		(new e4e.base.FileUploadWindow(
			{
				_handler_ : "uploadAttachment",
				_fields_ : {							 
					a_id : {
						xtype : "hidden",
						value : rd.id
					},
					a_name : {
						xtype : "hidden",
						value : rd.name
					},
					a_type : {
						xtype : "hidden",
						value : rd.type
					},
					a_typeId : {
						xtype : "hidden",
						value : rd.typeId
					},
					a_category : {
						xtype : "hidden",
						value : rd.category
					},
					a_targetAlias : {
						xtype : "hidden",
						value : rd.targetAlias
					},
					a_targetRefid : {
						xtype : "hidden",
						value : rd.targetRefid
					},
					a_targetType : {
						xtype : "hidden",
						value : rd.targetType
					}
				},
				_succesCallbackScope_ : this._controller_,
				_succesCallbackFn_ : function() {
					this.doCancel();
					if (this._doNewWdw_ != null) {this._doNewWdw_.close();}
					(new Ext.util.DelayedTask(this.doQuery, this)).delay(100);
				}
			})).show();
	}
});
