/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.attachment.model;

import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractType_Ds;

@Ds(entity = AttachmentType.class, sort = {@SortField(field = AttachmentType_Ds.f_name)})
public class AttachmentType_Ds extends AbstractType_Ds<AttachmentType> {
	public static final String f_category = "category";
	public static final String f_uploadPath = "uploadPath";
	public static final String f_baseUrl = "baseUrl";

	@DsField
	private String category;

	@DsField
	private String uploadPath;

	@DsField
	private String baseUrl;

	public AttachmentType_Ds() {
		super();
	}

	public AttachmentType_Ds(AttachmentType e) {
		super(e);
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUploadPath() {
		return this.uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
