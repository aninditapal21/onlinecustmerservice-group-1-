package com.capgemin.OnlineCustomerServiceCenter.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="issue_table")
public class Issue {
	@Id
	private String issueId;
	//@NotBlank(message="issue type should not be blank")
	private String issueType;
	private String description;
	//@NotNull(message="issue status should not be null")
	private String issueStatus;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="call_Id")
	private Call call;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="solution_Id")
	private Solution solution;
	
	
	
	public Solution getSolution() {
		return solution;
	}
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	public Call getCall() {
		return call;
	}
	public void setCall(Call call) {
		this.call = call;
	}
	public String getIssueId() {
		return issueId;
	}
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	
	
}
