package cn.itcast.note;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.itcast.note.bean.Note;
import cn.itcast.note.utils.Uris;

/** ���������½�Note���޸�Note */
public class AddNoteActivity extends Activity implements OnClickListener {
	/** ��� trueΪ�޸�ģʽ��falseΪ���ģʽ */
	private boolean flags = false;
	private Note note;
	private EditText mTitleET;
	private EditText mContentET;
	private String time;
	private TextView mCreateTime;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);
		Intent intent = getIntent();
		int mode = intent.getIntExtra("mode", 0);
		if (mode != 1) {
			flags = false;
			Date date  = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			time = "����ʱ�䣺"+sd.format(date);
		} else {
			flags = true;
			note = (Note) intent.getSerializableExtra("note");
			time ="�ϴ��޸�ʱ�䣺 "+ note.date;
			
		}
		initView();
	}

	/** ��ʼ���ؼ� */
	private void initView() {
		findViewById(R.id.imgv_back).setOnClickListener(this);
		findViewById(R.id.imgv_ok).setOnClickListener(this);
		mCreateTime = (TextView) findViewById(R.id.tv_create_time);
		mCreateTime.setText(time);
		if (flags) {
			findViewById(R.id.imgv_delete).setOnClickListener(this);
		} else {
			findViewById(R.id.imgv_delete).setVisibility(View.GONE);
		}
		mTitleET = (EditText) findViewById(R.id.et_title);
		mContentET = (EditText) findViewById(R.id.et_content);
		if(note != null){
			mTitleET.setText(note.title);
			mContentET.setText(note.content);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imgv_back:
			finish();
			break;
		case R.id.imgv_delete:
			if (flags) {
				// �޸�ģʽ��ɾ��������¼����������ҳ��
				int id = getContentResolver().delete(Uris.DELETE, "_id=?",
						new String[] { note.id + "" });
				if (id == -1) {
					Toast.makeText(this, "ɾ��ʧ��", 0).show();
				} else {
					// ɾ���ɹ� �ص���ҳ��
					Toast.makeText(this, "ɾ���ɹ�", 0).show();
					finish();
				}
			}
			break;
		case R.id.imgv_ok:
			if (flags) {
				// �޸�ģʽ���޸Ĵ�������,��������ҳ��
				if (!TextUtils.isEmpty(mTitleET.getText().toString().trim())
						& !TextUtils.isEmpty(mContentET.getText().toString()
								.trim())) {
					ContentValues values = new ContentValues();
					values.put("note_title", mTitleET.getText().toString().trim());
					values.put("note_content", mContentET.getText().toString().trim());
					Date date  = new Date();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
					values.put("date",sd.format(date));
					int id = getContentResolver().update(Uris.UPDATE, values, "_id=?", new String[]{note.id+""});
					if(id !=-1){
						Toast.makeText(this, "�޸ĳɹ�", 0).show();
					}
					finish();
				}else{
					Toast.makeText(this, "��������ݲ���Ϊ��", 0).show();
				}
			} else {
				// ���ģʽ�����һ������
				if (!TextUtils.isEmpty(mTitleET.getText().toString().trim())
						& !TextUtils.isEmpty(mContentET.getText().toString()
								.trim())) {
					ContentValues values = new ContentValues();
					values.put("note_title", mTitleET.getText().toString().trim());
					values.put("note_content", mContentET.getText().toString().trim());
					Date date  = new Date();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
					values.put("date",sd.format(date));
					getContentResolver().insert(Uris.INSERT, values);
					finish();
				}else{
					Toast.makeText(this, "��������ݲ���Ϊ��", 0).show();
				}
			}
			break;
		}
	}
}
