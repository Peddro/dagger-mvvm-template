package template.dagger_mvvm.com.ui;

import android.app.Activity;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;
import template.dagger_mvvm.com.di.app.DaggerAppComponent;

public class AndroidApplication extends DaggerApplication {

    @Inject DispatchingAndroidInjector<Activity> activityInjector;

    @Override public void onCreate() {
        super.onCreate();
    }

    @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
