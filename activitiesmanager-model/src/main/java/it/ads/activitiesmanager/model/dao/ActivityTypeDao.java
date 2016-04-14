package it.ads.activitiesmanager.model.dao;

import it.ads.activitiesmanager.model.entity.ActivityType;

public class ActivityTypeDao extends AbstractDao<ActivityType> {
	
	public ActivityTypeDao() {
		setClass(ActivityType.class);
	}
}