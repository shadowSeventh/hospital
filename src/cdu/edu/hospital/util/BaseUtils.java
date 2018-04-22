package cdu.edu.hospital.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cdu.edu.hospital.entity.User;

public class BaseUtils {
	/**
	 * ���ַ���ת��Ϊdate����
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String time) throws ParseException{
		if (!(time == null || "".equals(time))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date worktime = (java.util.Date) sdf.parse(time);
			java.util.Date utilDate=worktime;
			Date sqlDate = new Date(utilDate.getTime());
			return sqlDate;
		}
		return null;
	}
	/**
	 * �ַ���ת��Ϊdate����YYYY-MM-dd HH:mm:ss
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp toDates(String time) throws ParseException{
		java.util.Date worktime = null;
		if (!(time == null || "".equals(time))) {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
			sdf.setLenient(false);   
			worktime =  sdf.parse(time);
			return new Timestamp(worktime.getTime());
		}
		return null;
	}
	
	
	/**
	 * ���ַ���ת��ΪInteger,Ϊ��ʱ����null
	 * @param string
	 * @return
	 */
	public static Integer toInteger(String string) {
		if (!(string == null || "".equals(string))) {
			Integer str = Integer.parseInt(string);
			return str;
		}
		return null;
	}
	
	/**
	 * ���ַ���ת��ΪInteger,Ϊ��ʱ����0
	 * @param string
	 * @return
	 */
	public static Integer toIntegers(String string) {
		if (!(string == null || "".equals(string))) {
			Integer str = Integer.parseInt(string);
			return str;
		}
		return 0;
	}
	
	/**
	 * �ַ���ת������
	 * @param string
	 * @return
	 */
	public static Float toFloat(String string) {
		if (!(string == null || "".equals(string))) {
			Float str =  Float.parseFloat(string);
			return str;
		}
		return 0.00f;
	}
	
	/**
	 * Ϊһ��date���������������
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date toAddDate(Date date,Integer days){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, +days);
		// calendar��timeת��java.util.Date��ʽ����
		java.util.Date utilDate = (java.util.Date) calendar.getTime();
		utilDate = (java.util.Date) calendar.getTime();
		// java.util.Date����ת����ת��java.sql.Date��ʽ
		Date newDate = new Date(utilDate.getTime());
		return newDate;
	}
	
	/**
	 * ���ַ������д���
	 * @param str
	 * @return
	 */
	public static String toString(String str){
		if (!(str == null || "".equals(str))) {
			return str.trim();
		}
		return null;
	}
	/**
	 * �õ���ǰ�û���Ϣ
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static User getUser(HttpServletRequest request) throws UnsupportedEncodingException{
		//����Cookie�е��û���Ϣ
		User user = new User();
		Cookie cookie[] = request.getCookies();
		if(cookie!=null){
			for(Cookie cookie2:cookie){
				if(cookie2.getName().equals("user")){
					String value = cookie2.getValue(); 
					value = URLDecoder.decode(value, "utf-8");
					String[] userInfo = value.split(",");
					user.setId(userInfo[0]);
					user.setName(userInfo[1]);
				}
			}
		}
		return user;
	}
}
