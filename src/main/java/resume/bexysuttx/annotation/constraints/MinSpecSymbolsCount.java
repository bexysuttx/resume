package resume.bexysuttx.annotation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
@Constraint(validatedBy = {})
public @interface MinSpecSymbolsCount {
	
	String value() default "~#$%^&*-+=_\\\\|/@`!'\\\";:><,.?{}";
	
	String message() default "MinSpecSymbolsCount";
	
	Class<? extends Payload>[] payload() default { };
	
	Class<?>[] groups() default { };
	
}
