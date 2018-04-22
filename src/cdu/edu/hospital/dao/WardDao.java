package cdu.edu.hospital.dao;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.Ward;

public interface WardDao {
	/**
	 * ���������
	 */
	public void wardSave(Ward ward);	
	/**
	 * ���Ӵ�λ
	 * @param bed
	 */
	public void bedSave(Bed bed);
	/**
	 * �����Ĳ�ѯ
	 */
	public Ward wardQueryById(Integer wardId);
	public List<Ward> wardQuery(Ward ward);
	/**
	 * ���Ĳ���״̬
	 * @param wardNo
	 */
	public void wardUpdate(Ward ward);
	/**
	 * ��¼������Ϣ
	 * @param patient
	 */
	public void logWard(Patient patient);
	/**
	 * ���Ҳ�ѯ
	 * @param departNo
	 * @return
	 */
	public List<Map<String, Object>> departQuery(Integer departNo);
	/**
	 * ÿ�����ҵĲ�������
	 * @param departNo
	 * @return
	 */
	public List<Map<String, Object>> bedTotal(Integer departNo);
	/**
	 * ÿ�����ұ�ʹ�õ�����
	 * @param departNo
	 * @return
	 */
	public List<Map<String, Object>> bedWy(Integer departNo);
	
	
	
}
	 
