package es.android.examples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Frmensaje extends Activity {

	private TextView text = null;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.frmensaje);
	        
	        text = (TextView) findViewById(R.id.textView1);
	        
	        Bundle bundle = getIntent().getExtras();
	        
	        text.setText(""+bundle.get("NOMBRE"));
	        
	    }

}
