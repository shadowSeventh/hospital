package cdu.edu.hospital.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Patient implements Serializable {

	private static final long serialVersionUID = -6183250714467316067L;

	private Integer id; // ����
	private String patientId; // סԺ��
	private String name; // ����
	private Integer gender; // �Ա�
	private Integer nation; // ����
	private Date birth; // ����
	private String cerificateNo;// ֤������
	private String workUnit; // ������λ
	private Integer maritalStatus;// ����״��
	private Integer doctorId; // ����ҽ�����
	private Timestamp admissionTime;// ��Ժʱ��
	private String homeAddress; // ��ͥסַ
	private String homePhone; // ��ͥ�绰
	private String contactsPhone; // ��ϵ�˵绰
	private String contacts; // ��ϵ��
	private Integer admissionStatus;// ��Ժ״̬
	private Integer roomNo; // ������
	private Integer roomType; // ��������
	private Integer bedNo; // ��λ��
	private Integer state; // ״̬
	private Integer department; // ���Һ�
	private Integer settlementState;// �Ƿ����
	private Integer leaveState; // �Ƿ��Ժ
	private Timestamp leaveTime; // ��Ժʱ��

	public Patient() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getCerificateNo() {
		return cerificateNo;
	}

	public void setCerificateNo(String cerificateNo) {
		this.cerificateNo = cerificateNo;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Timestamp getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(Timestamp admissionTime) {
		this.admissionTime = admissionTime;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public Integer getBedNo() {
		return bedNo;
	}

	public void setBedNo(Integer bedNo) {
		this.bedNo = bedNo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(Integer admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public Integer getRoomType() {
		return roomType;
	}

	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}

	public Integer getSettlementState() {
		return settlementState;
	}

	public void setSettlementState(Integer settlementState) {
		this.settlementState = settlementState;
	}

	public Integer getLeaveState() {
		return leaveState;
	}

	public void setLeaveState(Integer leaveState) {
		this.leaveState = leaveState;
	}

	public Timestamp getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientId=" + patientId + ", name="
				+ name + ", gender=" + gender + ", nation=" + nation
				+ ", birth=" + birth + ", cerificateNo=" + cerificateNo
				+ ", workUnit=" + workUnit + ", maritalStatus=" + maritalStatus
				+ ", doctorId=" + doctorId + ", admissionTime=" + admissionTime
				+ ", homeAddress=" + homeAddress + ", homePhone=" + homePhone
				+ ", contactsPhone=" + contactsPhone + ", contacts=" + contacts
				+ ", admissionStatus=" + admissionStatus + ", roomNo=" + roomNo
				+ ", roomType=" + roomType + ", bedNo=" + bedNo + ", state="
				+ state + ", department=" + department + ", settlementState="
				+ settlementState + ", leaveState=" + leaveState
				+ ", leaveTime=" + leaveTime + "]";
	}

}
