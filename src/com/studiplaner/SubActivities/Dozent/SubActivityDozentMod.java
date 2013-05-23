package com.studiplaner.SubActivities.Dozent;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.studiplaner.R;

import db.ActivityDB;
import db.Lecturer;

public class SubActivityDozentMod extends ActivityDB {
	Lecturer lehrender;
	
	@Override
	public void onCreate(Bundle savedInstance){
		super.onCreate(savedInstance);
		lehrender = new Lecturer(this);
	}
	
	@Override
	public void onStop(){
		super.onStop();
	}
	
	public Map<String, String> getDozentGuiInformation() {
		EditText name = (EditText) findViewById(R.id.profName);
		EditText room = (EditText) findViewById(R.id.profRoom);
		EditText mail = (EditText) findViewById(R.id.profMail);

		Map<String, String> profBind = new HashMap<String, String>();
		profBind.put("name", name.getText().toString());
		profBind.put("place", room.getText().toString());
		profBind.put("email", mail.getText().toString());

		return profBind;
	}
	
	public void setDozentGuiInformation(int dozentId) {
		EditText name = (EditText) findViewById(R.id.profName);
		EditText room = (EditText) findViewById(R.id.profRoom);
		EditText email = (EditText) findViewById(R.id.profMail);

		Map<String, String> dozentBind = lehrender.getDozent(dozentId);
		name.setText(dozentBind.get("name"));
		room.setText(dozentBind.get("place"));
		email.setText(dozentBind.get("email"));
	}
	
	public void finish(View arg0){
		finish();
	}
}
