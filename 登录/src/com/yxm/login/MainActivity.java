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
    	//login()�����õ��û���������,�ж��Ƿ�Ϊ��(������ʾ),��Ϊ�յĻ�  
    	//��Ҫ����û�������ؼ������ֵ,���ǰ����Ƕ���ɳ�Ա����
    	String name = username.getText().toString().trim();
    	String pwd = password.getText().toString().trim();
    	
    	if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
    		Toast.makeText(MainActivity.this,"�û����������벻Ϊ��", 1).show();
    	}else{
    		//��Ϊ��,�жϹ�ѡ(��ȡcheckBox)
    		if(cb_isCheck.isChecked()){
    			//�����û���Ϣ
    			boolean result = UserInfoUtils.saveUserInfo(name,pwd);
    			if(result){
    				Toast.makeText(MainActivity.this, "����ɹ�", 1).show();
    			}else{
    				Toast.makeText(MainActivity.this, "����ʧ��", 1).show();
    			}
    			cb_isCheck.setChecked(false);
    		}else{
    			Toast.makeText(MainActivity.this, "cb��ѡ", 1).show();
    		}
    	}
    }
}
