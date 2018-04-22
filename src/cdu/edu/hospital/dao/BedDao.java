package cdu.edu.hospital.dao;

import java.util.List;

import cdu.edu.hospital.entity.Bed;

public interface BedDao {
	/**
	 * ������ѯ
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
