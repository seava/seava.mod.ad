/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.domain.impl.system;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import seava.j4e.domain.impl.AbstractAuditable;

/** Define rules to dynamically linked objects. */
@Entity
@Table(name = TargetRule.TABLE_NAME)
public class TargetRule extends AbstractAuditable implements Serializable {

	public static final String TABLE_NAME = "AD_TARGET_RULE";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "SOURCEREFID", nullable = false, length = 64)
	private String sourceRefId;

	@NotBlank
	@Column(name = "TARGETALIAS", nullable = false, length = 255)
	private String targetAlias;

	@NotBlank
	@Column(name = "TARGETTYPE", nullable = false, length = 255)
	private String targetType;

	public String getSourceRefId() {
		return this.sourceRefId;
	}

	public void setSourceRefId(String sourceRefId) {
		this.sourceRefId = sourceRefId;
	}

	public String getTargetAlias() {
		return this.targetAlias;
	}

	public void setTargetAlias(String targetAlias) {
		this.targetAlias = targetAlias;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
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
