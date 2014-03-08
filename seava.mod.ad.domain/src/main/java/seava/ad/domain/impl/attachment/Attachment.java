/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.domain.impl.attachment;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotBlank;
import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.domain.impl.AbstractAuditable;

/** Attachments. */
@Entity
@Table(name = Attachment.TABLE_NAME)
public class Attachment extends AbstractAuditable implements Serializable {

	public static final String TABLE_NAME = "AD_ATCH";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@Column(name = "FILENAME", length = 255)
	private String fileName;

	@Column(name = "LOCATION", length = 400)
	private String location;

	@Column(name = "CONTENTTYPE", length = 32)
	private String contentType;

	@NotBlank
	@Column(name = "TARGETREFID", nullable = false, length = 64)
	private String targetRefid;

	@NotBlank
	@Column(name = "TARGETALIAS", nullable = false, length = 64)
	private String targetAlias;

	@Column(name = "TARGETTYPE", length = 255)
	private String targetType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AttachmentType.class)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
	private AttachmentType type;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Transient
	public String getUrl() {

		if (this.location != null && !"".equals(this.location)) {
			if (this.location.startsWith("http")) {
				return this.location;
			} else {
				return this.type.getBaseUrl() + "/" + this.location;
			}
		} else {
			return this.type.getBaseUrl() + "/" + this.getId() + "."
					+ this.contentType;
		}
	}

	public void setUrl(String url) {
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
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

	public AttachmentType getType() {
		return this.type;
	}

	public void setType(AttachmentType type) {
		if (type != null) {
			this.__validate_client_context__(type.getClientId());
		}
		this.type = type;
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
