package cdu.edu.hospital.entity;

import java.io.Serializable;

public class Common implements Serializable {
	private static final long serialVersionUID = -2803427383784745036L;
	// �����б��value
	private Integer value;
	// �����б��name
	private String name;

	public Common() {
	}

	public Common(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Common [value=" + value + ", name=" + name + "]";
	}

}
