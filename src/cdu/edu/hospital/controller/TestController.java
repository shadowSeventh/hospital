package cdu.edu.hospital.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("test")
	public void test001(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("���Գɹ���");
		request.setAttribute("test", "���Գɹ�");
		response.sendRedirect("index.jsp");
	}
	
	
}
