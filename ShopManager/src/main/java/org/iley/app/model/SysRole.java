package org.iley.app.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_roles")
public class SysRole implements Comparable<SysRole> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "t_user_role", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", referencedColumnName = "id") })
	private Set<SysUser> users;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "t_role_permission", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "permission_id", referencedColumnName = "id") })
	private Set<SysPermission> permissions;

	public SysRole() {
		super();
	}

	public SysRole(String name) {
		super();
		this.name = name;
	}

	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}

	public Set<SysUser> getUsers() {
		return users;
	}

	public void setPermissions(Set<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<SysPermission> getPermissions() {
		return permissions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(SysRole o) {
		if (id == o.getId()) {
			return 0;
		} else if (id > o.getId()) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof SysRole) {
			if (this.id == ((SysRole) obj).getId()) {
				return true;
			}
		}
		return false;
	}
}