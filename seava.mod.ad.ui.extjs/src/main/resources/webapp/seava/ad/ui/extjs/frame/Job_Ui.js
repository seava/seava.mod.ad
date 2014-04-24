/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.frame.Job_Ui", {
	extend: "e4e.ui.AbstractUi",
	alias: "widget.Job_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_().addDc("job", Ext.create(seava.ad.ui.extjs.dc.Job_Dc,{}))
		.addDc("params", Ext.create(seava.ad.ui.extjs.dc.JobParam_Dc,{}))
		.linkDc("params", "job",{fetchMode:"auto",fields:[
					{childField:"jobId", parentField:"id"}]})
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnSynchronize", iconCls:"icon-action-synchronize", disabled:false, handler: this.onBtnSynchronize, scope:this})
		.addDcFilterFormView("job", {name:"jobFilter", xtype:"ad_Job_Dc$Filter"})
		.addDcGridView("job", {name:"jobList", xtype:"ad_Job_Dc$List"})
		.addDcGridView("params", {name:"paramsCtxList", _hasTitle_:true, width:400, xtype:"ad_JobParam_Dc$CtxList"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["jobFilter", "jobList", "paramsCtxList"], ["north", "center", "east"])
		.addToolbarTo("main", "tlbJobList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbJobList", {dc: "job"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnSynchronize") ])
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnSynchronize
	 */
	,onBtnSynchronize: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("job").doQuery();
		};
		var o={
			name:"synchronizeCatalog",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("job").doRpcFilter(o);
	}
	
	,_when_called_to_view_: function(params) {
		
		var job = this._getDc_("job");
		if (job.isDirty()) {
			this._alert_dirty_();
			return;
		}
		job.doClearQuery();
			 
		job.setFilterValue("jobName", params.jobName );
		job.doQuery();
	}
	
	,_afterDefineElements_: function() {
		
		if (!getApplication().getSession().user.systemUser) {
		         this._getBuilder_()
		    .change("btnSynchronize", {disabled: true});
		}
	}
});
