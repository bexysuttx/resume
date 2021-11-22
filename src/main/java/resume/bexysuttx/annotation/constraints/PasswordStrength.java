package resume.bexysuttx.annotation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
@Constraint(validatedBy = {})
@Size(min = 8)
@NotNull
@MinDigitCount
@MinLowerCharCount
@MinUpperCharCount
@MinSpecSymbolsCount

public @interface PasswordStrength {

	String message() default "FirstFieldLessThenSecond";

	Class<? extends Payload>[] payload() default {};

	Class<?>[] groups() default {};
}
