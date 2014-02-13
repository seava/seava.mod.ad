package seava.ad.business.ext;

import java.util.Date;

import ro.seava.j4e.api.exceptions.BusinessException;
import ro.seava.j4e.api.service.IPersistableLog;
import ro.seava.j4e.api.service.IPersistableLogMessage;
import ro.seava.j4e.api.service.IPersistableLogService;
import ro.seava.j4e.api.service.job.IJob;
import ro.seava.j4e.business.service.AbstractBusinessBaseService;
import seava.ad.business.api.scheduler.IJobLogService;
import seava.ad.domain.impl.scheduler.JobContext;
import seava.ad.domain.impl.scheduler.JobLog;
import seava.ad.domain.impl.scheduler.JobLogMessage;
import seava.ad.domain.impl.scheduler.JobTimer;

public class PersistableJobLogService extends AbstractBusinessBaseService
		implements IPersistableLogService {

	@Override
	public String insert(IPersistableLog log) throws BusinessException {

		JobLog jl = new JobLog();
		jl.setStartTime((Date) log.getProperty(IJob.PLK_START_TIME));
		jl.setEndTime((Date) log.getProperty(IJob.PLK_END_TIME));

		for (IPersistableLogMessage m : log.getMessages()) {
			JobLogMessage jlm = new JobLogMessage();
			jlm.setJobLog(jl);
			jlm.setMessage(m.getMessage());
			jlm.setMessageType(m.getType());
			jl.addToMessages(jlm);
		}
		IJobLogService srv = (IJobLogService) this
				.findEntityService(JobLog.class);
		String jobContextId = (String) log.getProperty(IJob.PLK_JOB_CONTEXT);
		String jobTimerId = (String) log.getProperty(IJob.PLK_JOB_TIMER);

		if (jobContextId != null) {
			JobContext jobContext = srv.getEntityManager().find(
					JobContext.class, jobContextId);
			jl.setJobContext(jobContext);
		}

		if (jobTimerId != null) {
			JobTimer jobTimer = srv.getEntityManager().find(JobTimer.class,
					jobTimerId);
			jl.setJobTimer(jobTimer);
		}

		srv.insert(jl);
		return jl.getId();
	}

	@Override
	public String getType() {
		return IPersistableLogService.PL_TYPE_JOB;
	}

}
