package cdu.edu.hospital.entity;

import java.util.Date;

public class UserCode {
	/**
	 * �û�Ȩ��
	 */
	private Integer describe;
	/**
	 * �û�ID
	 */
	private String id;
	/**
	 * ��ʼʱ��
	 */
	private Date startTime;
	/**
	 * ����ʱ��
	 */
	private Date endTime;
	/**
	 * ��ʵ����
	 */
	private String name;

	public UserCode() {
	}

	public UserCode(Integer describe, String id, Date startTime, Date endTime, String name) {
		this.describe = describe;
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
	}

	public Integer getDescribe() {
		return describe;
	}

	public void setDescribe(Integer describe) {
		this.describe = describe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
