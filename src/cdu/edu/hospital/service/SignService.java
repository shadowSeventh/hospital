package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.PatientCode;
import cdu.edu.hospital.entity.Sign;

public interface SignService {
	/**
	 * ��������¼��
	 * @param sign
	 */
	public void signSave(Sign sign);
	/**
	 * �������ݲ�ѯ
	 * @param patientCode
	 * @return
	 */
	public List<Map<String, Object>> signQuery(PatientCode patientCode);
}
