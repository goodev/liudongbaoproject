package com.branded.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TestListActivity extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.testlist);
		ListView list = (ListView) this.findViewById(R.id.mylist);
		list.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mStrings));
		Button bt = (Button)findViewById(R.id.mapview_bt);
		bt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("sssssssssssssssss");
			}});
		//bt.setVisibility(View.INVISIBLE);
	}

	private String[] mStrings = { "Abbaye de Belloc",
			"Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
			"Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu",
			"Airag", "Airedale", "Aisy Cendre", "Allgauer Emmentaler",
			"Alverca", "Ambert", "American Cheese", "Ami du Chambertin",
			"Anejo Enchilado", "Anneau du Vic-Bilh", "Anthoriro", "Appenzell",
			"Aragon", "Ardi Gasna" };
}
