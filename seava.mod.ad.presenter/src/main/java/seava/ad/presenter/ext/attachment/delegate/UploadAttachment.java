package seava.ad.presenter.ext.attachment.delegate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import seava.ad.business.api.attachment.IAttachmentService;
import seava.ad.domain.impl.attachment.Attachment;
import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.descriptor.IUploadedFileDescriptor;
import seava.j4e.api.exceptions.BusinessException;
import seava.j4e.api.service.IFileUploadService;
import seava.j4e.presenter.service.AbstractPresenterDelegate;

public class UploadAttachment extends AbstractPresenterDelegate implements
		IFileUploadService {

	public static final String KEY_ID = "a_id";
	public static final String KEY_NAME = "a_name";
	public static final String KEY_TYPEID = "a_typeId";
	public static final String KEY_CATEGORY = "a_category";
	public static final String KEY_TARGETALIAS = "a_targetAlias";
	public static final String KEY_TARGETREFID = "a_targetRefid";
	public static final String KEY_TARGETTYPE = "a_targetType";

	private List<String> paramNames;

	public UploadAttachment() {
		super();
		paramNames = new ArrayList<String>();
		paramNames.add(KEY_ID);
		paramNames.add(KEY_NAME);
		paramNames.add(KEY_TYPEID);
		paramNames.add(KEY_CATEGORY);

		paramNames.add(KEY_TARGETALIAS);
		paramNames.add(KEY_TARGETREFID);
		paramNames.add(KEY_TARGETTYPE);

	}

	@Override
	public List<String> getParamNames() {
		return paramNames;
	}

	@Override
	public Map<String, Object> execute(IUploadedFileDescriptor fileDescriptor,
			InputStream inputStream, Map<String, String> params)
			throws Exception {

		String id = params.get(KEY_ID);
		String name = params.get(KEY_NAME);
		String typeId = params.get(KEY_TYPEID);
		String category = params.get(KEY_CATEGORY);

		String targetAlias = params.get(KEY_TARGETALIAS);
		String targetRefid = params.get(KEY_TARGETREFID);
		String targetType = params.get(KEY_TARGETTYPE);

		Map<String, Object> result = new HashMap<String, Object>();

		IAttachmentService srv = (IAttachmentService) this
				.findEntityService(Attachment.class);

		AttachmentType attchType = srv.findById(typeId, AttachmentType.class);

		String path = attchType.getUploadPath();

		if (path == null || "".equals(path)) {
			throw new BusinessException(
					"No upload path specified for attachment type `"
							+ attchType.getName() + "`");
		}
		String extension = fileDescriptor.getOriginalName().substring(
				fileDescriptor.getOriginalName().lastIndexOf('.') + 1);

		// create attachment record

		if (id == null || "".equals(id)) {
			Attachment a = new Attachment();
			a.setType(attchType);
			a.setFileName(fileDescriptor.getOriginalName());
			a.setName(name);
			a.setActive(true);
			a.setTargetAlias(targetAlias);
			a.setTargetRefid(targetRefid);
			a.setTargetType(targetType);
			a.setContentType(extension);

			srv.insert(a);

			id = a.getId();
		}

		// save file to disk

		String newFileName = id + "." + extension;
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		OutputStream outputStream = new FileOutputStream(path + "/"
				+ newFileName);
		IOUtils.copy(inputStream, outputStream);
		outputStream.close();

		return result;
	}

}
