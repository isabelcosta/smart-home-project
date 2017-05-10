package com.example.smarthomeapp.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smarthomeapp.BaseFragment;
import com.example.smarthomeapp.MainActivity;
import com.example.smarthomeapp.R;
import com.example.smarthomeapp.login.LoginActivity;
import com.example.smarthomeapp.util.Constants;
import com.example.smarthomeapp.util.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SettingsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends BaseFragment {

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.log_out_selectable_area)
    View mLogOutButton;

    public SettingsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);

        mLogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLoginData();

                Intent mainIntent = new Intent(getContext(), LoginActivity.class);

                /* Create an Intent that will start the Home Activity. */
                SettingsFragment.this.startActivity(mainIntent);
                getActivity().finish();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private void removeLoginData(){
        SharedPreferencesUtils.setStringPreference(getContext(), Constants.Login.USER_ID, null);
        SharedPreferencesUtils.setBooleanPreference(getContext(), Constants.Login.IS_LOGGED, false);
    }
}
