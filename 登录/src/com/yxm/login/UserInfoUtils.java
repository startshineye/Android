package com.yxm.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserInfoUtils {
	
	//保存用户名和密码
    public static boolean saveUserInfo(String username,String password){
    	String result = username+"##"+password;
    	String path = "/data/data/com.yxm.login/info.txt";
    	//定义文件保存位置
    	File file = new File(path);
    	//定义一个输出流
    	try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(result.getBytes());
			fos.flush();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	
    }
    /***
     * 读取用户信息到Map中
     * @return
     */
    public static Map<String,String> readUserInfo(){
    	try {
			Map<String, String> map = new HashMap<String,String>();
			String path = "/data/data/com.yxm.login/info.txt";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String content = br.readLine();
			String[] split = content.split("##");
			map.put("name", split[0]);
			map.put("pwd", split[1]);
			fis.close();
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
    }
}
