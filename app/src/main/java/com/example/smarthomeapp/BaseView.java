package com.example.smarthomeapp;

/**
 * Created by isabelcosta on 05-May-17.
 */

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}
