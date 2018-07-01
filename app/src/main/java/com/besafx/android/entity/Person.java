package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String nickname;

    private String shortName;

    private String address;

    private String mobile;

    private String nationality;

    private String identityNumber;

    private String options;

    private String photo;

    private String qualification;

    private String email;

    private String password;

    private Boolean technicalSupport;

    private Boolean enabled;

    private Boolean tokenExpired;

    private Boolean active;

    private String hiddenPassword;

    private Date lastLoginDate;

    private String lastLoginLocation;

    private String ipAddress;

    private Double mainSalary;

    private Double houseAllowance;

    private Double transportAllowance;

    private Team team;

    private List<Company> companies = new ArrayList<>();

    private List<Region> regions = new ArrayList<>();

    private List<Branch> branches = new ArrayList<>();

    private List<Department> departments = new ArrayList<>();

    private List<Employee> employees = new ArrayList<>();

    private List<Ticket> tickets = new ArrayList<>();

    private List<Notice> notices = new ArrayList<>();

    private List<Vacation> vacations = new ArrayList<>();

    private List<Deduction> deductions = new ArrayList<>();

    private List<Salary> salaries = new ArrayList<>();

    private Date lastUpdate;
}
