package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.WardDao;
import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.Ward;
@Service("wardService")
public class WardServiceImpl implements WardService{
	
	@Autowired
	WardDao wardDao;
	
	/**
	 * ����������
	 */
	@Override
	public void wardSave(Ward ward) {
		 wardDao.wardSave(ward);
	}
	/**
	 * ���Ӵ�λ
	 */
	@Override
	public void bedSave(Bed bed) {
		wardDao.bedSave(bed);
	}
	 
	/**
	 * ���Ĳ���״̬
	 */
	@Override
	public void wardUpdate(Ward ward) {
		 wardDao.wardUpdate(ward);
	}
	/**
	 * �����Ĳ�ѯ
	 */
	 
	@Override
	public Ward wardQueryById(Integer wardId) {
		return wardDao.wardQueryById(wardId);
	}
	@Override
	public List<Ward> wardQuery(Ward ward) {
		return wardDao.wardQuery(ward);
	}
	/**
	 * ��¼������Ϣ
	 */
	@Override
	public void logWard(Patient patient) {
		wardDao.logWard(patient);
		
	}
	/**
	 * ����ʹ�����ͳ��
	 */
	@Override
	public List<Map<String, Object>> wardStatistics(Integer id) {
		//��ѯ��������
		List<Map<String, Object>> list = wardDao.departQuery(id);
		//��ѯÿ�����ҵ��ܴ�λ
		List<Map<String, Object>> list1 = wardDao.bedTotal(id);
		//��ѯÿ��������δʹ�õĴ�λ
		List<Map<String, Object>> list2 = wardDao.bedWy(id);
		for(Map<String, Object> map: list){
			for(Map<String,Object> map1:list1){
				String depart1 = map.get("parameter_values")+"";
				String depart2 = map1.get("departmentNo")+"";
				if(depart1.equals(depart2)){
					map.put("total",map1.get("total"));
				}
			}
		}
		for(Map<String, Object> map: list){
			for(Map<String,Object> map1:list2){
				String depart1 = map.get("parameter_values")+"";
				String depart2 = map1.get("departmentNo")+"";
				if(depart1.equals(depart2)){
					map.put("wy",map1.get("total"));
				}
			}
		}
		return list;
	}

}
