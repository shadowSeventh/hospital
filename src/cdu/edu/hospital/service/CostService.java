package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.Cost;

public interface CostService {
	/**
	 * Ԥ�����ñ���
	 * @param cost
	 */
	public void costAdd(Cost cost);
	
	/**
	 * Ԥ�����ò�ѯ
	 */
	public List<Map<String, Object>> costQuery(Map map);
	/**
	 * ���ý����ѯ
	 */
	public List<Map<String, Object>> costTotal(String patientId);
	
}
