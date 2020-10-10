package com.spring_scheduling.service;

import com.spring_scheduling.dao.UserDao;
import com.spring_scheduling.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDao dao;

	// schedule a job to add object in DB (Every 5 sec)
	@Scheduled(fixedRate = 5000)

	public void add2DBJob() {
		User user = new User();
		user.setName("user" + new Random().nextInt(374483));
		dao.save(user);
		System.out.println("add service call in " + new Date().toString());
	}

	//Every 15th secoond
	@Scheduled(cron = "0/15 * * * * *")
	public void fetchDBJob() {
		List<User> users = dao.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of record fetched : " + users.size());
		log.info("users : {}", users);
	}

}
