package resume.bexysuttx.annotation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
		ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface Adulthood {

	String message()

	default "Adulthood";

	int adulthoodAge()

	default 18;

	Class<? extends Payload>[] payload() default { };

	Class<?>[] groups() default { };
	

}
