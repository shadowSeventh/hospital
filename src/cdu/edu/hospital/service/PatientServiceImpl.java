package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cdu.edu.hospital.dao.PatientDao;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.PatientCode;

@Service("patientService")
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientDao patientDao;
	
	/**
	 * ���˵����
	 */
	@Override
	public void patientAdd(Patient patient) {
		patientDao.patientAdd(patient);
	}
	/**
	 * �����б��ѯ
	 */
	@Override
	public List<Map<String, Object>> patientQuery(PatientCode patientCode) {
		return patientDao.patientQuery(patientCode);
	}
	/**
	 * ���²�����Ϣ
	 */
	@Override
	public void patientUpdate(Patient patient) {
		patientDao.patientUpdate(patient);
	}
	/**
	 * ���ý���
	 */
	@Override
	public void jiesuan(String patientId) {
		 patientDao.jiesun(patientId);
	}
	/**
	 * ��Ժ�Ǽ�
	 */
	@Override
	public void patientLeave(String patientId) {
		patientDao.patientLeave(patientId);
	}
	/**
	 * ͳ�Ʋ�ѯ
	 */
	@Override
	public List<Map<String, Object>> patientStatistics(Map<String, Object> map) {
		int inHospitalTotal = 0;
		int outHospitalTotal = 0;
		//��ѯ��Ժͳ��
		List<Map<String, Object>> inList = patientDao.inHospital(map);
		//��ѯ�����еĿ���
		List<Map<String, Object>> list = patientDao.departmentQuery(null);
		if(list!=null){
			for(Map<String,Object> okMap:list){
				for(Map<String, Object> map2:inList){
					String id1 = okMap.get("parameter_values")+"";
					String id2 = map2.get("departmentId")+"";
					if(id1.equals(id2)){
						okMap.put("inNum", map2.get("number"));
						inHospitalTotal = Integer.parseInt(map2.get("total").toString());
						okMap.put("inPercentage",map2.get("percentage"));
					}
				}
			}
		}
		//��ѯ��Ժͳ��
		List<Map<String,Object>> outList = patientDao.outHospital(map);
		for(Map<String,Object> okMap:list){
			for(Map<String, Object> map2:outList){
				String id1 = okMap.get("parameter_values")+"";
				String id2 = map2.get("departmentId")+"";
				if(id1.equals(id2)){
					okMap.put("outNum", map2.get("number"));
					outHospitalTotal = Integer.parseInt(map2.get("total").toString());
					okMap.put("outPercentage",map2.get("percentage"));
				}
			}
		}
		for(Map<String,Object> okMap:list){
			okMap.put("inTotal", inHospitalTotal);
			okMap.put("outTotal", outHospitalTotal);
		}
		return list;
	}
 
 

}
