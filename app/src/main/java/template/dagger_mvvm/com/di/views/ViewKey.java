package template.dagger_mvvm.com.di.views;

import template.dagger_mvvm.com.ui._base.BaseView;
import dagger.MapKey;

/**
 * Created by pedrogloria on 23/05/17 .
 */

@MapKey @interface ViewKey {
    Class<? extends BaseView> value();
}
