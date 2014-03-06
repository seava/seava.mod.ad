/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.ReportParamRt_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.ReportParamRt_Ds
});

/* ================= EDIT-GRID: List ================= */

Ext.define("seava.ad.ui.extjs.dc.ReportParamRt_Dc$List", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_ReportParamRt_Dc$List",
	_noPaginator_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", hidden:true, align:"right", noEdit: true })
		.addTextColumn({name:"name", dataIndex:"name", hidden:true, width:200, noEdit: true})
		.addTextColumn({name:"title", dataIndex:"title", width:200, noEdit: true})
		.addTextColumn({name:"value", dataIndex:"value", width:200})
		.addDefaults();
	},
	/* ==================== Business functions ==================== */
	
	_getCustomCellEditor_: function(record,column) {
		
				var ed = null;
				var cfg = {};
		 		
				if ( record.data.noEdit ) {			 
			    	ed = new  Ext.form.field.Text({ 
						readOnly:true 
					});
			    }
				else if (!Ext.isEmpty(record.data.listOfValues)) {
			    	ed = new Ext.form.field.ComboBox({
						store:record.data.listOfValues.split(","),
						allowBlank : ((record.data.mandatory === true) ? true : false)
					});
			    }
				else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
			    	ed = new Ext.form.field.Number({ 
						allowBlank : ((record.data.mandatory === true) ? true : false),
						fieldStyle : "text-align:right;",
						hideTrigger : true,
						keyNavEnabled : false,
						mouseWheelEnabled : false 
					});
			    }
			    else if (record.data.dataType == "date") {
			    	ed = new Ext.form.field.Date({
						format: Main.MODEL_DATE_FORMAT
					});
			    }
			    else if (record.data.dataType == "boolean") {
			    	ed = new Ext.form.field.ComboBox({
						store:["true","false"]
					});
			    } else {
			    	ed = new  Ext.form.field.Text({
						allowBlank : ((record.data.mandatory === true) ? true : false),
					});
				}
			    if(ed){
				    ed._dcView_ =  this;
			    }
			    return ed;
	}
});
