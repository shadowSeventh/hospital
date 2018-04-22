package cdu.edu.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.CommonDao;
import cdu.edu.hospital.dao.DoctorDao;
import cdu.edu.hospital.entity.Doctor;
import cdu.edu.hospital.entity.DoctorCode;

@Service("doctorService")
public class DoctorServerImpl implements DoctorService{
	@Autowired //ע������ID�� commonDao
	private  DoctorDao doctorDao;
	
	/**
	 * ҽ����Ϣ�ı���
	 */
	@Override
	public void doctorSave(Doctor doctor) {
		doctorDao.doctorSave(doctor);
	}
	/**
	 * ҽ����Ϣ�Ĳ�ѯ
	 */
	@Override
	public List<Doctor> doctorQuery(DoctorCode doctorCode) {
		return doctorDao.doctorQuery(doctorCode);
	}
	/**
	 * ɾ��ҽ����Ϣ
	 */
	@Override
	public void doctorDelete(Integer id) {
		doctorDao.doctorDelete(id);
	}
	/**
	 * ����ҽ����Ϣ
	 */
	@Override
	public void updateDoctorMessage(Doctor doctor) {
		doctorDao.updateDoctorMessage(doctor);
	}
	 

}
