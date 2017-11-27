package org.iley.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_user")
public class SysUser implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	private String cnname;
	private String username;
	@JsonIgnore
	private String password;
	private String email;
	@JsonIgnore
	private String telephone;
	private String mobilePhone;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "t_user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<SysRole> roles;
	private String address;
	private String codes;
	@Temporal(TemporalType.DATE)
	private Date firstDay;
	@Temporal(TemporalType.DATE)
	private Date birstDay;
	@Temporal(TemporalType.DATE)
	private Date lastDay;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = OfficeGroup.class)
	private OfficeGroup officeGroup;

	private String comments;
	@Version
	private int version;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public Date getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}

	public Date getBirstDay() {
		return birstDay;
	}

	public void setBirstDay(Date birstDay) {
		this.birstDay = birstDay;
	}

	public Date getLastDay() {
		return lastDay;
	}

	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}

	public OfficeGroup getOfficeGroup() {
		return officeGroup;
	}

	public void setOfficeGroup(OfficeGroup officeGroup) {
		this.officeGroup = officeGroup;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SysRole> roles = this.getRoles();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Iterator<SysRole> iterator = roles.iterator(); iterator.hasNext();) {
			SysRole role = (SysRole) iterator.next();
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public void addRole(SysRole role) {
		if (this.roles != null)
			this.roles.add(role);
		else {
			this.roles = new HashSet<SysRole>();
			this.roles.add(role);
		}

	}

	public void addRole(String rolename) {
		if (this.roles != null)
			this.roles.add(new SysRole(rolename));
		else {
			this.roles = new HashSet<SysRole>();
			this.roles.add(new SysRole(rolename));
		}
	}

}