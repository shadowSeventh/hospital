package cdu.edu.hospital.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.entity.Ward;
import cdu.edu.hospital.service.WardService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;

@Controller
@RequestMapping("/ward")
public class WardController {
	@Autowired
	WardService wardService;
	
	@RequestMapping("/wardQuery.do")
	@ResponseBody
	public JsonResult<List<Ward>> wardQuery(HttpServletRequest request,HttpServletResponse response){
		Ward ward = new Ward();
		List<Ward> list = null;
		String departmentNo = request.getParameter("departmentNo");
		String typeNo = request.getParameter("typeNo");
		if(departmentNo==null||"".equals(departmentNo)){
			 list = wardService.wardQuery(new Ward());
		}else{
			ward.setDepartmentNo(BaseUtils.toInteger(departmentNo));
			ward.setType(BaseUtils.toInteger(typeNo));
			ward.setState(0);
			list = wardService.wardQuery(ward);
		}
		return new JsonResult<List<Ward>>(list);
	}
	
	@RequestMapping("/wardSave.do")
	@ResponseBody
	public JsonResult<Ward> wardSave(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		Ward ward = new Ward();
		ward.setCreateTime(BaseUtils.toDate(request.getParameter("createTime")));
		ward.setDepartmentNo(BaseUtils.toInteger(request.getParameter("departmentNo")));
		ward.setType(BaseUtils.toInteger(request.getParameter("typeNo")));
		ward.setWardNo(BaseUtils.toInteger(request.getParameter("wardNo")));
		ward.setState(0);
//		System.out.println("ward:"+ward);
		//Ϊ��������������
		wardService.wardSave(ward);
		//Ϊ��λ����������
		Integer i=BaseUtils.toInteger(request.getParameter("wardNo"));
		Integer start = 4*(i-1)+1;
		for(int a=start;a<=i*4;a++){
			//ÿ����һ���������������Ŵ�λ����λ��Ϊ�����ŵ��ı�
			Bed bed = new Bed();
			bed.setBedNo(a);
			bed.setWardNo(i);
			bed.setState(0);
//			System.out.println("bed:"+bed);
			wardService.bedSave(bed);
		}
		return new JsonResult<Ward>(ward);
	}
	
	//��λ��ʹ�����ͳ��
	@RequestMapping("/wardStatistics.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> wardStatistics(Integer departmentNo){
		List<Map<String, Object>> list = wardService.wardStatistics(departmentNo);
		System.out.println("List:"+list);
		return new JsonResult<List<Map<String,Object>>>(list);
	}
	 
}
