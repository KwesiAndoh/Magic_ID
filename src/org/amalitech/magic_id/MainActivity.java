package org.amalitech.magic_id;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	EditText et_id; 
	Button btn_submit;
	TextView tv_resut;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et_id = (EditText)findViewById(R.id.et_id);
		btn_submit = (Button)findViewById(R.id.btn_submit);
		tv_resut = (TextView)findViewById(R.id.tv_result);
		
		btn_submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String  idNumber = et_id.getText().toString().trim();
				
				String dob = idNumber.substring(0,6);
				
				String Gender;
				int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
				
				if(gender < 5) {
					Gender = "Female";
				}else {
					Gender = "Male";
				}
				
				String sNationality = "";
				int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
				if(nationality == 0) {
					sNationality = "South African";
				}else {
					sNationality = "permanent citizen";
				}
				
				String text = getString(R.string.dob) + dob 
						+ getString(R.string.nationality)+ sNationality
						+ getString(R.string.gender) + gender;

				et_id.setText(text);
														
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
