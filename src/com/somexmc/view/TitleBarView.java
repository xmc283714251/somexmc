package com.somexmc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.somexmc.R;

public class TitleBarView extends LinearLayout
{
	private ImageView backImageView;
	private TextView titleTextView;
	private ImageView rightImageView;
	
	private String title;
	private Drawable rightImage;
	
	
	public TitleBarView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		TypedArray typedarray = context.obtainStyledAttributes(attrs, R.styleable.TitleBarAttr);
		rightImage = typedarray.getDrawable(R.styleable.TitleBarAttr_rightImage);
		title = typedarray.getString(R.styleable.TitleBarAttr_title);
		
		typedarray.recycle();
		LayoutInflater.from(context).inflate(R.layout.view_title_bar, this, true);
		backImageView = (ImageView)findViewById(R.id.title_back_button);
		titleTextView = (TextView)findViewById(R.id.title_textview);
		titleTextView.setText(title);
		rightImageView = (ImageView)findViewById(R.id.title_right_button);
		if (rightImage != null)
		{
			rightImageView.setImageDrawable(rightImage);
		}
		else
		{
			rightImageView.setVisibility(View.GONE);
		}
		bindEvent();
	}
	
	private void bindEvent()
	{
		backImageView.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				setOnBackClick(v);
			}
		});
		rightImageView.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				setOnRightClick(v);				
			}
		});
	}
	
	public void setOnBackClick(View v)
	{
		
	}
	
	public void setOnRightClick(View v)
	{
		
	}

	public String getText()
	{
		title = titleTextView.getText().toString();
		return title;
	}

	public void setText(String text)
	{
		this.title = text;
		titleTextView.setText(text);
	}

	
	
}
