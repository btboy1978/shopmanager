package org.iley.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "t_shopsite")
public class ShopSite implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	@NotEmpty(message = "店柜中文简称不能为空")
	private String cname;// 中文名
	@Column
	@NotEmpty(message = "店柜代码简称不能为空")
	private String code;// 代码
	@Column
	private String cncode;//拼音简码
	@Column
	private String address;// 联系地址
	@Column
	private String telephone;// 联系电话
	@Column
	private String faxphone;// 传真号码
	@Column
	private String header;// 负责人
	@Column
	private String comments;
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private SysUser sysUser;
	@Version
	private int version;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFaxphone() {
		return faxphone;
	}
	public void setFaxphone(String faxphone) {
		this.faxphone = faxphone;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public void setCncode(String cncode) {
		this.cncode = cncode;
	}
	public String getCncode() {
		return cncode;
	}

}
