 package cdu.edu.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.CommonDao;
import cdu.edu.hospital.entity.Common;
import cdu.edu.hospital.entity.Parameter;

@Service("commonService")
public class CommonServiceImpl implements CommonService{
	
	@Autowired //ע������ID�� commonDao
	private  CommonDao commonDao;
	
	/**
	 * ��ѯְ���б�
	 */
	@Override
	public List<Common> titleQuery(String name) {
		return commonDao.titleQuery(name);
	}
	/**
	 * ������ѯ
	 */
	@Override
	public List<Parameter> parameterQuery() {
		return commonDao.parameterQuery();
	}
	/**
	 * �����б��ѯ
	 */
	@Override
	public List<Parameter> parameterCodeQuery(String code) {
		return commonDao.parameterCodeQuery(code);
	}
	/**
	 * ��������
	 */
	@Override
	public void parameterCodeInsert(Parameter parameter) {
		commonDao.parameterCodeInsert(parameter);
	}
	/**
	 * ��������
	 */
	@Override
	public void parameterCodeUpdate(Parameter parameter) {
		 commonDao.parameterCodeUpdate(parameter);
		
	}
	/**
	 * ɾ��������Ϣ
	 */
	@Override
	public void parameterCodeDelete(Integer id) {
		commonDao.parameterCodeDelete(id);
	}
	/**
	 * �������Ͳ�ѯ
	 */
	@Override
	public List<Parameter> wardTypeQuery() {
		return commonDao.wardTypeQuery();
	}
	/**
	 * �����б��ѯ
	 */
	@Override
	public List<Parameter> nationQuery() {
		return commonDao.nationQuery();
	}

}
