package it.ads.activitiesmanager.model.dao;

import it.ads.activitiesmanager.model.entity.Role;

public class RoleDao extends AbstractDao<Role> {
	
	public RoleDao() {
		setClass(Role.class);
	}
}