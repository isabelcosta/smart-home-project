package com.example.smarthomeapp.login;

import com.example.smarthomeapp.BasePresenter;
import com.example.smarthomeapp.BaseView;
import com.example.smarthomeapp.HouseConfigLoadPresenter;
import com.example.smarthomeapp.divisions.DivisionsContract;
import com.example.utils.domain.Division;
import com.example.utils.domain.HomeConfigEntity;

import java.util.List;

/**
 * Created by isabelcosta on 10-May-17.
 */

public interface LoginContract {

    interface View extends BaseView<LoginContract.Presenter> {

        void setLoadingIndicator(boolean active);

        void showHouseConfigResult(HomeConfigEntity homeConfigEntity);

        void cancelLoadAsyncTask();

        boolean isActive();

    }

    interface Presenter extends HouseConfigLoadPresenter {

        void result(int requestCode, int resultCode);
    }
}
