package template.dagger_mvvm.com.ui.helpers.resources;

import android.support.annotation.StringRes;

/**
 * Created by pedrogloria on 26/05/17 .
 */

public interface ResourceProvider {

    String getString(@StringRes int textId);
}
