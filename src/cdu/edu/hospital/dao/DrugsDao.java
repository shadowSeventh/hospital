package cdu.edu.hospital.dao;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cdu.edu.hospital.entity.Drugs;
import cdu.edu.hospital.entity.DrugsCode;
import cdu.edu.hospital.entity.Grant;
import cdu.edu.hospital.entity.Stock;
import cdu.edu.hospital.entity.WithdrawalDrug;

public interface DrugsDao {
	/**
	 * ҩƷ�����
	 * @param drugs
	 */
	public void drugsSave(Drugs drugs);
	/**
	 * ��ѯҩƷ(����ID)
	 * @param id
	 * @return
	 */
	public Drugs drugsFindById(String id);
	/**
	 * ����ҩƷ
	 * @param id
	 */
	public void DrugsUpdate(Drugs drugs);
	/**
	 * ҩƷ��������ѯ
	 * @param drugsCode
	 * @return
	 */
	public List<Drugs> drugsFind(DrugsCode drugsCode);
	/**
	 * ����ҩƷ��Ų�ѯ�Ƿ��ڿ���к��и�ҩƷ
	 * @param drugId
	 * @return
	 */
	public Integer drugsStockQueryById(String drugId);
	 /**
	  * ���¿��
	  * @param drugs
	  */
	public void drugsStockAdd(Drugs drugs);
	/**
	 * ������
	 * @param drugs
	 */
	public void drugsStockSave(Drugs drugs);
	/**
	 * ����ѯ
	 */
	public List<Stock> stockQuery(DrugsCode drugsCode);
	/**
	 * ҩƷ����
	 * @param grant
	 */
	public void grantAdd(Grant grant);
	/**
	 * ���¿��
	 */
	public void stockUpdate(Grant grant);
	/**
	 * ҩƷ���Ų�ѯ
	 * @param patient
	 * @return
	 */
	public List<Stock> grantQuery(String patient);
	/**
	 * ��ҩ
	 * @param withdrawalDrug
	 */
	public void DrugWithdrawal(WithdrawalDrug withdrawalDrug);
}
