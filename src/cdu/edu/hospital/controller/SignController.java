package cdu.edu.hospital.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.PatientCode;
import cdu.edu.hospital.entity.Sign;
import cdu.edu.hospital.service.SignService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;
/**
 * ����������Ϣ�Ĵ�����
 * @author ��
 *
 */

@Controller
@RequestMapping("/sign")
public class SignController {
	
	@Autowired
	SignService signService;
	
	/**
	 * ����������Ϣ�ı���
	 * @param patientId סԺ��
	 * @param patientName ��������
	 * @param bedNo 	��λ��
	 * @param measureTime ����ʱ��
	 * @param temperature ����
	 * @param pulse	����
	 * @param breathing ����
	 * @param bloodSugar Ѫ��
	 * @param bloodPressure Ѫѹ
	 * @param vein ����
	 * @param remarks ��ע
	 * @param response
	 * @return
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/signSave.do")
	@ResponseBody
	public JsonResult<Sign> signSave(String patientId,String measureTime,String temperature,String pulse,
			String breathing,String bloodSugar,String bloodPressure,String vein,String remarks,
			HttpServletRequest request) throws ParseException, UnsupportedEncodingException{
		Sign sign = new Sign();
		sign.setPatientId(BaseUtils.toString(patientId));
		sign.setMeasureTime(BaseUtils.toDates(measureTime));
		sign.setTemperature(BaseUtils.toFloat(temperature));
		sign.setPulse(BaseUtils.toInteger(pulse));
		sign.setBreathing(BaseUtils.toInteger(breathing));
		sign.setBloodSugar(BaseUtils.toFloat(bloodSugar));
		sign.setBloodPressure(BaseUtils.toFloat(bloodPressure));
		sign.setVein(BaseUtils.toFloat(vein));
		sign.setRemarks(BaseUtils.toString(remarks));
		sign.setUserId(BaseUtils.getUser(request).getId());
		sign.setUserName(BaseUtils.getUser(request).getName());
		System.out.println("sign:"+sign);
		signService.signSave(sign);
		return new JsonResult<Sign>(sign); 
	}
	
	@RequestMapping("/signQuery.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> signQuery(HttpServletRequest request) throws ParseException{
		PatientCode patientCode = new PatientCode();
		String patientId = request.getParameter("patientId");
		String name = request.getParameter("name");
		if(patientId==null||"".equals(patientId)){
			patientId=null;
		}
		if(name==null||"".equals(name)){
			name = null;
		}
		patientCode.setPatientId(patientId);
		patientCode.setName(name);
		patientCode.setWardNo(BaseUtils.toInteger(request.getParameter("wardNo")));
		patientCode.setBedNo(BaseUtils.toInteger(request.getParameter("bedNo")));
		patientCode.setStart(BaseUtils.toDate(request.getParameter("start")));
		patientCode.setEnd(BaseUtils.toDate(request.getParameter("end")));
		System.out.println("PatientCode:"+patientCode);
		List<Map<String, Object>> list =  signService.signQuery(patientCode);
		System.out.println(list);
		return new JsonResult<List<Map<String,Object>>>(list);
	}
	
	
}
