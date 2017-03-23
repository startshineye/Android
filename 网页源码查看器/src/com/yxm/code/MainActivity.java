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
        //拿到控件
        et = (EditText)findViewById(R.id.et_path);
        content = (TextView)findViewById(R.id.et_content);
    }
    
    //点击事件
    public void click(){
      try {
		   //【2.1】获取路径
			String path = et.getText().toString().trim();
			//【2.2】创建 URL 对象指定我们要访问的网址
			URL url = new URL(path);
			//【2.3】获取HttpUrlConnection对象 用于发送或者接受数据
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//【2.4】设置发送Get请求
			conn.setRequestMethod("GET");
			//【2.5】设置请求超时时间
			conn.setReadTimeout(5000);
			//【2.6】获取服务器返回的状态码
			int code = conn.getResponseCode();
			//【2.7】code == 200说明请求成功
			if(code == 200){
				//【2.8】获取服务器返回的数据（以流的形式）
				InputStream in = conn.getInputStream();
				//【2.9】把流里面数据返回到页面
			}
			
	} catch (Exception e) {
		e.printStackTrace();
	} 
    }
}
