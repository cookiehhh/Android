package com.example.app_fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Dell on 2019/10/24.
 */

public class ContentFargment extends Fragment {

    private View view;
    private TextView mContent;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_content,container,false);
        if (view != null){
            initView();
        }
        setText(((MainActivity)getActivity()).getSettingText()[0]);

        return view;
    }

    public void initView(){
        mContent = view.findViewById(R.id.content);
    }
    public void setText(String text){
        mContent.setText(text);
    }
}
