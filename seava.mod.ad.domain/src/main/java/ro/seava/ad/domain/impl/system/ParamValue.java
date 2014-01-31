/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.domain.impl.system;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import ro.seava.j4e.domain.impl.AbstractAuditable;

@Entity
@Table(name = ParamValue.TABLE_NAME)
public class ParamValue extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_PARAMVAL";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "SYSPARAM", nullable = false, length = 64)
	private String sysParam;

	@Column(name = "VALUE", length = 400)
	private String value;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM", nullable = false)
	private Date validFrom;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO", nullable = false)
	private Date validTo;

	public String getSysParam() {
		return this.sysParam;
	}

	public void setSysParam(String sysParam) {
		this.sysParam = sysParam;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
