package cdu.edu.hospital.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.PatientCode;
import cdu.edu.hospital.entity.Ward;
import cdu.edu.hospital.service.BedService;
import cdu.edu.hospital.service.PatientService;
import cdu.edu.hospital.service.WardService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	BedService bedService;
	
	@Autowired
	WardService wardService;
	
	//������Ժ�Ǽ�
	@RequestMapping("/patientAdd.do")
	@ResponseBody
	public JsonResult<Patient> patientAdd(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		Patient patient = new Patient();
		patient.setPatientId(System.currentTimeMillis()+"");
		patient.setName(request.getParameter("name"));
		patient.setDoctorId(BaseUtils.toInteger(request.getParameter("doctorNo")));
		patient.setNation(BaseUtils.toInteger(request.getParameter("nationNo")));
		patient.setDepartment(BaseUtils.toInteger(request.getParameter("departmentNo")));
		patient.setCerificateNo(request.getParameter("cerificateNo"));
		patient.setWorkUnit(request.getParameter("workUnit"));
		patient.setMaritalStatus(BaseUtils.toInteger(request.getParameter("marryNo")));
		patient.setGender(BaseUtils.toInteger(request.getParameter("genderNo")));
		patient.setHomeAddress(request.getParameter("homeAddress"));
		patient.setHomePhone(request.getParameter("homePhone"));
		patient.setContacts(request.getParameter("contacts"));
		patient.setContactsPhone(request.getParameter("contactsPhone"));
		patient.setAdmissionStatus(BaseUtils.toInteger(request.getParameter("statusNo")));
		patient.setRoomType(BaseUtils.toInteger(request.getParameter("typeNo")));
		patient.setRoomNo(BaseUtils.toInteger(request.getParameter("wardNo")));
		patient.setBedNo(BaseUtils.toInteger(request.getParameter("bedNo")));
		patient.setBirth(BaseUtils.toDate(request.getParameter("birth")));
		patient.setState(0);//�����Ƿ��Ժ
		System.out.println("patient:"+patient);
		//���没����Ϣ
		patientService.patientAdd(patient);
		//��¼��λ��Ϣ
		wardService.logWard(patient);
		//���Ĵ�λ��״̬
		Bed bed = new Bed();
		bed.setWardNo(patient.getRoomNo());
		bed.setBedNo(patient.getBedNo());
		bed.setState(1);
		bedService.bedUpdate(bed);
		//�жϷ����Ƿ�����������͸ı�״̬
		Integer sum = bedService.bedStateQuery(bed);
		if(sum==4){
			//�ı䲡����״̬
			Ward ward = new Ward();
			ward.setWardNo(bed.getWardNo());
			ward.setState(1);
			wardService.wardUpdate(ward);
		}
		return new JsonResult<Patient>(new Patient());
	}
	
	@RequestMapping("/patientQuery.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> patientQuery(HttpServletRequest request) throws ParseException{
		PatientCode patientCode = new PatientCode();
		String patientId = BaseUtils.toString(request.getParameter("patientId"));
		String name = BaseUtils.toString(request.getParameter("name"));
		patientCode.setPatientId(patientId);
		patientCode.setDepartmentNo(BaseUtils.toInteger(request.getParameter("departmentNo")));
		patientCode.setName(name);
		patientCode.setWardNo(BaseUtils.toInteger(request.getParameter("wardNo")));
		patientCode.setBedNo(BaseUtils.toInteger(request.getParameter("bedNo")));
		patientCode.setStart(BaseUtils.toDate(request.getParameter("start")));
		patientCode.setEnd(BaseUtils.toDate(request.getParameter("end")));
		patientCode.setOutStatus(0);
		List<Map<String, Object>> list = patientService.patientQuery(patientCode);
		return new JsonResult<List<Map<String, Object>>>(list);
	}
	
	/**
	 * ���Ĳ���
	 * @param request
	 * @return
	 */
	@RequestMapping("/patientUpdate.do")
	@ResponseBody
	public JsonResult<Patient> patientUpdate(HttpServletRequest request){
		String patientId = BaseUtils.toString(request.getParameter("patientId"));
		Integer departmentNo = BaseUtils.toInteger(request.getParameter("departmentNo"));
		Integer typeNo = BaseUtils.toInteger(request.getParameter("typeNo"));
		Integer wardNo = BaseUtils.toInteger(request.getParameter("wardNo"));
		Integer bedNo = BaseUtils.toInteger(request.getParameter("bedNo"));
		Integer doctorNo = BaseUtils.toInteger(request.getParameter("doctorNo"));
		Integer ybed = BaseUtils.toInteger(request.getParameter("ybed"));
		Integer yroom = BaseUtils.toInteger(request.getParameter("yroom"));
		Patient patient = new Patient();
		patient.setPatientId(patientId);
		patient.setDepartment(departmentNo);
		patient.setRoomType(typeNo);
		patient.setBedNo(bedNo);
		patient.setRoomNo(wardNo);
		patient.setDoctorId(doctorNo);
		System.out.println("doctor:"+patient);
		//���²�����Ϣ
		patientService.patientUpdate(patient);
		//��¼�ı䴲λ��¼
		wardService.logWard(patient);
		//�ı�ԭ��λ��״̬Ϊ��ס
		Bed bed = new Bed();
		bed.setBedNo(ybed);
		bed.setState(0);
		bedService.bedUpdate(bed);
		//�ж�ԭ�����Ƿ�����
		Ward ward = wardService.wardQueryById(yroom);
		if(ward.getState()==1){
			//�ı䷿��״̬Ϊδ��
			Ward ward2 = new Ward();
			ward2.setWardNo(yroom);
			ward2.setState(0);
			wardService.wardUpdate(ward2);
		}
		return new JsonResult<Patient>(patient);	
	}
	/**
	 * ��Ժ����
	 * @param patientId
	 * @return
	 */
	@RequestMapping("/jiesuan.do")
	@ResponseBody
	public JsonResult<Patient> jiesuan(String patientId){
		patientService.jiesuan(patientId);
		return new JsonResult<Patient>(new Patient());
	} 
	
	/**
	 * ��Ժ�Ǽ� 
	 * @param patientId
	 * @return
	 */
	@RequestMapping("/patientLeave.do")
	@ResponseBody
	public JsonResult<Patient> patientLeave(String patientId,Integer bedNo,Integer roomNo){
		//�ı䲡�˵��Ƿ��Ժ��״̬
		patientService.patientLeave(patientId);
		//�ı�ԭ��λ��״̬Ϊ��ס
		Bed bed = new Bed();
		bed.setBedNo(bedNo);
		bed.setState(0);
		bedService.bedUpdate(bed);
		//�ж�ԭ�����Ƿ�����
		Ward ward = wardService.wardQueryById(roomNo);
		if(ward.getState()==1){
			//�ı䷿��״̬Ϊδ��
			Ward ward2 = new Ward();
			ward2.setWardNo(roomNo);
			ward2.setState(0);
			wardService.wardUpdate(ward2);
		}
		return new JsonResult<Patient>(new Patient());
	} 
	
	/**
	 * ��Ժ��ѯ 
	 * @param patientId
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/leftFind.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> leftFind(String patientId,String patientName,
			String inStart,String inEnd,String outStart,String outEnd) throws ParseException{
		PatientCode patientCode = new PatientCode();
		patientCode.setPatientId(BaseUtils.toString(patientId));
		patientCode.setName(BaseUtils.toString(patientName));
		patientCode.setStart(BaseUtils.toDate(inStart));
		patientCode.setEnd(BaseUtils.toDate(inEnd));
		patientCode.setOutStart(BaseUtils.toDate(outStart));
		patientCode.setOutEnd(BaseUtils.toDate(outEnd));
		patientCode.setOutStatus(1);
		System.out.println("patientCode:"+patientCode);
		List<Map<String, Object>> list = patientService.patientQuery(patientCode);
		System.out.println("list:"+list);
		return new JsonResult<List<Map<String, Object>>>(list);
	} 
	 /**
	  * ͳ�Ʋ�ѯ
	  * @param startTime
	  * @param endTime
	  * @return
	  * @throws ParseException
	  */
	@RequestMapping("/patientStatistics.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> patientStatistics(String startTime,String endTime) throws ParseException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("startTime", BaseUtils.toDate(startTime));
		map.put("endTime", BaseUtils.toDate(endTime));
		List<Map<String, Object>> list = patientService.patientStatistics(map);
		System.out.println("list:"+list);
		return new JsonResult<List<Map<String,Object>>>(list);
	}
}