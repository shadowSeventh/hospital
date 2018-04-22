package cdu.edu.hospital.entity;

import java.io.Serializable;
import java.sql.Date;

public class Grant implements Serializable {

	private static final long serialVersionUID = 5656043524615353762L;
	/**
	 * ����
	 */
	private Integer id;
	/**
	 * ҩƷ���
	 */
	private String drugId;
	/**
	 * ҩƷ����
	 */
	private String drugName;
	/**
	 * ҩƷ�۸�
	 */
	private Float drugPrice;
	/**
	 * ����ҩƷ����
	 */
	private Integer drugCount;
	/**
	 * ���˱��
	 */
	private String patientId;
	/**
	 * ��������
	 */
	private String patientName;
	/**
	 * �����˱��
	 */
	private String grantUserId;
	/**
	 * ����������
	 */
	private String grantUserName;
	/**
	 * ����ʱ��
	 */
	private Date grantTime;

	public Grant() {

	}
	
	public Grant(String drugId, String drugName, Float drugPrice, Integer drugCount, String patientId,
			String patientName, String grantUserId, String grantUserName) {
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugPrice = drugPrice;
		this.drugCount = drugCount;
		this.patientId = patientId;
		this.patientName = patientName;
		this.grantUserId = grantUserId;
		this.grantUserName = grantUserName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public Float getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(Float drugPrice) {
		this.drugPrice = drugPrice;
	}

	public Integer getDrugCount() {
		return drugCount;
	}

	public void setDrugCount(Integer drugCount) {
		this.drugCount = drugCount;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getGrantUserId() {
		return grantUserId;
	}

	public void setGrantUserId(String grantUserId) {
		this.grantUserId = grantUserId;
	}

	public String getGrantUserName() {
		return grantUserName;
	}

	public void setGrantUserName(String grantUserName) {
		this.grantUserName = grantUserName;
	}

	public Date getGrantTime() {
		return grantTime;
	}

	public void setGrantTime(Date grantTime) {
		this.grantTime = grantTime;
	}

	@Override
	public String toString() {
		return "Grant [id=" + id + ", drugId=" + drugId + ", drugName=" + drugName + ", drugPrice=" + drugPrice
				+ ", drugCount=" + drugCount + ", patientId=" + patientId + ", patientName=" + patientName
				+ ", grantUserId=" + grantUserId + ", grantUserName=" + grantUserName + ", grantTime=" + grantTime
				+ "]";
	}

}
