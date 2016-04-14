package it.ads.activitiesmanager.model.dao;

import it.ads.activitiesmanager.model.entity.Activity;

public class ActivityDao extends AbstractDao<Activity> {
	
	public ActivityDao() {
		setClass(Activity.class);
	}
}
