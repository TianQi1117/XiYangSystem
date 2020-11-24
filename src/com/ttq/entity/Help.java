package com.ttq.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Help {
	private Integer helpId;
	private Integer oldId;
	private Integer userId;
	private Date addTime;
	private String helpDescription;

	@Override
	public String toString() {
		return helpId + "\t" + oldId + "\t" + userId + "\t" + addTime + "\t" + helpDescription;
	}

	public Help(Integer helpId, Integer oldId, Integer userId, String helpDescription) {
		super();
		this.helpId = helpId;
		this.oldId = oldId;
		this.userId = userId;
		this.addTime = new Date();
		this.helpDescription = helpDescription;
	}

}
