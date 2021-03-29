package resume.bexysuttx.annotation.constraints;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = {})
public @interface FieldMatch {

	String message() default "FieldMatch";

	Class<? extends Payload>[] payload() default {};

	Class<?>[] groups() default {};

	String first();

	String second();

	@Documented
	@Retention(RUNTIME)
	@Target({ ElementType.TYPE, ANNOTATION_TYPE })
	@interface List {
		FieldMatch[] value();
	}

}
   