package org.crazyit.link;
//Download by http://www.codefans.net
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity{


	private Button startButton;

	private Button rangeButton;

	private Button outButton;
	
	private Button setButton;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wel);
	
		startButton = (Button) this.findViewById(R.id.startButton);
		
		rangeButton = (Button) this.findViewById(R.id.rangeButton);
	
		setButton = (Button) this.findViewById(R.id.setButton);
	
		outButton = (Button) this.findViewById(R.id.outButton);
		
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				Intent i = new Intent();
				i.setClass(Welcome.this, Link.class);
				startActivity(i);
				
				
			}
		});
		outButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
				Welcome.this.finish();
			}
		});
	}
		
	

	
}
