package cn.itcast.note;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import cn.itcast.note.bean.Note;
import cn.itcast.note.utils.Uris;

public class MainActivity extends Activity implements OnClickListener {

	/** ������ʾ����ӱ�ǩ��ListView */
	private ListView mNoteListView;
	private ContentResolver contentResolver;
	private List<Note> mNotes = new ArrayList<Note>();
	private static final String TITLE = "note_title";
	private static final String CONTENT = "note_content";
	private static final String DATE = "date";
	private static final String ID = "_id";
	private ArrayAdapter<Note> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contentResolver = getContentResolver();
		initView();
		searchData();
		contentResolver.registerContentObserver(Uris.AUTHORITY, true,
				new ContentObserver(new Handler()) {
					@Override
					public void onChange(boolean selfChange) {
						super.onChange(selfChange);
						mNotes.clear();
						searchData();
					}
				});
	}
	
	

	/** ������� */
	private void searchData() {
		Cursor cursor = contentResolver.query(Uris.QUERY, null, null, null,
				null);
		if (cursor != null) {
			if (cursor.getCount() >= 1) {
				while (cursor.moveToNext()) {
					final Note note = new Note();
					note.title = cursor.getString(cursor.getColumnIndex(TITLE));
					note.id = cursor.getInt(cursor.getColumnIndex(ID));
					note.content = cursor.getString(cursor
							.getColumnIndex(CONTENT));
					note.date = cursor.getString(cursor.getColumnIndex(DATE));
					mNotes.add(note);
				}
			}
			if(adapter != null){
				adapter.notifyDataSetChanged();
			}
		}
	}

	/** ��ʼ���ؼ� */
	private void initView() {
		findViewById(R.id.imgv_addnote).setOnClickListener(this);
		mNoteListView = (ListView) findViewById(R.id.lv_notes);
			adapter = new ArrayAdapter<Note>(this, R.layout.list_item,
					R.id.tv_content, mNotes);
			mNoteListView.setAdapter(adapter);
		mNoteListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(MainActivity.this,
						AddNoteActivity.class);
				intent.putExtra("mode", 1);
				intent.putExtra("note", mNotes.get(position));
				startActivity(intent);
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imgv_addnote:
			Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
			intent.putExtra("mode", 2);
			startActivity(intent);
			break;
		}
	}
}
