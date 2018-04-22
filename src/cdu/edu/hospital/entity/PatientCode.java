package cdu.edu.hospital.entity;

import java.sql.Date;

public class PatientCode {

	private String patientId; 		//סԺ��
	private Integer bedNo;    		//��λ��
	private Integer departmentNo;	//���Һ�
	private Integer wardNo;			//������
	private Date start;				//��Ժ��ʼʱ��
	private Date end;				//��Ժ����ʱ��
	private String name;			//����
	private Date outStart; 			//��Ժ��ʼʱ��
	private Date outEnd;			//��Ժ����ʱ��
	private Integer outStatus;		//�Ƿ��Ժ
	private Integer jsStatus;		//�Ƿ����

	public PatientCode() {
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Integer getBedNo() {
		return bedNo;
	}

	public void setBedNo(Integer bedNo) {
		this.bedNo = bedNo;
	}

	public Integer getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}

	public Integer getWardNo() {
		return wardNo;
	}

	public void setWardNo(Integer wardNo) {
		this.wardNo = wardNo;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOutStart() {
		return outStart;
	}

	public void setOutStart(Date outStart) {
		this.outStart = outStart;
	}

	public Date getOutEnd() {
		return outEnd;
	}

	public void setOutEnd(Date outEnd) {
		this.outEnd = outEnd;
	}

	public Integer getOutStatus() {
		return outStatus;
	}

	public void setOutStatus(Integer outStatus) {
		this.outStatus = outStatus;
	}

	public Integer getJsStatus() {
		return jsStatus;
	}

	public void setJsStatus(Integer jsStatus) {
		this.jsStatus = jsStatus;
	}

	@Override
	public String toString() {
		return "PatientCode [patientId=" + patientId + ", bedNo=" + bedNo
				+ ", departmentNo=" + departmentNo + ", wardNo=" + wardNo
				+ ", start=" + start + ", end=" + end + ", name=" + name
				+ ", outStart=" + outStart + ", outEnd=" + outEnd
				+ ", outStatus=" + outStatus + ", jsStatus=" + jsStatus + "]";
	}
}
