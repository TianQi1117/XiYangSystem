package com.ttq.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HelpPrint {
	private String oldName;
	private String helpDescription;
	private Date addTime;

	@Override
	public String toString() {
		return oldName + "\t" + helpDescription + "\t" + addTime;
	}

}
