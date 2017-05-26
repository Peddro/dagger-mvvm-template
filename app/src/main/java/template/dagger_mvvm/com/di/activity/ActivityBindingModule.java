package template.dagger_mvvm.com.di.activity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import template.dagger_mvvm.com.ui.main.MainActivity;
import template.dagger_mvvm.com.ui.main.MainModule;

/**
 * Created by pedrogloria on 08/05/17 .
 */

@Module public abstract class ActivityBindingModule {

    @ActivityScope @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();

}
