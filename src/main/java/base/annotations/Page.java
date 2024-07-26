package base.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Scope=prototype results in new Page creation every time getBean() called
*/
@Target(TYPE)
@Retention(RUNTIME)
@Component
@Scope("prototype")
public @interface Page {
}