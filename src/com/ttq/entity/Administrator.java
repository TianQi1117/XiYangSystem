package com.ttq.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Administrator {
	private Integer id;
	private String adminName;
	private String password;
	private Date addTime;

	public Administrator(Integer id, String adminName, String password) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.password = password;
		this.addTime = new Date();
	}

	@Override
	public String toString() {
		return id + "\t" + adminName + "\t" + password + "\t" + addTime;
	}

}
