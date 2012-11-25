package es.android.provider;

import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

public class SearchDatabase {

	private final Context mContext;
	private final DatabaseHelper mDatabaseOpenHelper;

	/* Se crea el search database */
	public SearchDatabase(Context context) {
		this.mContext = context;
		this.mDatabaseOpenHelper = new DatabaseHelper(this.mContext);
	}

	private Cursor query(String selection, String[] selectionArgs,
			String[] projectionIn, String inTables,
			HashMap<String, String> columnMap,String sortOrder) {
		SQLiteDatabase localSQLiteDatabase = null;
		Cursor localCursor = null;

		SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
		localSQLiteQueryBuilder.setTables(inTables);
		localSQLiteQueryBuilder.setProjectionMap(columnMap);
		// recuperamos la conexion de base de datos
		localSQLiteDatabase = mDatabaseOpenHelper.getReadableDatabase();

		// Si la conexion en nula retornamos null en el cursor
		if (localSQLiteDatabase == null) {
			Log.e("SearchDatabase", "db is null - search query");
			return null;
		}
		try {
			localCursor = localSQLiteQueryBuilder.query(localSQLiteDatabase,
					projectionIn, selection, selectionArgs, null, null, sortOrder);
		} catch (Exception excp) {
			Log.e("SearchDatabase",
					"Exception occurred while performing search query" + excp);
		}

		return localCursor;
	}

	
	private ContentValues getContentValues(String codigo,String nombre)
	  {
		
		ContentValues localContentValues = new ContentValues();
		localContentValues.put("codigo", codigo);
		localContentValues.put("nombre", nombre);
		
		return localContentValues;
		
		
	  }
	
	public void insertUser(String codigo,String nombre)
	{
		SQLiteDatabase localSQLiteDatabase = this.mDatabaseOpenHelper
				.getWritableDatabase();
		
		localSQLiteDatabase.insert("Usuarios", null, getContentValues(codigo,nombre));
		
		localSQLiteDatabase.close();
		
	}
	
	public void closeDataBase() {

		Log.v("SearchDatabase", "Closing search database");
		SQLiteDatabase localSQLiteDatabase = this.mDatabaseOpenHelper
				.getWritableDatabase();
		if (localSQLiteDatabase != null)
			localSQLiteDatabase.close();
	}

	
	public void set()
	{
		mDatabaseOpenHelper.getWritableDatabase();
	}
	
	
	public Cursor getUsers(String selection, String[] selectionArgs)
	{
	
			 HashMap localHashMap = new HashMap();
			 localHashMap.put("_id", "rowid AS _id");
			 localHashMap.put("codigo", "codigo");
			 localHashMap.put("nombre", "nombre");
			
			
			return query(selection, selectionArgs, new String[]{"_id","codigo","nombre"}, "Usuarios", localHashMap,null);
	}
	
	public Cursor getUsers(String selection, String[] selectionArgs,String[] projection,String sortOrder)
	{
	
			 HashMap localHashMap = new HashMap();
			 localHashMap.put("_id", "rowid AS _id");
			 localHashMap.put("codigo", "codigo");
			 localHashMap.put("nombre", "nombre");
			
			
			return query(selection, selectionArgs, projection, "Usuarios", localHashMap,sortOrder);
	}		
}
