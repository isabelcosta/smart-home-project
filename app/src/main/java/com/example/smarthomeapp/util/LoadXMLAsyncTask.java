package com.example.smarthomeapp.util;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.example.smarthomeapp.HouseConfigLoadPresenter;
import com.example.smarthomeapp.app.SmartHomeApplication;
import com.example.smarthomeapp.login.LoginActivity;
import com.example.utils.DomoBusConfigLoader;
import com.example.utils.domain.HomeConfigEntity;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

import static com.example.smarthomeapp.util.Constants.XML_FILE_TO_LOAD;

/**
 * Created by isabelcosta on 10-May-17.
 *
 * Represents an asynchronous load house configuration task used to build the
 * structure of the house.
 */

public class LoadXMLAsyncTask extends AsyncTask<Void, Void, HomeConfigEntity> {

    private HomeConfigEntity mHomeConfig;
    private HouseConfigLoadPresenter mPresenter;
    private Context mContext;

    public LoadXMLAsyncTask(Context context, HouseConfigLoadPresenter presenter) {
        mContext = context;
        mPresenter = presenter;
    }

    @Override
    protected HomeConfigEntity doInBackground(Void... params) {

        try {
            // Simulate file access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return null;
        }

        Document document;
        try {

            // TODO: 05-May-17 reading HARDCODED house configuration file
            InputStream is = mContext.getResources().openRawResource(XML_FILE_TO_LOAD);

            SAXReader reader = new SAXReader();
            document = reader.read(is);

        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }

        if (document != null) {
            DomoBusConfigLoader domoBusLoader = new DomoBusConfigLoader(document);
            mHomeConfig = domoBusLoader.getHomeConfig();
        }

        return mHomeConfig;
    }

    @Override
    protected void onPostExecute(final HomeConfigEntity homeConfigEntity) {
        mPresenter.loadHouseConfiguration(mHomeConfig);
    }

    @Override
    protected void onCancelled() {
        mPresenter.cancelHouseConfigLoadTask();
    }
}
