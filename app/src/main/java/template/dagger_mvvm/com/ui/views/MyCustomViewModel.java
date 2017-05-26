package template.dagger_mvvm.com.ui.views;

import javax.inject.Inject;
import template.dagger_mvvm.com.R;
import template.dagger_mvvm.com.ui._base.BaseViewModel;
import template.dagger_mvvm.com.ui.helpers.resources.ResourceProvider;

/**
 * Created by pedrogloria on 26/05/17 .
 */

public class MyCustomViewModel extends BaseViewModel {

    private final ResourceProvider resourceProvider;

    @Inject MyCustomViewModel(ResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    public String getText() {
        return resourceProvider.getString(R.string.provided_string);
    }
}
