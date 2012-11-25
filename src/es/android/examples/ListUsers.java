package es.android.examples;


import es.android.provider.SearchDatabase;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;


public class ListUsers extends ListActivity  {

	SearchDatabase sDatabase = null;
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list_example);

	        
	        
	        sDatabase = new SearchDatabase(getBaseContext());
			
	        			
	     // THE DESIRED COLUMNS TO BE BOUND
            String[] columns = new String[] { "codigo", "nombre" };
         // THE XML DEFINED VIEWS WHICH THE DATA WILL BE BOUND TO
            int[] to = new int[] { R.id.name_entry, R.id.number_entry };
	         
            SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.list_example_entry, sDatabase.getUsers(null, null), columns, to);
            
            this.setListAdapter(mAdapter);
            
            
	    }
	    
	    public void onDestroy() 
	    {
	        super.onDestroy();
	        
	        sDatabase.closeDataBase();
	        
	    }
}
