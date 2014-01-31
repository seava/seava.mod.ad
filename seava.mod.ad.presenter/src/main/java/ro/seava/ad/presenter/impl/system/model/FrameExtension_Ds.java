/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.FrameExtension;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.presenter.model.AbstractAuditableDs;

@Ds(entity = FrameExtension.class)
public class FrameExtension_Ds extends AbstractAuditableDs<FrameExtension> {
	public static final String f_frame = "frame";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_fileLocation = "fileLocation";
	public static final String f_relativePath = "relativePath";

	@DsField
	private String frame;

	@DsField
	private Integer sequenceNo;

	@DsField
	private String fileLocation;

	@DsField
	private Boolean relativePath;

	public FrameExtension_Ds() {
		super();
	}

	public FrameExtension_Ds(FrameExtension e) {
		super(e);
	}

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public Boolean getRelativePath() {
		return this.relativePath;
	}

	public void setRelativePath(Boolean relativePath) {
		this.relativePath = relativePath;
	}
}
