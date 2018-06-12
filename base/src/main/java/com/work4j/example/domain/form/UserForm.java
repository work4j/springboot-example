package com.work4j.example.domain.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * UserForm
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String id = UUID.randomUUID().toString().replaceAll("-", "");
	private String username; // username
	private String password; // password
	private String nickname; // nickname
	private String email; // email
	private String cellphone; // cellphone
	private Date createDataTime = new Date(); // createDataTime
	private String createDataUsername; // createDataUsername
	private Date updateDataTime = new Date(); // updateDataTime
	private String updateDataUsername; // updateDataUsername
	private Integer enabled = 1; // enabled
}