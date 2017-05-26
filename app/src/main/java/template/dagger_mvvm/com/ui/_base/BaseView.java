package template.dagger_mvvm.com.ui._base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import template.dagger_mvvm.com.di.views.ViewInjection;

/**
 * Created by pedrogloria on 26/05/17 .
 */

public abstract class BaseView<VDB extends ViewDataBinding, VM extends BaseViewModel>
      extends FrameLayout {

    @LayoutRes protected abstract int layoutId();

    //protected abstract void inject();

    protected abstract void initializeBinding(VDB binding);

    private VDB binding;
    @Inject VM viewModel;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (isInEditMode()) {
            inflate(context, layoutId(), this);
            return;
        }

        ViewInjection.inject(this);
        setupBinding(
              DataBindingUtil.inflate(LayoutInflater.from(context), layoutId(), this, true));
    }

    @SuppressWarnings("unchecked") private void setupBinding(VDB binding) {
        this.binding = binding;
        initializeBinding(binding);
        initializeView();
    }

    public void initializeView() {
        // To override if needed
    }

    public VDB getBinding() {
        return binding;
    }

    public VM getViewModel() {
        return viewModel;
    }

    @Override public void onDetachedFromWindow() {
        compositeDisposable.clear();
        viewModel.unbind();
        super.onDetachedFromWindow();
    }

    public final void addDisposable(Disposable d) {
        compositeDisposable.add(d);
    }
}
