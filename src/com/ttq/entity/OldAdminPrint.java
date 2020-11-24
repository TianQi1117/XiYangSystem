package com.ttq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OldAdminPrint {
	private String oldName;
	private Integer oldAge;
	private String oldSex;
	private String address;
	private String contact;

	@Override
	public String toString() {
		return oldName + "\t" + oldAge + "\t" + oldSex + "\t" + address + "\t" + contact;
	}

}
