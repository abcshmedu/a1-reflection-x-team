package edu.hm.cs.swa.projekt_1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {

	String with() default "";
}
