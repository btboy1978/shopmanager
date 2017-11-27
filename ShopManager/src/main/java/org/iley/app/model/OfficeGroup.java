package org.iley.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "t_officegroup")
public class OfficeGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "部门名称不能为空！")
	private String groupname;
	private String comments;
	 @OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER,mappedBy="officeGroup")
	private Set<SysUser> sysUsers;
	 
	 public OfficeGroup() {
			super();
		
		}

	public OfficeGroup(String groupname) {
		super();
		this.groupname = groupname;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

	public Set<SysUser> getSysUsers() {
		return sysUsers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
