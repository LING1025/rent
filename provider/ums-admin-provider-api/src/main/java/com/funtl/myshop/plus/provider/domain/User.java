package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[User]")
public class User implements Serializable {

    @Id
    @Column(name = "userId")
    @GeneratedValue(generator = "JDBC")
    private Integer userId;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "balance")
    private Object balance;

    @Column(name = "isAdmin")
    private Integer isAdmin;

    @Column(name = "faceUrl")
    private String faceUrl;

    @Column(name = "status")
    private Byte status;

    private static final long serialVersionUID = 1L;
}
