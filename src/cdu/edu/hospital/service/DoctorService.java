package cdu.edu.hospital.service;

import java.util.List;

import cdu.edu.hospital.entity.Doctor;
import cdu.edu.hospital.entity.DoctorCode;

/**
 * ҽ���ķ���ӿ�
 * @author ��
 *
 */
public interface DoctorService {
	/**
	 * ҽ����Ϣ�ı���
	 * @param doctor
	 */
	public void doctorSave(Doctor doctor);
	/**ҽ����Ϣ�Ĳ�ѯ
	 * 
	 * @param doctorCode
	 * @return
	 */
	public List<Doctor> doctorQuery(DoctorCode doctorCode);
	/**
	 * ɾ��ҽ����Ϣ
	 * @param id
	 */
	public void doctorDelete(Integer id);
	/**
	 * ����ҽ����Ϣ
	 * @param doctor
	 */
	public void updateDoctorMessage(Doctor doctor);
}
