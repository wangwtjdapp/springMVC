package com.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.BaseDao;
import com.mvc.service.SearchService;
import com.mvc.until.User;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private BaseDao baseDao;

	@Override
	public List<User> getUsers() {
		
		List<User> users = baseDao.getUserList();
		return users;
	}

}
