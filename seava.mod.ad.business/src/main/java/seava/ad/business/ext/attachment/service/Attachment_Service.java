/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.ext.attachment.service;

import seava.ad.business.api.attachment.IAttachmentService;
import seava.ad.domain.impl.attachment.Attachment;
import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.exceptions.BusinessException;

/**
 * Business extensions specific for {@link Attachment} domain entity.
 * 
 */
public class Attachment_Service extends
		seava.ad.business.impl.attachment.Attachment_Service implements
		IAttachmentService {

	@Override
	protected void preInsert(Attachment e) throws BusinessException {
		String name = e.getName();

		if (name == null || "".equals(name)) {
			AttachmentType type = e.getType();
			if (type == null) {
				throw new BusinessException("No type specified for attachment.");
			}
			if (type.getCategory().matches("link")) {
				e.setName(e.getLocation());
			} else {
				e.setName(e.getFileName());
			}
		}
		super.preInsert(e);
	}

}
