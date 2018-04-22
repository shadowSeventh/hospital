package
cdu.edu.hospital.dao;

import java.util.List;
import java.util.Map;

import org.junit.validator.PublicClassValidator;

import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.PatientCode;

public interface PatientDao {
	/**
	 * ���˵����
	 * @param patient
	 */
	public void patientAdd(Patient patient);
	/**
	 * �����б�Ĳ�ѯ
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
	public void jiesun(String patientId);
	/**
	 * ��Ժ�Ǽ�
	 */
	public void patientLeave(String patientId);
	/**
	 * ��Ժͳ��
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> inHospital(Map<String, Object> map);
	/**
	 * ��Ժͳ��
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> outHospital(Map<String, Object> map);
	/**
	 * ���Ҳ�ѯ
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> departmentQuery(Map<String, Object> map);
	
 }
