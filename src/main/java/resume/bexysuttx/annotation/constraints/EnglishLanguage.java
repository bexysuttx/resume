package resume.bexysuttx.annotation.constraints;

import resume.bexysuttx.validator.EnglishLanguageConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ ANNOTATION_TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR })
@Constraint(validatedBy = {EnglishLanguageConstraintValidator.class})
public @interface EnglishLanguage {
	
	String message() default "EnglishLanguage";
	
	//0123456789
	boolean withNumbers() default true;
	//.,?!(){}[]'"-:; \t\n
	boolean withPunctuations() default true;
	
	//~#$%^&*-+=_\\|/@`!'\";:><,.?{}
	boolean withSpechSymbols() default true;
	
	Class<? extends Payload>[] payload() default  { };
	
	Class<?>[] groups() default {  };

}
