package cdu.edu.hospital.service;

import java.util.List;

import cdu.edu.hospital.entity.Bed;

public interface BedService {
	/**
	 * ��λ��ѯ
	 * @param bed
	 * @return
	 */
	public List<Bed> bedQuery(Bed bed);	
	
	/**
	 * ���Ĵ�λ״̬
	 * @param bed
	 */
	public void bedUpdate(Bed bed);
	
	/**
	 * ��ѯ�����Ƿ�����
	 * @param bed
	 * @return
	 */
	public Integer bedStateQuery(Bed bed);
}
