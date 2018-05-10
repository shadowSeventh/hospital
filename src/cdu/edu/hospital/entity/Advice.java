package cdu.edu.hospital.entity;

import java.io.Serializable;
import java.sql.Date;

public class Advice implements Serializable {

	private static final long serialVersionUID = 579399412262700813L;

	private Integer id;

	// 住院编号
	private Integer patientId;
	// 姓名
	private String patientName;
	// 床位号
	private Integer bedNo;
	//住院天数
	private Integer hospitalStays;

	//诊断
	private String result;

	//医嘱名称
	private String adviceName;

	//医嘱执行频率
	private String frequency;

	//药品规格
	private String spec;

	//药品一次用量
	private String dosage;

	//给药方式
	private String giveType;

	//开始时间
	private Date startTime;

	//结束时间
	private Date endTime;

	//备注
	private String remarks;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getBedNo() {
		return bedNo;
	}

	public void setBedNo(Integer bedNo) {
		this.bedNo = bedNo;
	}

	public Integer getHospitalStays() {
		return hospitalStays;
	}

	public void setHospitalStays(Integer hospitalStays) {
		this.hospitalStays = hospitalStays;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAdviceName() {
		return adviceName;
	}

	public void setAdviceName(String adviceName) {
		this.adviceName = adviceName;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getGiveType() {
		return giveType;
	}

	public void setGiveType(String giveType) {
		this.giveType = giveType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
