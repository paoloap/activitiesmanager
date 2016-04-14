package it.ads.activitiesmanager.model.dao;

import it.ads.activitiesmanager.model.entity.ActivityStatus;

public class ActivityStatusDao extends AbstractDao<ActivityStatus> {
	
	public ActivityStatusDao() {
		setClass(ActivityStatus.class);
	}
}