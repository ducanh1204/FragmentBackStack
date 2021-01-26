package com.example.fragment_tt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_frame,new HomeFragment());
        fragmentTransaction.commit();

    }

    public void goToDetailFragment(User user){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        DetailFragment detailFragment = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user",user);
        detailFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.content_frame,detailFragment);
        fragmentTransaction.addToBackStack(DetailFragment.TAG);
        fragmentTransaction.commit();

    }
}