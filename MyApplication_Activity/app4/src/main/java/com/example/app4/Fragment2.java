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
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    private View view;
    private TextView tv_name, tv_pass;

    private String name = null;
    private String pass = null;

    MainActivity mainActivity;
    private Context mContext;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (MainActivity)getActivity();
        view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        mContext = getActivity();
        findView();
        if (onCheck()==1){
            setTvText();
        }
        else {
            onOpenAlertDialog();
        }

        return view;
    }

    private void onOpenAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                .setTitle("检查判断")
                .setMessage("您没有登录，请登录后再查看！")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void setTvText(){
        tv_name.setText("用户名："+name);
        tv_pass.setText("密码："+pass);
    }

    private int onCheck(){
        try {
            if (mainActivity.getName()==null && mainActivity.getPass()==null) {
                return 0;
            }
            else {
                name = mainActivity.getName();
                pass = mainActivity.getPass();
                return 1;
            }
        } catch (NullPointerException e) {

            return 0;
        }
    }

    private void findView(){
        tv_name = view.findViewById(R.id.tv_name);
        tv_pass = view.findViewById(R.id.tv_pass);
    }

}
