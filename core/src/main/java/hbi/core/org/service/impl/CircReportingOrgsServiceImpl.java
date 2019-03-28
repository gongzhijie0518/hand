package hbi.core.org.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hbi.core.org.dto.CircReportingOrgs;
import hbi.core.org.service.ICircReportingOrgsService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CircReportingOrgsServiceImpl extends BaseServiceImpl<CircReportingOrgs> implements ICircReportingOrgsService{

}