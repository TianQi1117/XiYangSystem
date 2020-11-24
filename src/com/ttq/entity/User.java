package com.ttq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private Integer id;
	private String name;
	private String userName;
	private String password;
	private String sex;
	private Integer age;
	private Integer phone;

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + userName + "\t" + password + "\t" + sex + "\t" + age + "\t" + phone;
	}

}
