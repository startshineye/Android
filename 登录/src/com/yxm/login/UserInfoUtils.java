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
	
	//�����û���������
    public static boolean saveUserInfo(String username,String password){
    	String result = username+"##"+password;
    	String path = "/data/data/com.yxm.login/info.txt";
    	//�����ļ�����λ��
    	File file = new File(path);
    	//����һ�������
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
     * ��ȡ�û���Ϣ��Map��
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
