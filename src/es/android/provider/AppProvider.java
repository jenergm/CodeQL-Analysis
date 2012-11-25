package es.android.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;


public class AppProvider extends ContentProvider
{
	
	public static final String AUTHORITY = "es.android.searchableusers";
	
	private static final String uri = "content://"+AUTHORITY+"/usuarios";
	
	public static final Uri CONTENT_URI = Uri.parse(uri);
	
	private static final int USUARIOS = 1;
	private static final int USUARIOS_ID=2;
	private static final UriMatcher uriMatcher;
	
	private SearchDatabase searchDB;
	
	static
	{
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORITY, "usuarios", USUARIOS);
		uriMatcher.addURI(AUTHORITY, "usuarios/#", USUARIOS_ID);
	}
	
	
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/*
	 * Inicializar los recursos
	 * */
	public boolean onCreate() {
		/*Creamos la conexion*/
		//this.mOpenHelper = new DatabaseHelper(getContext());
		searchDB = new SearchDatabase(getContext());
		
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		String where = selection;
		
		if(uriMatcher.match(uri)==USUARIOS_ID)
				where = "_id=" + uri.getLastPathSegment();
		
		return searchDB.getUsers(where,selectionArgs,projection,sortOrder);
		
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public final static class Usuarios implements BaseColumns
	{
		
		private Usuarios(){}
		
		
		public static final String COL_CODIGO="codigo";
		public static final String COL_NOMBRE="nombre";
	}
	
	
	
	
}
