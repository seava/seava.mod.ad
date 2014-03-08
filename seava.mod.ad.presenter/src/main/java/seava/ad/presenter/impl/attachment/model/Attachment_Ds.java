/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.attachment.model;

import seava.ad.domain.impl.attachment.Attachment;
import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = Attachment.class)
@RefLookups({@RefLookup(refId = Attachment_Ds.f_typeId, namedQuery = AttachmentType.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = Attachment_Ds.f_type)})})
public class Attachment_Ds extends AbstractAuditable_Ds<Attachment> {
	public static final String f_targetRefid = "targetRefid";
	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";
	public static final String f_name = "name";
	public static final String f_location = "location";
	public static final String f_contentType = "contentType";
	public static final String f_url = "url";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_category = "category";
	public static final String f_baseUrl = "baseUrl";

	@DsField
	private String targetRefid;

	@DsField
	private String targetAlias;

	@DsField
	private String targetType;

	@DsField
	private String name;

	@DsField
	private String location;

	@DsField
	private String contentType;

	@DsField(fetch = false)
	private String url;

	@DsField(join = "left", path = "type.id")
	private String typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField(join = "left", path = "type.category")
	private String category;

	@DsField(join = "left", path = "type.baseUrl")
	private String baseUrl;

	public Attachment_Ds() {
		super();
	}

	public Attachment_Ds(Attachment e) {
		super(e);
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
