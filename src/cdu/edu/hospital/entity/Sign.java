package cdu.edu.hospital.entity;

import java.io.Serializable;
/**
 * ����ʵ����
 * @author ��
 *
 */
import java.sql.Date;
import java.sql.Timestamp;

public class Sign implements Serializable {

	private static final long serialVersionUID = 1435954458719558895L;

	/**
	 * �������ݱ��
	 */
	private Integer signId;
	/**
	 * סԺ��
	 */
	private String patientId;
	/**
	 * �Ǽ��û�ID(��Ϊ�����û�)
	 */
	private String userId;
	/**
	 * �Ǽ��û�����
	 */
	private String userName;
	/**
	 * ����
	 */
	private Float temperature;
	/**
	 * Ѫѹ
	 */
	private Float bloodPressure;
	/**
	 * ����
	 */
	private Integer pulse;
	/**
	 * ����
	 */
	private Integer breathing;
	/**
	 * Ѫ��
	 */
	private Float bloodSugar;
	/**
	 * ����ʱ��
	 */
	private Timestamp measureTime;
	/**
	 * ����
	 */
	private Float vein;
	/**
	 * �Ǽ�ʱ��
	 */
	private Date createTime;
	/**
	 * ��ע
	 */
	private String remarks;

	public Sign() {
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String reamarks) {
		this.remarks = reamarks;
	}

	public Float getVein() {
		return vein;
	}

	public void setVein(Float vein) {
		this.vein = vein;
	}

	public Integer getSignId() {
		return signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(Float bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	public Integer getBreathing() {
		return breathing;
	}

	public void setBreathing(Integer breathing) {
		this.breathing = breathing;
	}

	public Float getBloodSugar() {
		return bloodSugar;
	}

	public void setBloodSugar(Float bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public Timestamp getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(Timestamp measureTime) {
		this.measureTime = measureTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Sign [signId=" + signId + ", patientId=" + patientId + ", userId=" + userId + ", userName=" + userName
				+ ", temperature=" + temperature + ", bloodPressure=" + bloodPressure + ", pulse=" + pulse
				+ ", breathing=" + breathing + ", bloodSugar=" + bloodSugar + ", measureTime=" + measureTime + ", vein="
				+ vein + ", createTime=" + createTime + ", remarks=" + remarks + "]";
	}

}
