package com.mvc.service.impl;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.cache.LoadUsers;
import com.mvc.dao.BaseDaoHouse;
import com.mvc.service.HouseService;
import com.mvc.until.TcUser;
import com.mvc.until.Tcplrck;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private BaseDaoHouse baseDaoHouse;

	@Override
	public String getTcList() {
		List<Tcplrck> tcList = baseDaoHouse.getTcList();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<tcList.size();i++){
			Tcplrck tc = tcList.get(i);
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", String.valueOf(tc.getId()));
			map.put("cz1", tc.getCz1());
			map.put("cz2", tc.getCz2());
			map.put("gg", tc.getGg());
			map.put("dw", tc.getDw());
			map.put("gcd", tc.getGcd());
			map.put("dj", String.valueOf(tc.getDj()));
			map.put("rq", tc.getRq());
			map.put("crkz", String.valueOf(tc.getCrkz()));
			map.put("jbr", tc.getJbr());
			map.put("clbj", tc.getClbj());
			
			
			JSONObject json = JSONObject.fromObject(map);
			jsonArray.add(json);
		}
		String resStr=jsonArray.toString();
		return resStr;
	}


	@Override
	public String getloginStatus(String str) {
		String status=null;
		JSONObject json = JSONObject.fromObject(str);
		String username=json.getString("UserName");
		String password=json.getString("PassWord");
//		String password=getFromBase64(json.getString("PassWord"));
		System.out.println("username: " + username + "; password: " + password);
//		List<TcUser> tc_users = baseDaoHouse.getTcUsers();
		List<TcUser> tc_users = LoadUsers.getInstance().getTcuserList();//直接加载缓存中数据
		
		
		for(int i=0;i<tc_users.size();i++){
			TcUser tc_user = tc_users.get(i);
			String tc_username=tc_user.getUserName();
			String tc_password=tc_user.getPassWord();
			String tc_password_md5=MD5(tc_password);
			
			if(tc_username.equals(username) 
					&& tc_password_md5.equals(password)){
				status="1";
				break;
			}
		
		}
		
		return status;
	}
	
	
	// 解密  
    private String getFromBase64(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
    
    
    // MD5加密，32位
    private String MD5(String str) {
        MessageDigest md5 =null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch(Exception e) {
            e.printStackTrace();
            return "";
        }

        char[] charArray = str.toCharArray();
        byte[] byteArray =new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue =new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) &0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

}
