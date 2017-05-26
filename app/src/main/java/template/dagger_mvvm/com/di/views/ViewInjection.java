package template.dagger_mvvm.com.di.views;

import android.util.Log;
import android.view.ViewParent;
import dagger.android.AndroidInjector;
import template.dagger_mvvm.com.ui._base.BaseActivity;
import template.dagger_mvvm.com.ui._base.BaseView;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by pedrogloria on 22/05/17 .
 */

public final class ViewInjection {

    private static final String TAG = "di.views";

    public static void inject(BaseView baseView) {
        checkNotNull(baseView, "view");
        HasViewInjector hasViewInjector = findHasViewInjector(baseView);
        Log.d(TAG,
              String.format(
                    "An injector for %s was found in %s",
                    baseView.getClass().getCanonicalName(),
                    hasViewInjector.getClass().getCanonicalName()));

        AndroidInjector<BaseView> viewInjector = hasViewInjector.viewInjector();
        checkNotNull(
              viewInjector,
              "%s.viewInjector() returned null",
              viewInjector.getClass().getCanonicalName());

        viewInjector.inject(baseView);
    }

    private static HasViewInjector findHasViewInjector(BaseView baseView) {
        ViewParent parentView = baseView;
        while ((parentView = parentView.getParent()) != null) {
            if (parentView instanceof HasViewInjector) {
                return (HasViewInjector) baseView;
            }
        }

        BaseActivity baseActivity = (BaseActivity) baseView.getContext();
        if (baseActivity != null) {
            return baseActivity;
        }
        throw new IllegalArgumentException(
              String.format("No injector was found for %s",
                    baseView.getClass().getCanonicalName()));
    }

    private ViewInjection() {
    }
}
