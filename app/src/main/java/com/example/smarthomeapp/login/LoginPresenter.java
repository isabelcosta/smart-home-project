package com.example.smarthomeapp.login;

import android.support.annotation.NonNull;

import com.example.utils.domain.HomeConfigEntity;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View mLoginView;

    public LoginPresenter(@NonNull LoginContract.View loginView) {

        mLoginView = loginView;

        mLoginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void loadHouseConfiguration(HomeConfigEntity homeConfigEntity) {
        mLoginView.showHouseConfigResult(homeConfigEntity);
    }

    @Override
    public void cancelHouseConfigLoadTask() {
        mLoginView.cancelLoadAsyncTask();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }
}
