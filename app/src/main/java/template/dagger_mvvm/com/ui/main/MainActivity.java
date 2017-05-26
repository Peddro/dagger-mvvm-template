package template.dagger_mvvm.com.ui.main;

import android.widget.Toast;
import template.dagger_mvvm.com.R;
import template.dagger_mvvm.com.databinding.ActivityMainBinding;
import template.dagger_mvvm.com.ui._base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
      implements MainMvvm.View {

    @Override protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override protected void initializeBinding(ActivityMainBinding binding) {
        binding.setViewModel(getViewModel());
        getViewModel().initializeWith(this);
    }

    @Override public void buttonWasPressed() {
        Toast.makeText(this, "I WAS CLICKED!!!", Toast.LENGTH_LONG).show();
    }
}
