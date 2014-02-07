/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.domain.impl.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import ro.seava.j4e.domain.impl.AbstractType;

@Entity
@Table(name = ViewState.TABLE_NAME)
public class ViewState extends AbstractType {

	public static final String TABLE_NAME = "AD_VIEW_STATE";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "CMP", nullable = false, length = 255)
	private String cmp;

	@NotBlank
	@Column(name = "CMPTYPE", nullable = false, length = 16)
	private String cmpType;

	@Column(name = "VALUE", length = 4000)
	private String value;

	public String getCmp() {
		return this.cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public String getCmpType() {
		return this.cmpType;
	}

	public void setCmpType(String cmpType) {
		this.cmpType = cmpType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}

	@PreUpdate
	public void preUpdate() {
		super.preUpdate();
	}

}
