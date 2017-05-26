package template.dagger_mvvm.com.di.views;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pedrogloria on 23/05/17 .
 */

@Module public abstract class ViewModule<V> {

    protected final V view;

    public ViewModule(V view) {
        this.view = view;
    }

    @Provides @ViewScope V provideView() {
        return view;
    }
}
