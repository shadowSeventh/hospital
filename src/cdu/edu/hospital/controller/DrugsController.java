package cdu.edu.hospital.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.sun.org.apache.bcel.internal.generic.RET;

import cdu.edu.hospital.entity.Drugs;
import cdu.edu.hospital.entity.DrugsCode;
import cdu.edu.hospital.entity.Grant;
import cdu.edu.hospital.entity.Stock;
import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.entity.WithdrawalDrug;
import cdu.edu.hospital.service.DrugsService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;

@Controller
@RequestMapping("/drugs")
public class DrugsController {
	@Autowired
	DrugsService drugsService;
	
	@RequestMapping("/drugsSave.do")
	@ResponseBody
	public JsonResult<Drugs> drugsSave(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Drugs drugs = new Drugs();
		String id = request.getParameter("drugsId");
		drugs.setDrugsid(id);
		String name = request.getParameter("drugsName");
		drugs.setName(name);
		String creatTime = request.getParameter("inTime");
		drugs.setCreateTime(BaseUtils.toDate(creatTime));
		String manufacturer = request.getParameter("manufacturer");
		drugs.setManufacturer(manufacturer);
		Integer addNum = Integer.parseInt(request.getParameter("num"));
		drugs.setAddNum(addNum);
		Float price = Float.parseFloat(request.getParameter("price"));
		drugs.setPrice(price);
		String productionTime = request.getParameter("productionTime");
		drugs.setProduction_time(BaseUtils.toDate(productionTime));
		String supply = request.getParameter("supply");
		drugs.setSupply(supply);
		// �ж��Ƿ��п�
		String years = request.getParameter("year");
		String days = request.getParameter("day");
		String mouths = request.getParameter("mouth");
		drugs.setValidityYear(BaseUtils.toIntegers(years));
		drugs.setValidityDay(BaseUtils.toIntegers(days));
		drugs.setValidityMouth(BaseUtils.toIntegers(mouths));

		// ���ݱ����ڵ��� �� ���������׼ȷ�ĵ�����
		// ��������
		Integer addDays = drugs.getValidityYear() * 365 + drugs.getValidityMouth() * 30 + drugs.getValidityDay();
		// �õ�������
		Date newDate = BaseUtils.toAddDate(drugs.getProduction_time(),addDays);
		drugs.setVilidityTime(newDate);
		//ִ�����Ӳ���
		drugsService.DrugsSave(drugs);
		//������������,�жϿ�����Ƿ�������ҩƷ
		Integer state = drugsService.drugsStockQueryById(drugs.getDrugsid());
		if(state==1){
			//ִ�и���
			drugsService.drugsStockAdd(drugs);
		}else if(state==0){
			//ִ�в���
			drugsService.drugsStockSave(drugs);
		}
		return new JsonResult<Drugs>(drugs);
	}

	@RequestMapping("/drugsFind.do")
	@ResponseBody
	public JsonResult<List<Drugs>> drugsFind(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		DrugsCode drugsCode = new DrugsCode();
		String id = BaseUtils.toString(request.getParameter("drugsId"));
		String name = BaseUtils.toString(request.getParameter("drugsName"));
		if(!(id==null||"".equals(id))){
			drugsCode.setId(id);
		}
		if(!(name==null||"".equals(name))){
			drugsCode.setName(name);
		}
		drugsCode.setRkStart(BaseUtils.toDate(request.getParameter("rkStartTime")));
		drugsCode.setRkEnd(BaseUtils.toDate(request.getParameter("rkEndTime")));
		drugsCode.setBzStart(BaseUtils.toDate(request.getParameter("bzStartTime")));
		drugsCode.setBzEnd(BaseUtils.toDate(request.getParameter("bzEndTime")));
		System.out.println(drugsCode);
		List<Drugs> list = drugsService.drugsFind(drugsCode);
		return new JsonResult<List<Drugs>>(list);
	}
	
	/**
	 * ����ѯ
	 */
	@RequestMapping("/stockQuery.do")
	@ResponseBody
	public JsonResult<List<Stock>> stockQuery(HttpServletRequest request){
		String drugId = BaseUtils.toString(request.getParameter("drugsId"));
		String name = BaseUtils.toString(request.getParameter("drugsName"));
		DrugsCode drugsCode = new DrugsCode();
		drugsCode.setId(drugId);
		drugsCode.setName(name);
		System.out.println("drugsCode:"+drugsCode);
		List<Stock> list = drugsService.stockQuery(drugsCode);
		return new JsonResult<List<Stock>>(list);
	}
	/**
	 * ҩƷ����
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/grantAdd.do")
	@ResponseBody
	public JsonResult<Grant> grantAdd(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		String patientId = BaseUtils.toString(request.getParameter("patientId"));
		String patientName = BaseUtils.toString(request.getParameter("patientName"));
		String drugId = BaseUtils.toString(request.getParameter("drugsId"));
		String drugName = BaseUtils.toString(request.getParameter("drugsName"));
		Integer drugCount = BaseUtils.toInteger(request.getParameter("num"));
		Float drugPrice = BaseUtils.toFloat(request.getParameter("price"));
		String userId = BaseUtils.getUser(request).getId();
		String userName = BaseUtils.getUser(request).getName();
		Grant grant = new Grant(drugId,drugName,drugPrice,drugCount,patientId,patientName,userId,userName);
		System.out.println("grant:"+grant);
		//���뷢�ű�grantDrug
		drugsService.grantAdd(grant);
		//���ٿ�����
		drugsService.stockUpdate(grant);
		return new JsonResult<Grant>(grant);
	}
	/**
	 * ����ҩƷ��ѯ
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/grantQuery.do")
	@ResponseBody
	public JsonResult<List<Stock>> grantQuery(String patientId,HttpServletResponse response){
		List<Stock> list = drugsService.grantQuery(patientId);
		System.out.println("list:"+list);
		return new JsonResult<List<Stock>>(list);
	}
	
	 
 
	@RequestMapping("/DrugWithdrawal.do")
	@ResponseBody
	public void DrugWithdrawal(String patientId,String patientName,Integer count,String drugsId,String reason,HttpServletRequest request,HttpServletResponse response){
		WithdrawalDrug withdrawalDrug = new WithdrawalDrug();
		withdrawalDrug.setPatientId(patientId);
		withdrawalDrug.setPatientName(patientName);
		withdrawalDrug.setCount(count);
		withdrawalDrug.setReason(reason);
		withdrawalDrug.setDrugsId(drugsId);
		String userId = null;
		String userName = null;
		try {
			userId = BaseUtils.getUser(request).getId();
			userName = BaseUtils.getUser(request).getName();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		withdrawalDrug.setUserId(userId);
		withdrawalDrug.setUserName(userName);
		//������ҩ����
		drugsService.DrugWithdrawal(withdrawalDrug);
		//���ӿ��
		Grant grant = new Grant();
		grant.setDrugId(drugsId);
		grant.setDrugCount(-count);
		drugsService.stockUpdate(grant);
	}
}
