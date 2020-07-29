package com.example.app4;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    private View view;
    private EditText et_name, et_pass;
    private Button btn_open;

    private String name = null;
    private String pass = null;

    MainActivity mainActivity;
    private Context mContext;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (MainActivity)getActivity();
        view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        mContext = getActivity();
        findView();
        setListener();


        return view;
    }

    private void setListener(){
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEtText();
                if (onCheck()==1){
                    Log.i("Main123", "onClick: name:"+name);
                    mainActivity.setName(name);
                    mainActivity.setPass(pass);
                    onTrueAlertDialog();
                }
                else {
                    onFalseAlertDialog();
                    Log.i("Main123", "onClick: mes:"+mainActivity.getMes());
                }
            }
        });
    }

    private void onTrueAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                .setTitle("登录判断")
                .setMessage("恭喜你！登录成功，可以查看个人信息啦！")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void onFalseAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                .setTitle("登录判断")
                .setMessage("登录失败！请重新登录")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void getEtText(){
        name = et_name.getText().toString();
        pass = et_pass.getText().toString();
    }

    private int onCheck(){
        if ("admin".equals(name)&&"123456".equals(pass)){
            return 1;
        }else {
            return 0;
        }
    }

    private void findView(){
        et_name = view.findViewById(R.id.et_name);
        et_pass = view.findViewById(R.id.et_pass);
        btn_open = view.findViewById(R.id.btn_open);
    }

}
