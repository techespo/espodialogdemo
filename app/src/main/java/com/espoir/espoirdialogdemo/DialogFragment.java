package com.espoir.espoirdialogdemo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class DialogFragment extends android.support.v4.app.DialogFragment{
	
		 Button mButton;  
		 EditText mEditText;  
		 onSubmitListener mListener;  
		 String text = "";  
		  
		 interface onSubmitListener {  
		  void setOnSubmitListener(String arg);  
		 }  
		  
		 @Override  
		 public Dialog onCreateDialog(Bundle savedInstanceState) {  
		  final Dialog dialog = new Dialog(getActivity());  
		  dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);  
		  dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
		    WindowManager.LayoutParams.FLAG_FULLSCREEN);  
		  dialog.setContentView(R.layout.dialog_fragment);  
		  dialog.getWindow().setBackgroundDrawable(  
		    new ColorDrawable(Color.TRANSPARENT));  
		  dialog.show();  
		  mButton = (Button) dialog.findViewById(R.id.button1);  
		  mEditText = (EditText) dialog.findViewById(R.id.editText1);  
		  mEditText.setText(text);  
		  mButton.setOnClickListener(new OnClickListener() {  
		  
		   @Override  
		   public void onClick(View v) {  
		    mListener.setOnSubmitListener(mEditText.getText().toString());  
		    dismiss();  
		   }  
		  });  
		  return dialog;  
		 }  
		}  