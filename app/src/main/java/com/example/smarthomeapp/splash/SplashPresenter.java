package com.example.smarthomeapp.splash;

import android.support.annotation.NonNull;

import com.example.utils.domain.HomeConfigEntity;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class SplashPresenter implements SplashScreenContract.Presenter {

    private final SplashScreenContract.View mSplashView;

    public SplashPresenter(@NonNull SplashScreenContract.View splashView) {

        mSplashView = splashView;

        mSplashView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void loadHouseConfiguration(HomeConfigEntity homeConfigEntity) {
        mSplashView.showHouseConfigResult(homeConfigEntity);
    }

    @Override
    public void cancelHouseConfigLoadTask() {
        mSplashView.cancelLoadAsyncTask();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }
}
