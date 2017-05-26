package template.dagger_mvvm.com.ui.main;

import javax.inject.Inject;
import template.dagger_mvvm.com.ui._base.BaseViewModel;

public class MainViewModel extends BaseViewModel<MainMvvm.View> {

    @Inject MainViewModel() {
    }

    public void onClick() {
        getView().buttonWasPressed();
    }
}
