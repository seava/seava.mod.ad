/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.frame.ReportRt_Ui", {
	extend: "e4e.ui.AbstractUi",
	alias: "widget.ReportRt_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_().addDc("rep", Ext.create(seava.ad.ui.extjs.dc.ReportRt_Dc,{}))
		.addDc("param", Ext.create(seava.ad.ui.extjs.dc.ReportParamRt_Dc,{multiEdit: true}))
		.linkDc("param", "rep",{fields:[
					{childField:"reportId", parentField:"id"}]})
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnShowParamsWdw", disabled:false, handler: this.onBtnShowParamsWdw, scope:this})
		.addButton({name:"btnRunReport", disabled:false, handler: this.onBtnRunReport, scope:this})
		.addButton({name:"btnCancelReport", disabled:false, handler: this.onBtnCancelReport, scope:this})
		.addDcFilterFormView("rep", {name:"repFilter", xtype:"ad_ReportRt_Dc$Filter"})
		.addDcGridView("rep", {name:"repList", width:550, xtype:"ad_ReportRt_Dc$List"})
		.addDcEditGridView("param", {name:"paramList", xtype:"ad_ReportParamRt_Dc$List", frame:true})
		.addWindow({name:"wdwParams", _hasTitle_:true, width:450, height:300, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("paramList")],  closable:false, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnRunReport"), this._elems_.get("btnCancelReport")]}]})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["repFilter", "repList"], ["north", "center"])
		.addToolbarTo("main", "tlbRepList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbRepList", {dc: "rep"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnShowParamsWdw") ])
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnShowParamsWdw
	 */
	,onBtnShowParamsWdw: function() {
		this._getDc_("param").doQuery();
		this._getWindow_("wdwParams").show();
	}
	
	/**
	 * On-Click handler for button btnRunReport
	 */
	,onBtnRunReport: function() {
		this.runReport();
		this._getWindow_("wdwParams").close();
	}
	
	/**
	 * On-Click handler for button btnCancelReport
	 */
	,onBtnCancelReport: function() {
		this._getDc_("param").doCancel();
		this._getWindow_("wdwParams").close();
	}
	
	,runReport: function() {
		
		var rep = this._getDc_("rep").record.data;
		var paramDc = this._getDc_("param");
		
		if (!rep.queryBuilderClass) {
			rep.queryBuilderClass = "e4e.dc.tools.DcReport";
		}
		
		var b = Ext.ClassManager
				.isCreated(rep.queryBuilderClass);
		if (!b) {
			Main.error("Query builder class `"
					+ rep.queryBuilderClass + "` not found. Invalid report server configuration.");
			return;
		}
		var dcReport = Ext.create(rep.queryBuilderClass); 
		var params = []
		
		paramDc.store.each(function(r) {
			//code, name, type, lov, value, mandatory, noEdit
			params[params.length] = {
				code:  r.data.name,
				name:  r.data.title,
				type:  r.data.dataType,
				lov:  r.data.listOfValues,
				value:  r.data.value,
				mandatory:  r.data.mandatory,
				noEdit:  r.data.noEdit
			}
		}); 
		 
		dcReport.run({
			url : rep.serverUrl,
			contextPath : rep.contextPath,
			params : params
		});
		
		paramDc.store.commitChanges();
	}
});
