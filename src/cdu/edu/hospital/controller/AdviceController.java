package cdu.edu.hospital.controller;

import cdu.edu.hospital.entity.Advice;
import cdu.edu.hospital.entity.PatientCode;
import cdu.edu.hospital.service.AdviceService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/advice")
public class AdviceController {
    @Autowired
    AdviceService adviceService;

    @RequestMapping("/adviceSave.do")
    @ResponseBody
    public JsonResult<Advice> adviceSave(String patientId, String hospitalStays, String result, String adviceName,
                                         String frequency, String spec, String dosage, String giveType,
                                         String startTime, String endTime, String remarks,
                                         HttpServletRequest request) throws ParseException {
        Advice advice = new Advice();
        advice.setPatientId(BaseUtils.toString(patientId));
        advice.setHospitalStays(BaseUtils.toInteger(hospitalStays));
        advice.setResult(BaseUtils.toString(result));
        advice.setAdviceName(BaseUtils.toString(adviceName));
        advice.setFrequency(BaseUtils.toString(frequency));
        advice.setSpec(BaseUtils.toString(spec));
        advice.setDosage(BaseUtils.toString(dosage));
        advice.setGiveType(BaseUtils.toString(giveType));
        advice.setStartTime(BaseUtils.toDate(startTime));
        advice.setEndTime(BaseUtils.toDate(endTime));
        advice.setRemarks(BaseUtils.toString(remarks));
        adviceService.adviceSave(advice);
        return new JsonResult<>(advice);
    }


    @RequestMapping("/adviceQuery.do")
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
        List<Map<String, Object>> list =  adviceService.adviceQuery(patientCode);
        System.out.println(list);
        return new JsonResult<>(list);
    }
}
