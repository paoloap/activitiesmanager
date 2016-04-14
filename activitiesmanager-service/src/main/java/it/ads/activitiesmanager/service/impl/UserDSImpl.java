package it.ads.activitiesmanager.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ads.activitiesmanager.model.dao.AbstractDao;
import it.ads.activitiesmanager.model.entity.User;
import it.ads.activitiesmanager.service.IUserDS;
import it.ads.activitiesmanager.service.common.UserStruct;

@Service
public class UserDSImpl implements IUserDS {
	
	@Autowired
	AbstractDao<User> userDao;
	
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public String register(UserStruct u) {
		try {
			SimpleDateFormat d = new SimpleDateFormat("dd/M/yyyy");
			Date data = d.parse(u.getBirthday());
			User user = new User();
			user.setULogin(u.getLogin());
			user.setUPwd(u.getPassword());
			user.setUName(u.getName());
			user.setUAddress(u.getAddress());
			user.setUBirthday(data);
			user.setUCity(u.getCity());
			userDao.update(user);
			return "";
		}
		catch (ParseException e) {
			logger.error(e.getMessage(),e);
			return "errorData";
		}
		
		
	}
	
}
