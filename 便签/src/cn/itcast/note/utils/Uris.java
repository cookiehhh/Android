package cn.itcast.note.utils;

import android.net.Uri;

public class Uris {

	public  static final Uri AUTHORITY =Uri.parse("content://cn.itcast.note.provider.MyProvider");
	public  static final Uri QUERY =Uri.parse("content://cn.itcast.note.provider.Myprovider/note/query");
	public  static final Uri DELETE =Uri.parse("content://cn.itcast.note.provider.Myprovider/note/delete");
	public  static final Uri INSERT =Uri.parse("content://cn.itcast.note.provider.Myprovider/note/insert");
	public  static final Uri UPDATE =Uri.parse("content://cn.itcast.note.provider.Myprovider/note/update");
}
