package cdu.edu.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.DrugsDao;
import cdu.edu.hospital.entity.Drugs;
import cdu.edu.hospital.entity.DrugsCode;
import cdu.edu.hospital.entity.Grant;
import cdu.edu.hospital.entity.Stock;
import cdu.edu.hospital.entity.WithdrawalDrug;

@Service("drugsService")
public class DrugsServiceImpl implements DrugsService{
	@Autowired
	private DrugsDao drugsDao;

	/**
	 * ҩƷ�����
	 */
	@Override
	public void DrugsSave(Drugs drugs) {
		 drugsDao.drugsSave(drugs);
	}
	/**
	 * ��ѯҩƷ
	 */
	@Override
	public Drugs drugsFindById(String id) {
		return drugsDao.drugsFindById(id);
	}
	/**
	 * ҩƷ�ĸ���
	 */
	@Override
	public void DrugsUpdate(Drugs drugs) {
		drugsDao.DrugsUpdate(drugs);
		
	}
	/**
	 * ҩƷ�Ĳ�ѯ
	 */
	@Override
	public List<Drugs> drugsFind(DrugsCode drugsCode) {
		 return drugsDao.drugsFind(drugsCode);
	}
	/**
	 * ����ҩƷ��Ų�ѯ�Ƿ��ڿ���к��и�����Ʒ
	 */
	@Override
	public Integer drugsStockQueryById(String drugId) {
		return drugsDao.drugsStockQueryById(drugId);
	}
	/**
	 * ���¿��
	 */
	@Override
	public void drugsStockAdd(Drugs drugs) {
		drugsDao.drugsStockAdd(drugs);
	}
	/**
	 * ������
	 */
	@Override
	public void drugsStockSave(Drugs drugs) {
		drugsDao.drugsStockSave(drugs);
		
	}
	/**
	 * ����ѯ
	 */
	@Override
	public List<Stock> stockQuery(DrugsCode drugsCode) {
		return drugsDao.stockQuery(drugsCode);
	}
	/**
	 * ҩƷ����
	 */
	@Override
	public void grantAdd(Grant grant) {
		drugsDao.grantAdd(grant);
		
	}
	/**
	 * ���¿��
	 */
	@Override
	public void stockUpdate(Grant grant) {
		drugsDao.stockUpdate(grant);
		
	}
	/**
	 * ҩƷ���Ų�ѯ
	 */
	@Override
	public List<Stock> grantQuery(String patientId) {
		return drugsDao.grantQuery(patientId);
	}
	/**
	 * ��ҩ
	 */
	@Override
	public void DrugWithdrawal(WithdrawalDrug withdrawalDrug) {
		drugsDao.DrugWithdrawal(withdrawalDrug);
	}
}
