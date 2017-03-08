package com.yxm.login;

import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText username;
	private EditText password;
	private CheckBox cb_isCheck;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.et_username);
        password = (EditText)findViewById(R.id.et_password);
        cb_isCheck = (CheckBox)findViewById(R.id.cb_isCheck);
        
        //
        Map<String, String> userInfo = UserInfoUtils.readUserInfo();
        if(userInfo!=null){
        	username.setText(userInfo.get("name"));
        	password.setText(userInfo.get("name"));
        } 
    }
    private void login(View v){
    	//login()里面拿到用户名和密码,判断是否为空(给出提示),不为空的话  
    	//想要获得用户名密码控件里面的值,我们把它们定义成成员变量
    	String name = username.getText().toString().trim();
    	String pwd = password.getText().toString().trim();
    	
    	if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
    		Toast.makeText(MainActivity.this,"用户名或者密码不为空", 1).show();
    	}else{
    		//不为空,判断勾选(获取checkBox)
    		if(cb_isCheck.isChecked()){
    			//保存用户信息
    			boolean result = UserInfoUtils.saveUserInfo(name,pwd);
    			if(result){
    				Toast.makeText(MainActivity.this, "保存成功", 1).show();
    			}else{
    				Toast.makeText(MainActivity.this, "保存失败", 1).show();
    			}
    			cb_isCheck.setChecked(false);
    		}else{
    			Toast.makeText(MainActivity.this, "cb勾选", 1).show();
    		}
    	}
    }
}
