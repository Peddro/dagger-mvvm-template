package template.dagger_mvvm.com.ui._base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import template.dagger_mvvm.com.di.views.HasViewInjector;

public abstract class BaseActivity<VDB extends ViewDataBinding, VM extends BaseViewModel>
      extends AppCompatActivity implements HasViewInjector {

    @LayoutRes protected abstract int layoutId();

    protected abstract void initializeBinding(VDB binding);

    protected VDB binding;

    @Inject DispatchingAndroidInjector<BaseView> viewInjector;

    @Inject VM viewModel;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setupBinding(DataBindingUtil.setContentView(this, layoutId()));
    }

    @Override protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    private void setupBinding(VDB binding) {
        this.binding = binding;
        initializeBinding(binding);
    }

    public final VM getViewModel() {
        return viewModel;
    }

    @Override public void onDetachedFromWindow() {
        viewModel.unbind();
        super.onDetachedFromWindow();
    }

    //<editor-fold desc="Observables">
    public final void addDisposable(Disposable d) {
        compositeDisposable.add(d);
    }
    //</editor-fold>

    @Override public AndroidInjector<BaseView> viewInjector() {
        return viewInjector;
    }
}
