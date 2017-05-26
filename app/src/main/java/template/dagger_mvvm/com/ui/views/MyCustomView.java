package template.dagger_mvvm.com.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import template.dagger_mvvm.com.R;
import template.dagger_mvvm.com.databinding.ViewMyCustomBinding;
import template.dagger_mvvm.com.ui._base.BaseView;

/**
 * Created by pedrogloria on 26/05/17 .
 */

public class MyCustomView extends BaseView<ViewMyCustomBinding, MyCustomViewModel> {

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected int layoutId() {
        return R.layout.view_my_custom;
    }

    @Override protected void initializeBinding(ViewMyCustomBinding binding) {
        binding.setViewModel(getViewModel());
    }
}
