package cdu.edu.hospital.controller;

import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.service.BedService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/bed")
public class AdviceController {
	@Autowired
	BedService bedService;
	
	@RequestMapping("/advice")
	@ResponseBody
	public JsonResult<List<Bed>> bedQuery(HttpServletRequest request,HttpServletResponse response){
		Bed bed = new Bed();
		bed.setWardNo(BaseUtils.toInteger(request.getParameter("wardNo")));
		bed.setState(0);
		List<Bed> list = bedService.bedQuery(bed);
		return new JsonResult<List<Bed>>(list);
	}
}
