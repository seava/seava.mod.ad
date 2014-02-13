/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.Param;
import ro.seava.j4e.api.annotation.RefLookup;
import ro.seava.j4e.api.annotation.RefLookups;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.impl.model.AbstractTypeWithCode_Ds;
import seava.ad.domain.impl.security.User;
import seava.ad.domain.impl.system.DateFormat;

@Ds(entity = User.class, sort = {@SortField(field = User_Ds.f_code)})
@RefLookups({@RefLookup(refId = User_Ds.f_dateFormatId, namedQuery = DateFormat.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = User_Ds.f_dateFormat)})})
public class User_Ds extends AbstractTypeWithCode_Ds<User> {
	public static final String f_loginName = "loginName";
	public static final String f_code = "code";
	public static final String f_locked = "locked";
	public static final String f_email = "email";
	public static final String f_decimalSeparator = "decimalSeparator";
	public static final String f_thousandSeparator = "thousandSeparator";
	public static final String f_dateFormatId = "dateFormatId";
	public static final String f_dateFormat = "dateFormat";

	@DsField
	private String loginName;

	@DsField(noUpdate = true)
	private String code;

	@DsField
	private Boolean locked;

	@DsField
	private String email;

	@DsField
	private String decimalSeparator;

	@DsField
	private String thousandSeparator;

	@DsField(join = "left", path = "dateFormat.id")
	private String dateFormatId;

	@DsField(join = "left", path = "dateFormat.name")
	private String dateFormat;

	public User_Ds() {
		super();
	}

	public User_Ds(User e) {
		super(e);
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDecimalSeparator() {
		return this.decimalSeparator;
	}

	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public String getThousandSeparator() {
		return this.thousandSeparator;
	}

	public void setThousandSeparator(String thousandSeparator) {
		this.thousandSeparator = thousandSeparator;
	}

	public String getDateFormatId() {
		return this.dateFormatId;
	}

	public void setDateFormatId(String dateFormatId) {
		this.dateFormatId = dateFormatId;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
