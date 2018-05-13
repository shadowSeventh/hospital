package cdu.edu.hospital.service;

import cdu.edu.hospital.entity.Advice;
import cdu.edu.hospital.entity.PatientCode;

import java.util.List;
import java.util.Map;

public interface AdviceService {


	public void adviceSave(Advice advice);

	public List<Map<String, Object>> adviceQuery(PatientCode patientCode);
}
