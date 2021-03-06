package seava.ad.presenter.ext;

import java.util.List;

import seava.j4e.api.extensions.IExtensionContentProvider;
import seava.j4e.api.extensions.IExtensions;
import seava.j4e.api.service.presenter.IDsService;
import seava.j4e.api.session.Session;
import seava.j4e.presenter.service.AbstractPresenterBaseService;
import seava.ad.presenter.impl.security.model.MenuRtLov_Ds;

public class ExtensionProviderMainMenu extends AbstractPresenterBaseService
		implements IExtensionContentProvider {

	@Override
	public String getContent(String targetName) throws Exception {
		if (IExtensions.UI_EXTJS_MAIN.equals(targetName)) {
			StringBuffer sb = new StringBuffer();
			if (Session.user.get().isSystemUser()) {
				this.addSystemMenus(sb);
			} else {
				this.addNavigationTreeMenus(sb);
				this.addNavigationTopMenus(sb);
			}
			return sb.toString();
		}
		return null;
	}

	protected void addSystemMenus(StringBuffer sb) throws Exception {

		sb.append("Main.systemMenus = [");
		sb.append("{\"bundle\":\"seava.mod.ad\", \"frame\":\"seava.ad.ui.extjs.frame.Client_Ui\", \"labelKey\":\"appmenuitem/clientmgmt__lbl\" },");
		sb.append("{\"bundle\":\"seava.mod.ad\", \"frame\":\"seava.ad.ui.extjs.frame.DataSource_Ui\", \"labelKey\":\"appmenuitem/sysds__lbl\" },");
		sb.append("{\"bundle\":\"seava.mod.ad\", \"frame\":\"seava.ad.ui.extjs.frame.Job_Ui\", \"labelKey\":\"appmenuitem/sysjob__lbl\" },");
		sb.append("{\"bundle\":\"seava.mod.ad\", \"frame\":\"seava.ad.ui.extjs.frame.Param_Ui\", \"labelKey\":\"appmenuitem/sysparam__lbl\" },");
		sb.append("{\"bundle\":\"seava.mod.ad\", \"frame\":\"seava.ad.ui.extjs.frame.DateFormat_Ui\", \"labelKey\":\"appmenuitem/dateformat__lbl\" },");
		sb.append("{\"bundle\":\"seava.mod.ad\", \"frame\":\"seava.ad.ui.extjs.frame.DateFormatMask_Ui\", \"labelKey\":\"appmenuitem/dateformatmask__lbl\" },");
		sb.append("{\"bundle\":\"seava.mod.ad\", \"frame\":\"seava.ad.ui.extjs.frame.DbChangeLog_Ui\", \"labelKey\":\"appmenuitem/dbchangelog__lbl\" }");
		sb.append("];");
	}

	protected void addNavigationTreeMenus(StringBuffer sb) throws Exception {
		IDsService<MenuRtLov_Ds, MenuRtLov_Ds, Object> srv = this
				.findDsService(MenuRtLov_Ds.class);
		MenuRtLov_Ds filter = new MenuRtLov_Ds();
		filter.setActive(true);
		filter.setTag("left");
		List<MenuRtLov_Ds> menus = srv.find(filter);
		int i = 0;
		sb.append("Main.navigationTreeMenus = [");
		for (MenuRtLov_Ds menu : menus) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append("{name:\"" + menu.getName() + "\", title:\""
					+ menu.getTitle() + "\"}");
			i++;
		}
		sb.append("];");
	}

	protected void addNavigationTopMenus(StringBuffer sb) throws Exception {
		IDsService<MenuRtLov_Ds, MenuRtLov_Ds, Object> srv = this
				.findDsService(MenuRtLov_Ds.class);
		MenuRtLov_Ds filter = new MenuRtLov_Ds();
		filter.setActive(true);
		filter.setTag("top");
		List<MenuRtLov_Ds> menus = srv.find(filter);
		int i = 0;
		sb.append("Main.navigationTopMenus = [");
		for (MenuRtLov_Ds menu : menus) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append("{name:\"" + menu.getName() + "\", title:\""
					+ menu.getTitle() + "\"}");
			i++;
		}
		sb.append("];");
	}

}
