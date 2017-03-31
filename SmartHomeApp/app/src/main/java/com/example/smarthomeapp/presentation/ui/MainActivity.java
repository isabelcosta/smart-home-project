package com.example.smarthomeapp.presentation.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

import com.example.smarthomeapp.R;
import com.example.smarthomeapp.util.ActivityUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    @BindView(R.id.bottom_navigation_bar)
    BottomBar bottomBarView;

    @BindView(R.id.content_frame)
    View fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListeners();

//        if (savedInstanceState == null) {
//            Fragment newFragment = DivisionsFragment.newInstance(null, null);
//            FragmentTransaction ft = getFragmentManager().beginTransaction();
//            ft.add(CONTENT_VIEW_ID, newFragment).commit();
//        }
    }

    @Override
    protected int getContentViewId(){
        return R.layout.activity_main;
    }
    public void setListeners(){
        bottomBarView.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                switch(tabId) {
                    case R.id.tab_overview:
                        replaceFragment(DivisionsFragment.newInstance(), R.string.menu_overview);
                        break;
                    case R.id.tab_divisions:
                        Toast.makeText(MainActivity.this, "Hey How", Toast.LENGTH_LONG).show();
                        replaceFragment(DivisionsFragment.newInstance(), R.string.menu_divisions);
                        break;
                    case R.id.tab_events:
                        replaceFragment(DivisionsFragment.newInstance(), R.string.menu_events);
                        break;
                    case R.id.tab_control:
                        replaceFragment(DivisionsFragment.newInstance(), R.string.menu_control);
                        break;
                    case R.id.tab_settings:
                        replaceFragment(DivisionsFragment.newInstance(), R.string.menu_settings);
                        break;
                }
            }
        });
    }

    public void replaceFragment(BaseFragment fragmentToReplace, int titleResId){

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle(titleResId);
        }
        if (fragmentToReplace != null) {
            ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), fragmentToReplace, R.id.content_frame);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
