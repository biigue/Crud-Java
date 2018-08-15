package br.ufrpe.bsi.bianca.crudjava.infra;

import android.app.Application;
import android.content.Context;

/**
 * Created by gabri on 23/01/2018.
 * Necessário alterar o atributo android:name da tag application do AndroidManifest.xml
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}