/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.ReportParamRt_Dc", {
	extend: "e4e.dc.AbstractDc",
	recordModel: seava.ad.ui.extjs.ds.ReportParamRt_Ds
});

/* ================= EDIT-GRID: TestRt ================= */

Ext.define("seava.ad.ui.extjs.dc.ReportParamRt_Dc$TestRt", {
	extend: "e4e.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_ReportParamRt_Dc$TestRt",
	_noPaginator_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"parameterName", dataIndex:"parameterName", width:200, noEdit: true})
		.addTextColumn({name:"value", dataIndex:"value", width:200})
		.addDefaults();
	},
	/* ==================== Business functions ==================== */
	
	_getCustomCellEditor_: function(record,column) {
		
				var ed = null;
				 
				if ( record.data.noEdit ) {
			    	ed = new  Ext.form.field.Text({ readOnly:true });
			    }
				else if (!Ext.isEmpty(record.data.listOfValues)) {
			    	ed = new e4e.base.lov.LocalCombo({store:record.data.listOfValues.split(",")});
			    }
				else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
			    	ed = new Ext.form.field.Number({ });
			    }
			    else if (record.data.dataType == "date") {
			    	ed = new Ext.form.field.Date({});
			    }
			    else if (record.data.dataType == "boolean") {
			    	ed = new e4e.base.lov.LocalCombo({store:["true","false"]});
			    }
		 
			    if(ed){
				    ed._dcView_ =  this;
			    }
		
			    return ed;
	}
});
