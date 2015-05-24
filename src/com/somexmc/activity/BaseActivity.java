package com.somexmc.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Toast;

/**
 * 基础的activity类
 * @author mc
 *
 */
public abstract class BaseActivity extends Activity
{
	/** 
	 * 状态保存双击退出 
	 */
	private static Boolean isExit  = false;
	@Override
	protected void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		//设置去除默认标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//初始化视图
		initContentView(bundle);
		
		//getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);
		
		initViewEvent(bundle);
		
		//初始化数据
		initViewData(bundle);
		
	}
	
	/**
	 * 
	 * @param savedInstanceState
	 */
	protected abstract void initContentView(Bundle bundle);
	
	protected abstract void initViewEvent(Bundle bundle);
	
	protected abstract void initViewData(Bundle bundle);

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			exitApp();
		}
		return false;
	}
	
	private void exitApp()
	{
		Timer tExit = null;
		if (isExit == false)
		{
			isExit  = true;// 准备推出系统
			Toast.makeText(this, "再次点击退出系统", Toast.LENGTH_SHORT).show();
			// 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
			tExit = new Timer();
			tExit.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					 isExit = false; // 取消退出
				}
			}, 2000);
		}
		else
		{
			finish();
			System.exit(0);
		}
	}
	
}
