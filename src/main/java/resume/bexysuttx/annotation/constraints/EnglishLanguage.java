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

import resume.bexysuttx.validator.EnglishLanguageConstraintValidator;

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
