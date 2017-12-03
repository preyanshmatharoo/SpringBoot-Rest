package com.dbd.hackathon.model;

import java.util.List;

public class Team {

	private String managerName;
	private List<Members> memberList;

	public Team(String managerName, List<Members> memberList) {
		this.managerName = managerName;
		this.memberList = memberList;
	}

	public String getManagerName() {
		return managerName;
	}

	public List<Members> getMemberList() {
		return memberList;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public void setMemberList(List<Members> memberList) {
		this.memberList = memberList;
	}
}
