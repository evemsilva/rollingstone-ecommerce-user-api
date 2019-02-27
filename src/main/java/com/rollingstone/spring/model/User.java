package com.rollingstone.spring.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rollingstone_user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;

    @Column(name = "USER_NAME", nullable = false) private String userName;

    @Column(name = "FIRST_NAME", nullable = false) private String firstName;

    @Column(name = "LAST_NAME", nullable = false) private String lastName;

    private String sex;

    @Column(name = "MEMBER_TYPE", nullable = false) private String memberType;

    @Column(name = "ACCOUNT_NUMBER", nullable = false) private String accountNumber;

    @Temporal(TemporalType.DATE) @Column(name = "REGISTRATION_DATE", nullable = false, unique = false, length = 10) private Date
		    registrationDate;

    public User() {
    }

    public User(String userName, String firstName, String lastName, String sex, String memberType, String accountNumber, Date registrationDate) {
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.sex = sex;
	this.memberType = memberType;
	this.accountNumber = accountNumber;
	this.registrationDate = registrationDate;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getSex() {
	return sex;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    public String getMemberType() {
	return memberType;
    }

    public void setMemberType(String memberType) {
	this.memberType = memberType;
    }

    public String getAccountNumber() {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
    }

    public Date getRegistrationDate() {
	return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
	this.registrationDate = registrationDate;
    }
}
