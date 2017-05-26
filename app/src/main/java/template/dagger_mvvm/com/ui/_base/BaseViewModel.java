package template.dagger_mvvm.com.ui._base;

import android.databinding.BaseObservable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by pedrogloria on 06/02/17 .
 */

public abstract class BaseViewModel<V extends BaseMvvm.View> extends BaseObservable {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private V view;

    public void initializeWith(V view) {
        this.view = view;
        onStart();
    }

    void unbind() {
        onStop();
        compositeDisposable.clear();
    }

    public void onStart() {
        // To override if needed
    }

    public void onStop() {
        // To override if needed
    }

    protected V getView() {
        if (view == null) {
            throw new IllegalArgumentException("You must initialize your view callback");
        }
        return view;
    }

    public final void addDisposable(Disposable d) {
        compositeDisposable.add(d);
    }
}