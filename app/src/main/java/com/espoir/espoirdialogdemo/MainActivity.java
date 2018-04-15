package com.espoir.espoirdialogdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

	private Button btnAlertDialog,btnAlertDialogWithButton,btnAlertDialogWithList,btnAlertDialogwithCheckBox,
	               btnTimePicker,btnDatePicker,btnCustomAlertDialog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    public void initUi(){
    	btnAlertDialog =  (Button) findViewById(R.id.btn_alert_dialog);
    	btnAlertDialog.setOnClickListener(this);
    	
    	btnAlertDialogWithButton =  (Button) findViewById(R.id.btn_dialog_with_button);
    	btnAlertDialogWithButton.setOnClickListener(this);
    	
    	btnAlertDialogwithCheckBox =  (Button) findViewById(R.id.btn_alert_dialog_checkbox);
    	btnAlertDialogwithCheckBox.setOnClickListener(this);
    	
    	btnAlertDialogWithList =  (Button) findViewById(R.id.btn_dailog_with_list);
    	btnAlertDialogWithList.setOnClickListener(this);
    	
    	btnCustomAlertDialog =  (Button) findViewById(R.id.btn_custom_alert_dialog);
    	btnCustomAlertDialog.setOnClickListener(this);
    	
    	btnDatePicker =  (Button) findViewById(R.id.btn_date_picker);
    	btnDatePicker.setOnClickListener(this);
    	
    	btnTimePicker =  (Button) findViewById(R.id.btn_date_picker);
    	btnTimePicker.setOnClickListener(this);
    	
    }
   

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_alert_dialog:
			alertDialog();
			break;
        case R.id.btn_alert_dialog_checkbox:
        	alertDialogWithCheckBox();
			break;
        case R.id.btn_dailog_with_list:
        	alertDialogWithList();
			break;
        case R.id.btn_dialog_with_button:
        	alertDialogWithButton();
			break;
        case R.id.btn_custom_alert_dialog:
        	alertCustomDialog();
			break;
        case R.id.btn_time_picker:
        	alertDatePicker();
			break;
        case R.id.btn_date_picker:
        	alertTimePicker();
		
		break;

		default:
			break;
		}
		
	}
	
	public void alertDialog(){
		AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                .create();
		// Setting Dialog Title
		alertDialog.setTitle("Espo Alert Dialog");
		// Setting Dialog Message
		alertDialog.setMessage("Welcome to Espo android world");
		// Setting Icon to Dialog
		alertDialog.setIcon(R.drawable.ic_launcher);
		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// Write your code here to execute after dialog closed
				Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
				
			}
		});
		// Showing Alert Message
		alertDialog.show();
	}
	
    public void alertDialogWithButton(){
    	AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
    	 
        // Setting Dialog Title
        alertDialog.setTitle("Confirm Delete...");
 
        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want delete this?");
 
        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_launcher);
 
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
 
            // Write your code here to invoke YES event
            Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
            }
        });
 
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            // Write your code here to invoke NO event
            Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
            dialog.cancel();
            }
        });
 
        // Showing Alert Message
        alertDialog.show();
	}
    public void alertDialogWithList(){
    	AlertDialog.Builder builderSingle = new AlertDialog.Builder(
                MainActivity.this);
        builderSingle.setIcon(R.drawable.ic_launcher);
        builderSingle.setTitle("Select One Name:-");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Hardik");
        arrayAdapter.add("Archit");
        arrayAdapter.add("Jignesh");
        arrayAdapter.add("Umang");
        arrayAdapter.add("Gatti");
        builderSingle.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builderSingle.setAdapter(arrayAdapter,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = arrayAdapter.getItem(which);
                        AlertDialog.Builder builderInner = new AlertDialog.Builder(
                                MainActivity.this);
                        builderInner.setMessage(strName);
                        builderInner.setTitle("Your Selected Item is");
                        builderInner.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(
                                            DialogInterface dialog,
                                            int which) {
                                        dialog.dismiss();
                                    }
                                });
                        builderInner.show();
                    }
                });
        builderSingle.show();
   	}
    public void alertDialogWithCheckBox(){
    	 Dialog dialog;
    	 final CharSequence[] items = {" Easy "," Medium "," Hard "," Very Hard "};
         // arraylist to keep the selected items
         final ArrayList seletedItems=new ArrayList();

         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder.setTitle("Select The Difficulty Level");
         builder.setMultiChoiceItems(items, null,
                 new DialogInterface.OnMultiChoiceClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int indexSelected,
                  boolean isChecked) {
              if (isChecked) {
                  // If the user checked the item, add it to the selected items
                  seletedItems.add(indexSelected);
              } else if (seletedItems.contains(indexSelected)) {
                  // Else, if the item is already in the array, remove it
                  seletedItems.remove(Integer.valueOf(indexSelected));
              }
          }
      })
       // Set the action buttons
      .setPositiveButton("OK", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int id) {
              //  Your code when user clicked on OK
              //  You can write the code  to save the selected item here

          }
      })
      .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int id) {
             //  Your code when user clicked on Cancel

          }
      });

         dialog = builder.create();//AlertDialog dialog; create like this outside onClick
         dialog.show();
 
   	}
    public void alertCustomDialog(){
    	 // Create custom dialog object
        final Dialog dialog = new Dialog(MainActivity.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.custom_alert_dialog);
        // Set dialog title
        dialog.setTitle("Custom Dialog");
        dialog.setCancelable(false);

        // set values for custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.textDialog);
        text.setText("Custom dialog Android example.");
        ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
        image.setImageResource(R.drawable.ic_launcher);

        dialog.show();
         
        Button declineButton = (Button) dialog.findViewById(R.id.declineButton);
        // if decline button is clicked, close the custom dialog
        declineButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();
            }
        });

   
   	}
    public void alertDatePicker(){
		Intent intent = new Intent(this,DateAndTimePickerActivity.class);
		startActivity(intent);
   	}
    public void alertTimePicker(){
    	Intent intent = new Intent(this,DateAndTimePickerActivity.class);
		startActivity(intent);
   	}
    
    public void alertDailogWithNeturalButton(){
    	AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
    	 
        // Setting Dialog Title
        alertDialog.setTitle("Save File...");

        // Setting Dialog Message
        alertDialog.setMessage("Do you want to save this file?");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_launcher);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            // User pressed YES button. Write Logic Here
            Toast.makeText(getApplicationContext(), "You clicked on YES",
                                Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            // User pressed No button. Write Logic Here
            Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Netural "Cancel" Button
        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            // User pressed Cancel button. Write Logic Here
            Toast.makeText(getApplicationContext(), "You clicked on Cancel",
                                Toast.LENGTH_SHORT).show();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
   
	
}
