package it.ads.activitiesmanager.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "User", catalog = "amdb", uniqueConstraints = @UniqueConstraint(columnNames = "U_LOGIN"))
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private Role role;
	private String ULogin;
	private String UPwd;
	private String UName;
	private String UAddress;
	private Date UBirthday;
	private String UCity;
	private Set<Activity> activities = new HashSet<Activity>(0);

	public User() {
	}

	public User(int userId, Role role, String ULogin, String UPwd, String UName, String UAddress, Date UBirthday,
			String UCity) {
		this.userId = userId;
		this.role = role;
		this.ULogin = ULogin;
		this.UPwd = UPwd;
		this.UName = UName;
		this.UAddress = UAddress;
		this.UBirthday = UBirthday;
		this.UCity = UCity;
	}

	public User(int userId, Role role, String ULogin, String UPwd, String UName, String UAddress, Date UBirthday,
			String UCity, Set<Activity> activities) {
		this.userId = userId;
		this.role = role;
		this.ULogin = ULogin;
		this.UPwd = UPwd;
		this.UName = UName;
		this.UAddress = UAddress;
		this.UBirthday = UBirthday;
		this.UCity = UCity;
		this.activities = activities;
	}

	@Id

	@Column(name = "USER_ID", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "U_ROLE_ID", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "U_LOGIN", unique = true, nullable = false, length = 45)
	public String getULogin() {
		return this.ULogin;
	}

	public void setULogin(String ULogin) {
		this.ULogin = ULogin;
	}

	@Column(name = "U_PWD", nullable = false, length = 45)
	public String getUPwd() {
		return this.UPwd;
	}

	public void setUPwd(String UPwd) {
		this.UPwd = UPwd;
	}

	@Column(name = "U_NAME", nullable = false, length = 45)
	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	@Column(name = "U_ADDRESS", nullable = false, length = 45)
	public String getUAddress() {
		return this.UAddress;
	}

	public void setUAddress(String UAddress) {
		this.UAddress = UAddress;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "U_BIRTHDAY", nullable = false, length = 10)
	public Date getUBirthday() {
		return this.UBirthday;
	}

	public void setUBirthday(Date UBirthday) {
		this.UBirthday = UBirthday;
	}

	@Column(name = "U_CITY", nullable = false, length = 45)
	public String getUCity() {
		return this.UCity;
	}

	public void setUCity(String UCity) {
		this.UCity = UCity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

}
