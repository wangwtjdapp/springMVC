package com.mvc.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mvc.dao.BaseDaoHouse;
import com.mvc.until.TcUser;

/**
 * 默认加载该类
 * @author Administrator
 *
 */
@Component("LoadUsers")
@Service
public class LoadUsers implements ApplicationListener<ApplicationEvent>{

	@Autowired
	private BaseDaoHouse baseDaoHouse;
	
	private static List<TcUser> tcuserList = null;

	//单例模式，线程安全
	private static final LoadUsers instance = new LoadUsers();
	private LoadUsers(){
		
	}
	
	public static LoadUsers getInstance(){
		return instance;
	}
	
	/**
	 * 默认加载该方法
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			System.out.println("spring容易初始化完毕================================================888");
			initTcUserList();
		}
		
	}
	
	/**
	 * 初始化
	 */
	private void initTcUserList(){
		tcuserList = new ArrayList<TcUser>();
		tcuserList=baseDaoHouse.getTcUsers();
	}
	
	public List<TcUser> getTcuserList(){
		return tcuserList;
	}
	
	/**
	 * 刷新一下
	 */
	public void refreshTcUserList(){
		tcuserList = new ArrayList<TcUser>();
		tcuserList=baseDaoHouse.getTcUsers();
	}
	
	

}
