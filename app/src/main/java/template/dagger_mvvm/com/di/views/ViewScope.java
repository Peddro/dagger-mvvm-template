package template.dagger_mvvm.com.di.views;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by pedrogloria on 23/05/17 .
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface ViewScope {}
