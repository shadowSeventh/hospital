package cdu.edu.hospital.entity;

import java.util.Date;

public class DoctorCode {
	private Integer id;
	private String name;
	private Date startTime;
	private Date endTime;
	private Integer title;
	private Integer department;
	private Integer state;// �Ƿ���ְ

	public DoctorCode() {
	}

	public DoctorCode(Integer id, String name, Date startTime, Date endTime,
			Integer title, Integer department, Integer state) {

		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.department = department;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getTitle() {
		return title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
