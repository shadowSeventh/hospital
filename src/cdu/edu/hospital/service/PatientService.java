package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.PatientCode;

public interface PatientService {
	/**
	 * ���˵����
	 * @param patient
	 */
	public void patientAdd(Patient patient);
	/**
	 * �����б��ѯ
	 * @param patientCode
	 * @return
	 */
	public List<Map<String, Object>> patientQuery(PatientCode patientCode);
	/**
	 * ���²�����Ϣ
	 * @param patient
	 */
	public void patientUpdate(Patient patient);
	/**
	 * ���ý���
	 * @param patientId
	 */
	public void jiesuan(String patientId);
	/**
	 * ��Ժ�Ǽ�
	 * @param patientId
	 */
	public void patientLeave(String patientId);
	/**
	 * ͳ�Ʋ�ѯpatientStatistics
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> patientStatistics(Map<String, Object> map);
}
