package com.example.smarthomeapp.divisions;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.smarthomeapp.R;
import com.example.smarthomeapp.BaseFragment;
import com.example.smarthomeapp.SmartHomeApplication;
import com.example.smarthomeapp.util.DummyData;
import com.example.utils.domain.Division;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DivisionsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DivisionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DivisionsFragment extends BaseFragment implements DivisionsContract.View{

    private DivisionsContract.Presenter mDivisionsPresenter;

    private DivisionsAdapter mDivisionsAdapter;

    /**
     * Views
     */
    @BindView(R.id.divisions_grid_view)
    GridView divisionsGridView;

    @BindView(R.id.divisions_view)
    View mDivisionsView;

    @BindView(R.id.no_divisions_view)
    View mNoDivisionsView;

    private OnFragmentInteractionListener mListener;

    public DivisionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DivisionsFragment.
     */
    public static DivisionsFragment newInstance() {
        DivisionsFragment fragment = new DivisionsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the presenter
        mDivisionsPresenter = new DivisionsPresenter(this);

        mDivisionsAdapter = new DivisionsAdapter(getContext(), new ArrayList<Division>(0));

    }

    @Override
    public void onResume() {
        super.onResume();
        mDivisionsPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_divisions, container, false);
        ButterKnife.bind(this, view);

        divisionsGridView.setAdapter(mDivisionsAdapter);

        divisionsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getContext(), "Room", Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setPresenter(@NonNull DivisionsContract.Presenter presenter) {
        mDivisionsPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showDivisions(List<Division> tasks) {

        mDivisionsAdapter.replaceData(tasks);

        mDivisionsView.setVisibility(View.VISIBLE);
        mNoDivisionsView.setVisibility(View.GONE);
    }

    @Override
    public void showDivisionDevicesUi(String divisionId) {
//        replaceFragment(DivisionsFragment.newInstance(), R.string.menu_events);
    }

    @Override
    public void showNoDivisions() {
        mDivisionsView.setVisibility(View.GONE);
        mNoDivisionsView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
