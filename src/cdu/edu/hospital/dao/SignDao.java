package cdu.edu.hospital.dao;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.PatientCode;
import cdu.edu.hospital.entity.Sign;

public interface SignDao {
	/**
	 * ��������¼��
	 * @param sign
	 */
	public void signSave(Sign sign);
	/**
	 * �����������ݲ�ѯ
	 * @param patientCode
	 * @return
	 */
	public  List<Map<String, Object>> signQuery(PatientCode patientCode);
		
}
