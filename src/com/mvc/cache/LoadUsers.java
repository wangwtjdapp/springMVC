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
 * Ĭ�ϼ��ظ���
 * @author Administrator
 *
 */
@Component("LoadUsers")
@Service
public class LoadUsers implements ApplicationListener<ApplicationEvent>{

	@Autowired
	private BaseDaoHouse baseDaoHouse;
	
	private static List<TcUser> tcuserList = null;

	//����ģʽ���̰߳�ȫ
	private static final LoadUsers instance = new LoadUsers();
	private LoadUsers(){
		
	}
	
	public static LoadUsers getInstance(){
		return instance;
	}
	
	/**
	 * Ĭ�ϼ��ظ÷���
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			System.out.println("spring���׳�ʼ�����================================================888");
			initTcUserList();
		}
		
	}
	
	/**
	 * ��ʼ��
	 */
	private void initTcUserList(){
		tcuserList = new ArrayList<TcUser>();
		tcuserList=baseDaoHouse.getTcUsers();
	}
	
	public List<TcUser> getTcuserList(){
		return tcuserList;
	}
	
	/**
	 * ˢ��һ��
	 */
	public void refreshTcUserList(){
		tcuserList = new ArrayList<TcUser>();
		tcuserList=baseDaoHouse.getTcUsers();
	}
	
	

}
