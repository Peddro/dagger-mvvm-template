package template.dagger_mvvm.com.di.app;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;
import template.dagger_mvvm.com.data.networking.NetworkModule;
import template.dagger_mvvm.com.di.activity.ActivityBindingModule;
import template.dagger_mvvm.com.di.views.ViewBindingModule;
import template.dagger_mvvm.com.ui.AndroidApplication;

@Component(modules = {AppModule.class, NetworkModule.class, AndroidSupportInjectionModule.class,
      ActivityBindingModule.class, ViewBindingModule.class})
@Singleton interface AppComponent extends AndroidInjector<AndroidApplication> {

    @Component.Builder abstract class Builder extends AndroidInjector.Builder<AndroidApplication> {
    }
}
