package cdu.edu.hospital.dao;

import java.util.List;

import cdu.edu.hospital.entity.Common;
import cdu.edu.hospital.entity.Parameter;

/**
 * ������������
 * @author ��
 *
 */
public interface CommonDao {
	/**
	 * ְ���б��ѯ
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
	public List<Parameter> parameterCodeQuery(String code);
	/**
	 * ��������
	 * @param parameter
	 */
	public void parameterCodeInsert(Parameter parameter);
	/**
	 * ��������
	 * @param parameter
	 */
	public void parameterCodeUpdate(Parameter parameter);
	/**
	 * ����ɾ��
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
