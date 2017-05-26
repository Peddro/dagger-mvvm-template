package template.dagger_mvvm.com.ui.helpers.resources;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * Created by pedrogloria on 26/05/17 .
 */

public class AndroidResources implements ResourceProvider {

    private final Context context;

    public AndroidResources(Context context) {
        this.context = context;
    }

    @Override public String getString(@StringRes int textId) {
        return context.getString(textId);
    }
}
