package com.perfm.services.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="employeedetails")
@TypeAlias("employeedetail")
public class EmployeeDetail extends AbstractDocument{
	
	
	@Indexed(unique=true)
	private String employeeId;
	
	private String name;
	private String jobTitle;
	private String goalPeriod;
	private Date joiningDate = new Date();
	private Date reviewDate = new Date();
	private String role;
	private String goalType;
	
	@DBRef
	@Field("projectgoals")
	private List<ProjectGoal> projectGoal = new ArrayList<ProjectGoal>();
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getGoalPeriod() {
		return goalPeriod;
	}
	public void setGoalPeriod(String goalPeriod) {
		this.goalPeriod = goalPeriod;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGoalType() {
		return goalType;
	}
	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}
	
	public List<ProjectGoal> getProjectGoal() {
		return projectGoal;
	}
	public void setProjectGoal(List<ProjectGoal> projectGoal) {
		this.projectGoal = projectGoal;
	}
	public EmployeeDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDetail(String employeeId, String name, String jobTitle, String goalPeriod, Date joiningDate,
			Date reviewDate, String role, String goalType) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.jobTitle = jobTitle;
		this.goalPeriod = goalPeriod;
		this.joiningDate = joiningDate;
		this.reviewDate = reviewDate;
		this.role = role;
		this.goalType = goalType;
	}
	
	
	@PersistenceConstructor
	public EmployeeDetail(final String employeeId,final  String name,
			final  String jobTitle, 
			final String goalPeriod,final Date joiningDate,
			final Date reviewDate,final String role,
			final String goalType,final List<ProjectGoal> projectGoal) {
		this.employeeId = employeeId;
		this.name = name;
		this.jobTitle = jobTitle;
		this.goalPeriod = goalPeriod;
		this.joiningDate = joiningDate;
		this.reviewDate = reviewDate;
		this.role = role;
		this.goalType = goalType;
		this.projectGoal = projectGoal;
	}
	
	
	
	
	

}
