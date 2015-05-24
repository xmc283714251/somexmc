package com.somexmc.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Toast;

/**
 * ������activity��
 * @author mc
 *
 */
public abstract class BaseActivity extends Activity
{
	/** 
	 * ״̬����˫���˳� 
	 */
	private static Boolean isExit  = false;
	@Override
	protected void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		//����ȥ��Ĭ�ϱ���
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//��ʼ����ͼ
		initContentView(bundle);
		
		//getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);
		
		initViewEvent(bundle);
		
		//��ʼ������
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
			isExit  = true;// ׼���Ƴ�ϵͳ
			Toast.makeText(this, "�ٴε���˳�ϵͳ", Toast.LENGTH_SHORT).show();
			// ���2������û�а��·��ؼ�����������ʱ��ȡ�����ղ�ִ�е�����
			tExit = new Timer();
			tExit.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					 isExit = false; // ȡ���˳�
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
