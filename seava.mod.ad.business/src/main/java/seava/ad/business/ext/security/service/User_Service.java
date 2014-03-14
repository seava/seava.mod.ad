/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package seava.ad.business.ext.security.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.transaction.annotation.Transactional;

import seava.j4e.api.exceptions.BusinessException;
import seava.j4e.api.exceptions.ErrorCode;
import seava.j4e.api.security.IPasswordValidator;
import seava.j4e.api.session.Session;
import seava.ad.business.api.security.IUserService;
import seava.ad.domain.impl.security.User;

/**
 * Business extensions specific for {@link User} domain entity.
 * 
 */
public class User_Service extends seava.ad.business.impl.security.User_Service
		implements IUserService {

	@Override
	protected void preInsert(User e) throws BusinessException {
		if (e.getPassword() == null || "".equals(e.getPassword())) {
			e.setPassword(this.encryptPassword(e.getLoginName()));
		}
	}

	@Override
	@Transactional
	public void doChangePassword(String userId, String newPassword)
			throws BusinessException {

		User u = this.findById(userId);
		if (!u.getClientId().equals(Session.user.get().getClientId())) {
			throw new BusinessException(ErrorCode.G_CLIENT_MISMATCH,
					"Acces to a different client is not allowed!");
		}
		try {
			this.getApplicationContext().getBean(IPasswordValidator.class)
					.validate(newPassword);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.G_RUNTIME_ERROR,
					"Pasword validation failed.", e);
		}
		u.setPassword(this.encryptPassword(newPassword));
		this.getEntityManager().merge(u);

	}

	private String encryptPassword(String password) throws BusinessException {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new BusinessException(ErrorCode.G_RUNTIME_ERROR,
					"No `MD5` algorithm found.", e);
		}
		messageDigest.update(password.getBytes(), 0, password.length());
		String hashedPass = new BigInteger(1, messageDigest.digest())
				.toString(16);
		if (hashedPass.length() < 32) {
			hashedPass = "0" + hashedPass;
		}
		return hashedPass;
	}

}
