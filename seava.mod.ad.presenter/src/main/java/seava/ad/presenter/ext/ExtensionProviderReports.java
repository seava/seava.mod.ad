package seava.ad.presenter.ext;

import java.util.List;

import seava.ad.domain.impl.report.ReportParam;
import seava.ad.presenter.impl.report.model.DsReportParamRt_Ds;
import seava.ad.presenter.impl.report.model.DsReportUsageRt_Ds;
import seava.j4e.api.extensions.IExtensionContentProvider;
import seava.j4e.api.service.business.IEntityService;
import seava.j4e.api.service.presenter.IDsService;
import seava.j4e.presenter.service.AbstractPresenterBaseService;

public class ExtensionProviderReports extends AbstractPresenterBaseService
		implements IExtensionContentProvider {

	@Override
	public String getContent(String targetFrame) throws Exception {

		StringBuffer sb = new StringBuffer();
		this.addFrameReports(targetFrame, sb);
		return sb.toString();
	}

	protected void addFrameReports(String targetFrame, StringBuffer sb)
			throws Exception {

		IDsService<DsReportUsageRt_Ds, DsReportUsageRt_Ds, Object> srv = this
				.findDsService(DsReportUsageRt_Ds.ALIAS);
		IDsService<DsReportParamRt_Ds, DsReportParamRt_Ds, Object> srvParam = this
				.findDsService(DsReportParamRt_Ds.ALIAS);

		DsReportUsageRt_Ds filter = new DsReportUsageRt_Ds();
		filter.setFrameName(targetFrame);
		List<DsReportUsageRt_Ds> reports = srv.find(filter);

		DsReportParamRt_Ds filterParam = new DsReportParamRt_Ds();

		IEntityService<ReportParam> rpsrv = this
				.findEntityService(ReportParam.class);

		int i = 0;
		sb.append("frameReports = [");
		for (DsReportUsageRt_Ds report : reports) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append("{");
			sb.append("dcAlias:\"" + report.getDcKey() + "\"");
			sb.append(",report:\"" + report.getReportCode() + "\"");
			sb.append(",title:\"" + report.getReportTitle() + "\"");
			sb.append(",toolbar:\"" + report.getToolbarKey() + "\"");
			sb.append(",url:\"" + report.getServerUrl() + "\"");
			sb.append(",queryBuilderClass:\"" + report.getQueryBuilderClass()
					+ "\"");

			if (report.getReportContextPath() != null
					&& !report.getReportContextPath().equals("")) {
				sb.append(",contextPath:\"" + report.getReportContextPath()
						+ "\"");
			}

			sb.append(",params:[");
			filterParam.setDsReportId(report.getDsReportId());

			List<DsReportParamRt_Ds> params = srvParam.find(filterParam);
			int j = 0;
			for (DsReportParamRt_Ds param : params) {
				if (j > 0) {
					sb.append(",");
				}
				sb.append("{");

				sb.append(" code:\"" + param.getParam() + "\"");
				sb.append(",type:\"" + param.getParamDataType() + "\"");
				sb.append(",mandatory:\"" + param.getParamMandatory() + "\"");
				if (param.getDsField() != null
						&& !param.getDsField().equals("")) {
					sb.append(",dsField:\"" + param.getDsField() + "\"");
				}
				if (param.getParamListOfValues() != null
						&& !param.getParamListOfValues().equals("")) {
					sb.append(",listOfValues:\"" + param.getParamListOfValues()
							+ "\"");
				}

				if (param.getStaticValue() != null
						&& !param.getStaticValue().equals("")) {
					sb.append(",value:\"" + param.getStaticValue() + "\"");
				} else {
					sb.append(",value:\""
							+ ((param.getParamDefaultValue() != null) ? param
									.getParamDefaultValue() : "") + "\"");
				}
				sb.append("}");
				j++;
			}

			List<ReportParam> rplist = rpsrv
					.getEntityManager()
					.createQuery(
							"select e from "
									+ ReportParam.class.getSimpleName()
									+ " e "
									+ "where e.report.id = :reportId"
									+ "  and e.active = true "
									+ "  and e.id not in (select t.reportParam.id from DsReportParam t where t.dsReport.report.id = :reportId) ",
							ReportParam.class)
					.setParameter("reportId", report.getReportId())
					.getResultList();
			int k = 0;
			for (ReportParam rparam : rplist) {
				if (j > 0 || k > 0) {
					sb.append(",");
				}
				sb.append("{");

				sb.append(" code:\"" + rparam.getName() + "\"");
				sb.append(",type:\"" + rparam.getDataType() + "\"");
				sb.append(",mandatory:\"" + rparam.getMandatory() + "\"");

				if (rparam.getListOfValues() != null
						&& !rparam.getListOfValues().equals("")) {
					sb.append(",listOfValues:\"" + rparam.getListOfValues()
							+ "\"");
				}

				sb.append(",value:\""
						+ ((rparam.getDefaultValue() != null) ? rparam
								.getDefaultValue() : "") + "\"");

				sb.append("}");
				k++;
			}

			// params
			sb.append("]");
			sb.append("}");
			i++;
		}
		sb.append("];");
	}

}
