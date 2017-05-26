package template.dagger_mvvm.com.di.views;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import template.dagger_mvvm.com.ui._base.BaseView;
import template.dagger_mvvm.com.ui.views.MyCustomView;
import template.dagger_mvvm.com.ui.views.MyCustomViewSubcomponent;

/**
 * Created by pedrogloria on 23/05/17 .
 */

@Module(subcomponents = MyCustomViewSubcomponent.class)
public abstract class ViewBindingModule {

    @Binds @IntoMap @ViewKey(MyCustomView.class)
    abstract AndroidInjector.Factory<? extends BaseView> myCustomViewInjector(
          MyCustomViewSubcomponent.Builder builder);
}
