/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package seava.ad.business.ext.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ro.seava.j4e.api.descriptor.ISysParamDefinition;
import ro.seava.j4e.api.descriptor.ISysParamDefinitions;
import ro.seava.j4e.api.exceptions.BusinessException;
import seava.ad.business.api.system.IParamService;
import seava.ad.domain.impl.system.Param;

/**
 * Business extensions specific for {@link Param} domain entity.
 * 
 */
public class Param_Service extends
		seava.ad.business.impl.system.Param_Service implements
		IParamService {

	@Override
	@Transactional
	public void doSynchronizeCatalog() throws BusinessException {

		List<ISysParamDefinitions> defs = this.getSettings()
				.getParamDefinitions();
		List<Param> entities = new ArrayList<Param>();
		for (ISysParamDefinitions def : defs) {
			for (ISysParamDefinition d : def.getSysParamDefinitions()) {
				Param e = new Param();
				e.setActive(true);
				e.setCode(d.getName());
				e.setName(d.getTitle());
				e.setDefaultValue(d.getDefaultValue());
				e.setListOfValues(d.getListOfValues());
				e.setDescription(d.getDescription());
				entities.add(e);
			}
		}

		this.update("delete from " + Param.class.getSimpleName(), null);
		this.insert(entities);
	}

}
