package nessit.edu.xmlandfirebase;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by Android2017 on 6/9/2017.
 */


//Registered in the manifest tag in the name attribute.
//Init stuff once for an app.
public class AppManager extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Font Awesome fa_android
        //http://fontawesome.io/cheatsheet/
        TypefaceProvider.registerDefaultIconSets();
    }
}
