package it.ads.activitiesmanager.model.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "Role", catalog = "amdb", uniqueConstraints = @UniqueConstraint(columnNames = "R_NAME"))
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private String RName;
	private Set<User> users = new HashSet<User>(0);
	private Set<Permission> permissions = new HashSet<Permission>(0);

	public Role() {
	}

	public Role(String RName) {
		this.RName = RName;
	}

	public Role(String RName, Set<User> users, Set<Permission> permissions) {
		this.RName = RName;
		this.users = users;
		this.permissions = permissions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ROLE_ID", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "R_NAME", unique = true, nullable = false, length = 20)
	public String getRName() {
		return this.RName;
	}

	public void setRName(String RName) {
		this.RName = RName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Role_has_Permission", catalog = "amdb", joinColumns = {
			@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "PERMISSION_ID", nullable = false, updatable = false) })
	public Set<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

}
