/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.frame.Report_Ui", {
	extend: "e4e.ui.AbstractUi",
	alias: "widget.Report_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("rep", Ext.create(seava.ad.ui.extjs.dc.Report_Dc,{}))	
		.addDc("params", Ext.create(seava.ad.ui.extjs.dc.ReportParam_Dc,{multiEdit:true}))	
		.addDc("paramsRt", Ext.create(seava.ad.ui.extjs.dc.ReportParamRt_Dc,{multiEdit:true}))	
		.addDc("dsrep", Ext.create(seava.ad.ui.extjs.dc.DsReport_Dc,{multiEdit:true}))	
		.addDc("dsparam", Ext.create(seava.ad.ui.extjs.dc.DsReportParam_Dc,{multiEdit:true}))	
		.addDc("usage", Ext.create(seava.ad.ui.extjs.dc.DsReportUsageCtx_Dc,{multiEdit:true}))
		.linkDc("params", "rep",{fields:[
			{childField:"reportId", parentField:"id"}]}
		).linkDc("paramsRt", "rep",{fields:[
			{childField:"reportId", parentField:"id"}]}
		).linkDc("dsrep", "rep",{fields:[
			{childField:"reportId", parentField:"id"}]}
		).linkDc("dsparam", "dsrep",{fields:[
			{childField:"dsReportId", parentField:"id"}, {childField:"reportId", parentField:"reportId"}, {childField:"dataSource", parentField:"dataSource"}]}
		).linkDc("usage", "dsrep",{fields:[
			{childField:"dsReportId", parentField:"id"}, {childField:"reportId", parentField:"reportId"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnTestReport", iconCls:"icon-action-run", disabled:false, handler: this.onBtnTestReport, scope:this})
		.addButton({name:"btnRunReport", iconCls:"icon-action-commit", disabled:false, handler: this.onBtnRunReport, scope:this})
		.addButton({name:"btnCancelReport", iconCls:"icon-action-reset", disabled:false, handler: this.onBtnCancelReport, scope:this})
		.addDcFilterFormView("rep", {name:"repFilter", xtype:"ad_Report_Dc$Filter"})
		.addDcGridView("rep", {name:"repList", xtype:"ad_Report_Dc$List"})
		.addDcFormView("rep", {name:"repEdit", xtype:"ad_Report_Dc$Edit"})
		.addDcEditGridView("params", {name:"paramEditList", _hasTitle_:true, xtype:"ad_ReportParam_Dc$CtxEditList", frame:true})
		.addDcEditGridView("paramsRt", {name:"paramTest", xtype:"ad_ReportParamRt_Dc$TestRt", frame:true})
		.addDcEditGridView("dsrep", {name:"dsrepList", width:600, xtype:"ad_DsReport_Dc$ReportCtxList", frame:true})
		.addDcEditGridView("dsparam", {name:"dsparamList", _hasTitle_:true, xtype:"ad_DsReportParam_Dc$CtxEditList", frame:true})
		.addDcEditGridView("usage", {name:"usageList", _hasTitle_:true, xtype:"ad_DsReportUsageCtx_Dc$EditList", frame:true})
		.addWindow({name:"wdwTestReport", _hasTitle_:true, width:450, height:350, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("paramTest")], closable:false
			, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnRunReport"), this._elems_.get("btnCancelReport")]}]})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"repDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
		.addPanel({name:"dsRep", _hasTitle_:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"dsrepDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvas1", "canvas2"])
		.addChildrenTo("canvas1", ["repFilter", "repList"], ["north", "center"])
		.addChildrenTo("canvas2", ["repEdit", "repDetailsTab"], ["north", "center"])
		.addChildrenTo("repDetailsTab", ["paramEditList", "dsRep"])
		.addChildrenTo("dsRep", ["dsrepList", "dsrepDetailsTab"], ["west", "center"])
		.addChildrenTo("dsrepDetailsTab", ["dsparamList", "usageList"])
		.addToolbarTo("canvas1", "tlbRepList")
		.addToolbarTo("canvas2", "tlbRepEdit")
		.addToolbarTo("paramEditList", "tlbParamList")
		.addToolbarTo("dsrepList", "tlbDsRepList")
		.addToolbarTo("dsparamList", "tlbDsParamList")
		.addToolbarTo("usageList", "tlbUsageList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbRepList", {dc: "rep"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbRepEdit", {dc: "rep"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports()
		.end()
		.beginToolbar("tlbParamList", {dc: "params"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbDsRepList", {dc: "dsrep"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbDsParamList", {dc: "dsparam"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbUsageList", {dc: "usage"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnTestReport
	 */
	,onBtnTestReport: function() {
		this._getWindow_("wdwTestReport").show();
		this._getDc_("paramsRt").doQuery();
	}
	
	/**
	 * On-Click handler for button btnRunReport
	 */
	,onBtnRunReport: function() {
		this._runReport_();
	}
	
	/**
	 * On-Click handler for button btnCancelReport
	 */
	,onBtnCancelReport: function() {
		this._getDc_("paramsRt").doCancel();
		this._getWindow_("wdwTestReport").close();
	}
	
	,_runReport_: function() {
		var paramsDc = this._getDc_("paramsRt")
					serverUrl = this._getDc_("rep").record.data.serverUrl;
				
				var qs = "";
				
				paramsDc.store.data.each(function(item, idx,len) {
					if(qs != "") {
						qs += "&";
					}
					qs += item.get("code") + "=" + item.get("value");
				});
				window.open(serverUrl + "?" + qs,"Test-report","")
				.focus();
	}
});
