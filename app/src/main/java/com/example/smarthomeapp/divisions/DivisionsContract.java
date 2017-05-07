package com.example.smarthomeapp.divisions;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.BasePresenter;
import com.example.smarthomeapp.BaseView;
import com.example.utils.domain.Division;

import java.util.List;

/**
 * Created by isabelcosta on 05-May-17.
 */

public interface DivisionsContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showDivisions(List<Division> tasks);

        void showDivisionDevicesUi(String divisionId);

        void showNoDivisions();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadDivisions();

    }
}
