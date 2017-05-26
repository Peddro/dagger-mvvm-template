package template.dagger_mvvm.com.ui.main;

import template.dagger_mvvm.com.ui._base.BaseMvvm;

/**
 * Created by pedrogloria on 06/01/17 .
 */

interface MainMvvm {

  interface View extends BaseMvvm.View {
    void buttonWasPressed();
  }
}
