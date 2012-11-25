package es.android.examples;

import es.android.component.linearlayout.ControlLogin;
import es.android.images.ImageHelper;
import es.android.json.JsonSearch;
import es.android.listeners.onlogin.OnLoginListerner;
import es.android.provider.SearchDatabase;
import es.android.soap.SoapWeather;
import es.android.utils.Utils;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
public class MainActivity extends Activity {

	private EditText texto =null;
	private EditText texto2 =null;
	private EditText texto3 =null;
	ControlLogin login = null; 
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);

		Resources res = getResources();
		 
		TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		 
		Bitmap box = 
		        (BitmapFactory.decodeResource
		                (getResources(), R.drawable.ic_launcher));
		
		box = ImageHelper.getRoundedCornerBitmap(box, 1);
		
		Drawable d =new BitmapDrawable(getResources(),box);

		
		TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("Search",
		        res.getDrawable(android.R.drawable.ic_btn_speak_now));
		tabs.addTab(spec);
		 
		spec=tabs.newTabSpec("mitab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("Login",d);
		tabs.addTab(spec);
		 
		
		spec=tabs.newTabSpec("mitab3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("BaseDatos",
		        res.getDrawable(R.drawable.ic_launcher));
		tabs.addTab(spec);
		
		
		tabs.setCurrentTab(0);
		
		
		texto = (EditText) findViewById(R.id.TxtNombre);
		Button boton = (Button) findViewById(R.id.BtnHola);

		boton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Frmensaje.class);
				
				Bundle bundle = new Bundle();
				bundle.putString("NOMBRE", texto.getText().toString());
				
				intent.putExtras(bundle);
				
				startActivity(intent);
			}
		});
		
		Button boton2 = (Button) findViewById(R.id.BtnHola2);
		boton2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,
                        ListCalls.class));
			}
		});

		
		texto2 = (EditText) findViewById(R.id.TxtNombreDb);
		texto3 = (EditText) findViewById(R.id.TxtValorDb);
		
		Button boton3 = (Button) findViewById(R.id.BtnSave);
		boton3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Abrimos la base de datos 'DBUsuarios' en modo escritura
				
				SearchDatabase sDatabase = new SearchDatabase(v.getContext());
		        //sDatabase.getUsers(null, null);
				sDatabase.insertUser(texto2.getText().toString(), texto3.getText().toString());
		        texto2.setText("");
		        texto3.setText("");
			}
		});
		
		login= (ControlLogin) findViewById(R.id.CtlLogin);
		login.setOnLoginListener(new OnLoginListerner() {
			
			
			public void onLogin(String usuario, String password) {
				// TODO Auto-generated method stub
				if(usuario.equals("demo")&&password.equals("demo"))
					login.setMessage("Login Correcto");
				else
					login.setMessage("Login Incorrecto");
					
			}
		});
	
		
		Button boton4 = (Button) findViewById(R.id.BtnReadXML);
		boton4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent(MainActivity.this,PanelContentProviderActivity.class));
				startActivity(new Intent(MainActivity.this,PanelInicialActivity.class));
				
				
			/*	
				if (Utils.isNetworkAvailable(v.getContext())) 
				{
					startActivity(new Intent(MainActivity.this,PanelInicialActivity.class));
				
				}
				else
				{
					 Toast toast1 =
					            Toast.makeText(getApplicationContext(),
					                    "No existe conexion a internet activa", Toast.LENGTH_SHORT);
					 toast1.show();
				}
			*/
			}
			
		});

		Button boton5 = (Button) findViewById(R.id.BtnMapa);
		boton5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,
						AndroidMapas.class));
			}
		});
	}

	int tabHeight = 40;
	
	private TextView makeTabIndicator(String text){
		TextView tabView = new TextView(this);
		LayoutParams lp3 = new LayoutParams(LayoutParams.WRAP_CONTENT, tabHeight, 1);
		lp3.setMargins(1, 0, 1, 0);
		tabView.setLayoutParams(lp3);
		tabView.setText(text);
		tabView.setTextColor(Color.WHITE);
		tabView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
		tabView.setBackgroundDrawable( getResources().getDrawable(R.drawable.ic_launcher));
		tabView.setPadding(13, 0, 13, 0);
		return tabView;
		}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
