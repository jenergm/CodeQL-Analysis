package es.android.examples;


import es.android.provider.SearchDatabase;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.widget.SimpleCursorAdapter;


public class ListCalls extends ListActivity  {

	    
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list_example);

	        
	        
	        String[] projection = new String[] {
	        	    Calls.TYPE,
	        	    Calls.NUMBER };
	        	 
	        	Uri llamadasUri =  Calls.CONTENT_URI;
	        	 
	        	ContentResolver cr = getContentResolver();
	        	 
	        	Cursor cur = cr.query(llamadasUri,
	        	        projection, //Columnas a devolver
	        	        null,       //Condición de la query
	        	        null,       //Argumentos variables de la query
	        	        null);      //Orden de los resultado
	        	
	        	int[] to = new int[] { R.id.name_entry, R.id.number_entry };
	         
            SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.list_example_entry, cur, projection, to);
            
            this.setListAdapter(mAdapter);
            
            
	    }
	    
	
}
