package es.android.component.linearlayout;


import es.android.examples.R;
import es.android.listeners.onlogin.OnLoginListerner;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ControlLogin extends LinearLayout {

	
	protected OnLoginListerner listener;
	
	EditText txtUsuario = null;
	EditText txtPassword = null;
    Button btnLogin = null;
    TextView lblMensaje = null;
 
	
	public ControlLogin(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initComponent();
		
		// Procesamos los atributos XML personalizados
	    TypedArray a =
	        getContext().obtainStyledAttributes(attrs,
	            R.styleable.ControlLogin);
	 
	    String textoBoton = a.getString(
	            R.styleable.ControlLogin_login_text);
	 
	    btnLogin.setText(textoBoton);
	 
	    a.recycle();
	}

	
	public void setOnLoginListener(OnLoginListerner listener)
	{
		this.listener=listener;
	}
	
	public ControlLogin(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initComponent();
	}
	
	protected void initComponent()
	{
		//Utilizamos el layout 'control_login' como interfaz del control
	    String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.control_login, this, true);
	 
	    //Obtenemoslas referencias a los distintos control
	    txtUsuario = (EditText)findViewById(R.id.TxtUsuario);
	    txtPassword = (EditText)findViewById(R.id.TxtPassword);
	    btnLogin = (Button)findViewById(R.id.BtnAceptar);
	    lblMensaje = (TextView)findViewById(R.id.LblMensaje);
	 
	    //Asociamos los eventos necesarios
	    asignarEventos();
	}
		
	public void setMessage(String message)
	{
		lblMensaje.setText(message);
	}
	
	private void asignarEventos()
	{
	    btnLogin.setOnClickListener(new OnClickListener()
	    {
	       
	        public void onClick(View v) {
	            listener.onLogin(txtUsuario.getText().toString(),
	                         txtPassword.getText().toString());
	        }
	    });
	}
}
