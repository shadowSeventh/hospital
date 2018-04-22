package cdu.edu.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.BedDao;
import cdu.edu.hospital.entity.Bed;

@Service("bedService")
public class BedServiceImpl implements BedService{
	@Autowired
	BedDao bedDao;
	/**
	 * ��λ��ѯ
	 */
	@Override
	public List<Bed> bedQuery(Bed bed) {
		return bedDao.bedQuery(bed);
	}
	/**
	 * ���Ĵ�λ״̬
	 */
	@Override
	public void bedUpdate(Bed bed) {
		bedDao.bedUpdate(bed);
	}
	/**
	 * ��ѯ�����Ƿ�����
	 */
	@Override
	public Integer bedStateQuery(Bed bed) {
		return bedDao.bedStateQuery(bed);
	}

}
