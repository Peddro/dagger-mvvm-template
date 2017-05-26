package template.dagger_mvvm.com.di.views;

import dagger.android.AndroidInjector;
import template.dagger_mvvm.com.ui._base.BaseView;

/**
 * Created by pedrogloria on 22/05/17 .
 */

public interface HasViewInjector {

    /** Returns an {@link AndroidInjector} of {@link BaseView}s. */
    AndroidInjector<BaseView> viewInjector();
}
