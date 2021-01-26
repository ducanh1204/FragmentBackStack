package com.example.fragment_tt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rcv_user;
    private View view;
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.fragment_home, container, false);

        rcv_user = view.findViewById(R.id.rcv_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        rcv_user.setLayoutManager(linearLayoutManager);

        UserAdapter userAdapter = new UserAdapter(getListUser(), new UserAdapter.IClickItemListener() {
            @Override
            public void onClickItemUser(User user) {
                mainActivity.goToDetailFragment(user);
            }
        });
        rcv_user.setAdapter(userAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mainActivity, DividerItemDecoration.VERTICAL);
        rcv_user.addItemDecoration(itemDecoration);


        return view;
    }

    private List<User> getListUser() {
        List<User> users = new ArrayList<>();

        for (int i = 0; i <= 20; i++) {
            users.add(new User("This is user " + i));
        }
        return users;
    }

}