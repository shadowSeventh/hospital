package cdu.edu.hospital.service;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cdu.edu.hospital.entity.Drugs;
import cdu.edu.hospital.entity.DrugsCode;
import cdu.edu.hospital.entity.Grant;
import cdu.edu.hospital.entity.Stock;
import cdu.edu.hospital.entity.WithdrawalDrug;

/**
 * ҩƷ�ķ���ӿ�
 * @author ��
 *
 */
public interface DrugsService {
	/**
	 * ҩƷ�����
	 * @param drugs
	 */
	public void DrugsSave(Drugs drugs);
	
	/**
	 * ��ѯҩƷ
	 */
	public Drugs drugsFindById(String id);
	/**
	 * ҩƷ�ĸ���
	 */
	public void DrugsUpdate(Drugs drugs);
	/**
	 * ҩƷ��������ѯ
	 */
	public List<Drugs> drugsFind(DrugsCode drugsCode);
	/**
	 * ����ҩƷ��Ų�ѯ������Ƿ��и���ҩƷ
	 */
	public Integer drugsStockQueryById(String drugId);
	/**
	 * ���¿��
	 */
	public void drugsStockAdd(Drugs drugs);
	/**
	 * ������
	 */
	public void drugsStockSave(Drugs drugs);
	/**
	 * ����ѯ
	 */
	public List<Stock> stockQuery(DrugsCode drugsCode);
	/**
	 * ҩƷ����
	 */
	public void grantAdd(Grant grant);
	/**
	 * ���¿��
	 */
	public void stockUpdate(Grant grant);
	/**
	 * ҩƷ���Ų�ѯ
	 */
	public List<Stock> grantQuery(String patientId);
	/**
	 * ��ҩ
	 * @param withdrawalDrug
	 */
	public void DrugWithdrawal(WithdrawalDrug withdrawalDrug);
}
