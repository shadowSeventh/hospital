package cdu.edu.hospital.service;

import cdu.edu.hospital.dao.AdviceDao;
import cdu.edu.hospital.dao.SignDao;
import cdu.edu.hospital.entity.Advice;
import cdu.edu.hospital.entity.PatientCode;
import cdu.edu.hospital.entity.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adviceService")
public class AdviceServiceImpl implements AdviceService{
	
	@Autowired
	AdviceDao adviceDao;
	
	@Override
	public void adviceSave(Advice advice) {
		adviceDao.adviceSave(advice);
	}


	@Override
	public List<Map<String, Object>> adviceQuery(PatientCode patientCode) {
		return adviceDao.adviceQuery(patientCode);
	}

}
