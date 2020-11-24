package com.ttq.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Old {
	private Integer oldId;
	private String oldName;
	private Date addTime;
	private String oldSex;
	private Integer oldAge;
	private String address;
	private String contact;
	private Integer userId;

	public Old(Integer oldId, String oldName, String oldSex, Integer oldAge, String address, String contact,
			Integer userId) {
		super();
		this.oldId = oldId;
		this.oldName = oldName;
		this.addTime = new Date();
		this.oldSex = oldSex;
		this.oldAge = oldAge;
		this.address = address;
		this.contact = contact;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return oldId + "\t" + oldName + "\t" + addTime + "\t" + oldSex + "\t" + oldAge + "\t" + address + "\t" + contact
				+ "\t" + userId;
	}

}
