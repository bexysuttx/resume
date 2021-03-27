package resume.bexysuttx.annotation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = {})
public @interface FirstFieldLessThenSecond {
	
	String message() default "FirstFieldLessThenSecond";
	
	Class<? extends Payload>[] payload() default { };
	
	Class<?>[] groups() default { };
	
	String first();
	
	String second();
	
	@Documented
	@Retention(RUNTIME)
	@Target({TYPE, ANNOTATION_TYPE})
	@interface List {
		FirstFieldLessThenSecond[] value();
	}
	

}
