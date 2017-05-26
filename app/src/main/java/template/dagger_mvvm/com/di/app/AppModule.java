package template.dagger_mvvm.com.di.app;

import android.app.Application;
import android.content.Context;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import template.dagger_mvvm.com.ui.AndroidApplication;
import template.dagger_mvvm.com.ui.helpers.resources.AndroidResources;
import template.dagger_mvvm.com.ui.helpers.resources.ResourceProvider;

@Module abstract class AppModule {

    @Binds abstract Application application(AndroidApplication application);

    @Provides @Singleton static Context providesContext(Application application) {
        return application;
    }

    @Provides @Singleton static ResourceProvider provideResourceProvider(Context context) {
        return new AndroidResources(context);
    }
}
