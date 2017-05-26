package template.dagger_mvvm.com.ui.views;

import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import template.dagger_mvvm.com.di.views.ViewModule;

/**
 * Created by pedrogloria on 26/05/17 .
 */
@Subcomponent(modules = MyCustomViewSubcomponent.MyCustomViewModule.class)
public interface MyCustomViewSubcomponent extends AndroidInjector<MyCustomView> {

    @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<MyCustomView> {
    }

    @Module abstract class MyCustomViewModule extends ViewModule<MyCustomView> {
        MyCustomViewModule(MyCustomView myCustomView) {
            super(myCustomView);
        }
    }
}
