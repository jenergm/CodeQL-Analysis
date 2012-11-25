package es.android.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	// Nombre de la base de datos
	// :TODO Cambiar por el nombre de la base de datos
	public static final String DATABASE_NAME = "DBAndroid23.db";
	// :TODO Cambiar es la version
	public static final int DABASE_VERSION = 1;
	
	
	// Método para limpiar la base de datos
	public void cleanupDataBase(SQLiteDatabase paramSQLiteDatabase) {
		Log.w("DatabaseHelper", "Deleting all tables and recreating them fresh");
		paramSQLiteDatabase.beginTransaction();

		try {

			/*
			 * :TODO Cambiar añadir las tablas que es necesario eliminar
			 * Borramos las tablas que correspondan
			 */
			paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS Usuarios");

			/* Ejecutamos la transaccion */
			paramSQLiteDatabase.setTransactionSuccessful();
			paramSQLiteDatabase.endTransaction();
			// Llamamos a onCreate para crear la base de datos
			onCreate(paramSQLiteDatabase);

			return;

		} finally {
			paramSQLiteDatabase.endTransaction();
		}

	}

	public DatabaseHelper(Context paramContext) {
		super(paramContext, DATABASE_NAME, null, DABASE_VERSION);
	}

	public DatabaseHelper(Context contexto, String nombre,
			CursorFactory factory, int version) {
		super(contexto, nombre, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
		// TODO Auto-generated method stub
		paramSQLiteDatabase.beginTransaction();

		try {
			
			/*TODO: Añadir las tablas que es necesario crear*/
			paramSQLiteDatabase.execSQL("CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)");
										 
			
			paramSQLiteDatabase.setTransactionSuccessful();
			return;

		} finally {
			paramSQLiteDatabase.endTransaction();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
		// TODO Auto-generated method stub
		Log.w("DatabaseHelper", "Upgrading database from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
	    cleanupDataBase(paramSQLiteDatabase);

	}
	
	
	/*:TODO Añadir una clase interface por cada tabla*/
	
	 public static abstract interface UsuariosColumns
	  {
		 public static final String CODIGO = "codigo";
		 public static final String NOMBRE = "nombre";
	  }

}
