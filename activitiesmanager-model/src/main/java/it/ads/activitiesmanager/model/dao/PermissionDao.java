package it.ads.activitiesmanager.model.dao;

import it.ads.activitiesmanager.model.entity.Permission;

public class PermissionDao extends AbstractDao<Permission> {
	
	public PermissionDao() {
		setClass(Permission.class);
	}
}