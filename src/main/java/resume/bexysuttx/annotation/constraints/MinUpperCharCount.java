package resume.bexysuttx.annotation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
@Constraint(validatedBy = {})
public @interface MinUpperCharCount {

	int value() default 1;

	String message() default "MinUpperCharCount";

	Class<? extends Payload>[] payload() default {};
	
	Class<?>[] groups() default { };

}
