package cdu.edu.hospital.dao;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.Cost;

public interface CostDao {
	/**
	 * Ԥ�����õı���
	 * @param cost
	 */
	public void costAdd(Cost cost);
	/**
	 * Ԥ�����ò�ѯ
	 * @param cost
	 * @return
	 */
	public List<Map<String, Object>> costQuery(Map map);
	/**
	 * ҩƷ����
	 * @param map
	 * @return
	 */
	public Map<String, Object> drugsCostQuery(Map map);
	/**
	 * ��ҩ����
	 * @param map
	 * @return
	 */
	public Map<String, Object> drugWithdrawal(Map map);
	/**
	 * ��ҩ����
	 * @param map
	 * @return
	 */ 
	public Map<String, Object> costQueryTotal(Map map);
	/**
	 * ��λ����
	 */
	public List<Map<String, Object>> bedCodeQuery(Map map);
	 
}
