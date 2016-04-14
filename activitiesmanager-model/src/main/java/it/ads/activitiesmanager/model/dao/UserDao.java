package it.ads.activitiesmanager.model.dao;

import javax.persistence.Query;

import it.ads.activitiesmanager.model.entity.User;

public class UserDao extends AbstractDao<User> {
	
	public UserDao() {
		setClass(User.class);
	}
	
	public User getUserByLogin(String login) {
		String SELECT =   "SELECT * "
						+ "FROM User "
						+ "WHERE U_LOGIN LIKE :login";
		Query query = em.createQuery(SELECT);
		return (User) query.getResultList().get(0);
	}
}