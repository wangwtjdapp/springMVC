package com.mvc.dao;

import java.util.List;

import com.mvc.until.TcUser;
import com.mvc.until.Tcplrck;

public interface BaseDaoHouse {
	
	public List<Tcplrck> getTcList();
	public List<TcUser> getTcUsers();

}
