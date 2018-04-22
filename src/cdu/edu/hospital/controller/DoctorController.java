package cdu.edu.hospital.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cdu.edu.hospital.entity.Doctor;
import cdu.edu.hospital.entity.DoctorCode;
import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.service.DoctorService;
import cdu.edu.hospital.util.JsonResult;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorSercice;

	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult<Doctor> doctorSave(String name, Integer title, Integer department, Integer gender, String time,
			HttpServletResponse response) throws ParseException {
		Doctor doctor = new Doctor();
		if (!(time == null || "".equals(time))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date worktime = (Date) sdf.parse(time);
			Date utilDate=worktime;
			java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
			doctor.setWorkTime(sqlDate);
		}
		doctor.setName(name);
		doctor.setGender(gender);
		doctor.setTitle(title);
		doctor.setDepartment(department);
		doctorSercice.doctorSave(doctor);
		return new JsonResult<Doctor>(doctor);
	}
	/**
	 * ҽ����Ϣ��ѯ
	 * @param name ����
	 * @param startTime ��ְ��ʼʱ��
	 * @param endTime ��ְ����ʱ��
	 * @param title ְ��
	 * @param department ����
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/doctorQuery.do")
	@ResponseBody
	public JsonResult<List<Doctor>> doctorQuery(String name, String startTime, String endTime, Integer title,
			Integer department,Integer state) throws ParseException {
		DoctorCode doctorCode = new DoctorCode();
		doctorCode.setTitle(title);
		doctorCode.setName(name);
		doctorCode.setDepartment(department);
		if(state!=null){
			if(state == -1){
				state = null;
			}
		}
		doctorCode.setState(state);
		if(!(startTime==null||"".equals(startTime))){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date start = (Date) sdf.parse(startTime);  
			doctorCode.setStartTime(start);
		}
		if(!(endTime==null||"".equals(endTime))){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date end = (Date) sdf.parse(endTime); 
			doctorCode.setEndTime(end);
		}
		List<Doctor> list = doctorSercice.doctorQuery(doctorCode);
		return new JsonResult<List<Doctor>>(list);
	}
	/**
	 * ɾ��ҽ����Ϣ(��ְ)
	 */
	@RequestMapping("/doctorDelete.do")
	@ResponseBody
	public JsonResult<Doctor> doctorDelete(Integer id,HttpServletResponse response){
		if(id==null||"".equals(id)){
			return new JsonResult<Doctor>(3,"��ҽ��������",null);
		}
		doctorSercice.doctorDelete(id);
		return new JsonResult<Doctor>(new Doctor());
	}
	/**
	 * ����ҽ����Ϣ
	 * @param id
	 * @param name
	 * @param keshi
	 * @param zhicheng
	 * @param gender
	 * @return
	 */
	@RequestMapping("/updateDoctorMessage.do")
	@ResponseBody
	public JsonResult<Doctor> updateDoctorMessage(Integer id,String name,Integer keshi,Integer zhicheng,Integer gender){
		Doctor doctor = new Doctor();
		doctor.setId(id);
		doctor.setName(name);
		doctor.setDepartment(keshi);
		doctor.setTitle(zhicheng);
		doctor.setGender(gender);
		doctorSercice.updateDoctorMessage(doctor);
		return new JsonResult<Doctor>(doctor);
	}
}
