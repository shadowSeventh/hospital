package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;
import cdu.edu.hospital.entity.Common;
import cdu.edu.hospital.entity.Parameter;

/**
 * ������������ӿ�
 * @author ��
 *
 */
public interface CommonService {
	/**
	 * ְ���б�Ĳ�ѯ
	 * @return
	 */
	public List<Common> titleQuery(String name);
	/**
	 * ������ѯ
	 * @return
	 */
	public List<Parameter> parameterQuery();
	/**
	 * �����б��ѯ
	 * @param code
	 * @return
	 */
	public List<Parameter>parameterCodeQuery(String code);
	/**
	 * ���������Ϣ
	 * @param parameter
	 */
	public void parameterCodeInsert(Parameter parameter);
	/**
	 * ���²�����Ϣ
	 * @param parameter
	 */
	public void parameterCodeUpdate(Parameter parameter);  
	/**
	 * ɾ��������Ϣ
	 * @param id
	 */
	public void parameterCodeDelete(Integer id);
	/**
	 * �������Ͳ�ѯ
	 * @return
	 */
	public List<Parameter> wardTypeQuery();
	 /**
	  * �����б��ѯ
	  * @return
	  */
	public List<Parameter> nationQuery();
}
