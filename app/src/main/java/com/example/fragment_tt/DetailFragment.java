package com.example.fragment_tt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    public static final String TAG = DetailFragment.class.getName();

    private TextView tv_name;
    private Button btn_back;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        tv_name = view.findViewById(R.id.tv_name);
        btn_back = view.findViewById(R.id.btn_back);


        Bundle bundleReceive = getArguments();
        if (bundleReceive != null) {
            User user = (User) bundleReceive.get("object_user");
            if (user != null) {
                tv_name.setText(user.getName());
            }
        }
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getFragmentManager()!=null){
                    getFragmentManager().popBackStack();
                }
            }
        });


        return view;
    }
}