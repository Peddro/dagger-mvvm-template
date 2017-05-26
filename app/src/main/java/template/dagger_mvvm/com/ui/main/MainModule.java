package template.dagger_mvvm.com.ui.main;

import android.app.Activity;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @Binds abstract Activity bindActivity(MainActivity activity);
}
