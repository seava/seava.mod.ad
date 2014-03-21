/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("seava.ad.ui.extjs.dc.JobTimer_Dc", {
	extend: "e4e.dc.AbstractDc",
	filterModel: seava.ad.ui.extjs.ds.JobTimer_DsFilter,
	recordModel: seava.ad.ui.extjs.ds.JobTimer_Ds
});

/* ================= FILTER FORM: Filter ================= */

Ext.define("seava.ad.ui.extjs.dc.JobTimer_Dc$Filter", {
	extend: "e4e.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_JobTimer_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({name:"jobName", dataIndex:"jobName", xtype:"ad_Jobs_Lov",
			retFieldMapping: [{lovField:"name", dsField: "jobName"} ]})
		.addLov({name:"jobContext", dataIndex:"jobContext", xtype:"ad_JobContexts_Lov",
			retFieldMapping: [{lovField:"id", dsField: "jobContextId"} ],
			filterFieldMapping: [{lovField:"jobName", dsField: "jobName"} ]})
		.addDateField({name:"startTime_From", dataIndex:"startTime_From", emptyText:"From" })
		.addDateField({name:"startTime_To", dataIndex:"startTime_To", emptyText:"To" })
		.addFieldContainer({name: "startTime"})
			.addChildrenTo("startTime",["startTime_From", "startTime_To"])
		.addDateField({name:"endTime_From", dataIndex:"endTime_From", emptyText:"From" })
		.addDateField({name:"endTime_To", dataIndex:"endTime_To", emptyText:"To" })
		.addFieldContainer({name: "endTime"})
			.addChildrenTo("endTime",["endTime_From", "endTime_To"])
		.addCombo({ xtype:"combo", name:"type", dataIndex:"type", store:[ "simple", "cron"]})
		.addCombo({ xtype:"combo", name:"repeatIntervalType", dataIndex:"repeatIntervalType", store:[ "seconds", "minutes", "hours"]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:280, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"})
		.addPanel({ name:"col3", width:300, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["jobName", "jobContext", "name"])
		.addChildrenTo("col2", ["type", "repeatIntervalType"])
		.addChildrenTo("col3", ["startTime", "endTime"]);
	}
});

/* ================= GRID: List ================= */

Ext.define("seava.ad.ui.extjs.dc.JobTimer_Dc$List", {
	extend: "e4e.dc.view.AbstractDcvGrid",
	alias: "widget.ad_JobTimer_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"jobName", dataIndex:"jobName", width:200})
		.addTextColumn({ name:"jobContext", dataIndex:"jobContext", width:200})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
		.addTextColumn({ name:"type", dataIndex:"type", width:60})
		.addDateColumn({ name:"startTime", dataIndex:"startTime", hidden:true, _mask_: Masks.DATETIME})
		.addDateColumn({ name:"endTime", dataIndex:"endTime", hidden:true, _mask_: Masks.DATETIME})
		.addTextColumn({ name:"cronExpression", dataIndex:"cronExpression", hidden:true, width:200})
		.addNumberColumn({ name:"repeatCount", dataIndex:"repeatCount", hidden:true})
		.addNumberColumn({ name:"repeatInterval", dataIndex:"repeatInterval", hidden:true})
		.addTextColumn({ name:"repeatIntervalType", dataIndex:"repeatIntervalType", hidden:true, width:60})
		.addDefaults();
	}
});

/* ================= GRID: CtxListJobContext ================= */

Ext.define("seava.ad.ui.extjs.dc.JobTimer_Dc$CtxListJobContext", {
	extend: "e4e.dc.view.AbstractDcvGrid",
	alias: "widget.ad_JobTimer_Dc$CtxListJobContext",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:150})
		.addTextColumn({ name:"type", dataIndex:"type", width:60})
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
		.addDateColumn({ name:"startTime", dataIndex:"startTime", _mask_: Masks.DATETIME})
		.addDateColumn({ name:"endTime", dataIndex:"endTime", hidden:true, _mask_: Masks.DATETIME})
		.addTextColumn({ name:"cronExpression", dataIndex:"cronExpression", hidden:true, width:200})
		.addNumberColumn({ name:"repeatCount", dataIndex:"repeatCount", hidden:true})
		.addNumberColumn({ name:"repeatInterval", dataIndex:"repeatInterval", hidden:true})
		.addTextColumn({ name:"repeatIntervalType", dataIndex:"repeatIntervalType", hidden:true, width:60})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define("seava.ad.ui.extjs.dc.JobTimer_Dc$Edit", {
	extend: "e4e.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_JobTimer_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextArea({ name:"description", dataIndex:"description", height:60})
		.addLov({name:"jobContext", dataIndex:"jobContext", xtype:"ad_JobContexts_Lov",
			retFieldMapping: [{lovField:"id", dsField: "jobContextId"} ]})
		.addCombo({ xtype:"combo", name:"type", dataIndex:"type", store:[ "simple", "cron"],listeners:{
			change:{scope:this, fn:this.onTypeChange}
		}})
		.addTextField({ name:"cronExpression", dataIndex:"cronExpression", _visibleFn_: function(dc, rec) { return rec.data.type == "cron"; } })
		.addNumberField({name:"repeatCount", dataIndex:"repeatCount", _visibleFn_: function(dc, rec) { return rec.data.type == "simple"; } })
		.addNumberField({name:"repeatInterval", dataIndex:"repeatInterval", _visibleFn_: function(dc, rec) { return rec.data.type == "simple"; } })
		.addCombo({ xtype:"combo", name:"repeatIntervalType", dataIndex:"repeatIntervalType", _visibleFn_: function(dc, rec) { return rec.data.type == "simple"; } , store:[ "seconds", "minutes", "hours"]})
		.addDateTimeField({name:"startTime", dataIndex:"startTime"})
		.addDateTimeField({name:"endTime", dataIndex:"endTime"})
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1"])
		.addChildrenTo("col1", ["jobContext", "name", "description", "type", "startTime", "cronExpression", "repeatCount", "repeatInterval", "repeatIntervalType"]);
	},
	/* ==================== Business functions ==================== */
	
	onTypeChange: function() {
		var rec = this._getController_().getRecord();		 
		this._setFieldsVisibleState_(["cronExpression","repeatCount","repeatInterval","repeatIntervalType"], rec);
	}
});
