package edu.hm.renderer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to state that this field or method should be rendered.
 * It is applicable for fields and idempotent methods without parameters (like getters)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface RenderMe {

    /**
     * The class to render with. This is mainly useful for non-primitive data types.
     * @return the class to render with or empty string to use default
     */
    String with() default "";

}
