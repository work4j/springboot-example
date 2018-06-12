package com.work4j.example.domain.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * UserQuery
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // id
    private String username; // username
    private String password; // password
    private String nickname; // nickname
    private String email; // email
    private String cellphone; // cellphone
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime; // updateDataTime
    private String updateDataUsername; // updateDataUsername
    private Integer enabled; // enabled

    private Integer page = 1;
    private Integer limit = 20;
    private String simpleQueryParam;
}