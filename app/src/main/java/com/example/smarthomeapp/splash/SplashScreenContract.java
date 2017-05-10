package com.example.smarthomeapp.splash;

import com.example.smarthomeapp.BaseView;
import com.example.smarthomeapp.HouseConfigLoadPresenter;
import com.example.smarthomeapp.login.LoginContract;
import com.example.utils.domain.HomeConfigEntity;

/**
 * Created by isabelcosta on 10-May-17.
 */

public interface SplashScreenContract {

    int MAIN_SCREEN = 1;
    int LOGIN = 2;

    interface View extends BaseView<SplashScreenContract.Presenter> {

        void setLoadingIndicator(boolean active);

        void showHouseConfigResult(HomeConfigEntity homeConfigEntity);

        void cancelLoadAsyncTask();

        boolean isActive();

        void enterMainScreen(int screenToGoTo);

    }

    interface Presenter extends HouseConfigLoadPresenter {

        void result(int requestCode, int resultCode);
    }
}
