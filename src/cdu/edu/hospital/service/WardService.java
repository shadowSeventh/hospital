package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.Ward;

public interface WardService {
	/**
	 * ���������
	 * @param ward
	 */
	public void wardSave(Ward ward);
	/**
	 * ���Ӵ�λ
	 * @param bed
	 */
	public void bedSave(Bed bed);
	/**
	 * ������ѯ
	 */
	public Ward wardQueryById(Integer wardId);
	public List<Ward> wardQuery(Ward ward);
	/**
	 * ���Ĳ���״̬
	 * @param wardNo
	 */
	public void wardUpdate(Ward ward);
	/**
	 * �ı䴲λ
	 * @param patient
	 */
	public void logWard(Patient patient);
	/**
	 * ����ʹ�����ͳ��
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> wardStatistics(Integer id);
	
	
	
}
