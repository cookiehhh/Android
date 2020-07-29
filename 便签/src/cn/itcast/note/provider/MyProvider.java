package cn.itcast.note.provider;

import cn.itcast.note.db.MySQLiteOpenHelper;
import cn.itcast.note.utils.Uris;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

public class MyProvider extends ContentProvider {

	private MySQLiteOpenHelper mySQLiteOpenHelper;
	private static final String AUTHORITY = "cn.itcast.note.provider.Myprovider";
	private static UriMatcher uriMatcher;
	private static final int QUERY = 1;
	private static final int UAPDATE = 2;
	private static final int DELETE = 3;
	private static final int INSERT = 4;
	private static final String TABLE_NAME = "notes";

	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORITY, "note/query", QUERY);
		uriMatcher.addURI(AUTHORITY, "note/update", UAPDATE);
		uriMatcher.addURI(AUTHORITY, "note/delete", DELETE);
		uriMatcher.addURI(AUTHORITY, "note/insert", INSERT);
	}

	@Override
	public boolean onCreate() {
		mySQLiteOpenHelper = new MySQLiteOpenHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db = mySQLiteOpenHelper.getReadableDatabase();
		Cursor cursor = null;
		//ƥ��Uri
		if (uriMatcher.match(uri) == QUERY) {
			if (db.isOpen()) {
				cursor = db.query(TABLE_NAME, projection, selection,
						selectionArgs, null, null, sortOrder);
			}
		}
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
		long id = 0;
		//ƥ��Uri
		if(uriMatcher.match(uri)==INSERT){
			if(db.isOpen()){
				id = db.insert(TABLE_NAME, null, values);
				if(id != -1){
					Toast.makeText(getContext(), "��ӳɹ�", 0).show();
				}
					getContext().getContentResolver().notifyChange(Uris.AUTHORITY, null);
				db.close();
			}
		}
		return ContentUris.withAppendedId(uri, id);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
		int id = 0;
		if(uriMatcher.match(uri)==DELETE){
			if(db.isOpen()){
				id = db.delete(TABLE_NAME, selection, selectionArgs);
				 getContext().getContentResolver().notifyChange(Uris.AUTHORITY, null);
				 db.close();
			}
		}
		return id;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int id = 0;
		SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
		if(uriMatcher.match(uri)== UAPDATE){
			if(db.isOpen()){
				id = db.update(TABLE_NAME, values, selection, selectionArgs);
				getContext().getContentResolver().notifyChange(Uris.AUTHORITY, null);
			}
		}

		return id;
	}
}
