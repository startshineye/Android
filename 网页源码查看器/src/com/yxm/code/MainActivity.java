package com.yxm.code;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText et;
	private TextView content;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //�õ��ؼ�
        et = (EditText)findViewById(R.id.et_path);
        content = (TextView)findViewById(R.id.et_content);
    }
    
    //����¼�
    public void click(){
      try {
		   //��2.1����ȡ·��
			String path = et.getText().toString().trim();
			//��2.2������ URL ����ָ������Ҫ���ʵ���ַ
			URL url = new URL(path);
			//��2.3����ȡHttpUrlConnection���� ���ڷ��ͻ��߽�������
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//��2.4�����÷���Get����
			conn.setRequestMethod("GET");
			//��2.5����������ʱʱ��
			conn.setReadTimeout(5000);
			//��2.6����ȡ���������ص�״̬��
			int code = conn.getResponseCode();
			//��2.7��code == 200˵������ɹ�
			if(code == 200){
				//��2.8����ȡ���������ص����ݣ���������ʽ��
				InputStream in = conn.getInputStream();
				//��2.9�������������ݷ��ص�ҳ��
			}
			
	} catch (Exception e) {
		e.printStackTrace();
	} 
    }
}
