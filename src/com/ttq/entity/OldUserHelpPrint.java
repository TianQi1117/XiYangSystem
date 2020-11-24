package com.ttq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OldUserHelpPrint {
	private Integer oldId;
	private String oldName;

	@Override
	public String toString() {
		return oldId + "\t" + oldName;
	}

}
