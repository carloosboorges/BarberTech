package dev.borges.BarberTech.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CPFValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface CPF {

    String message() default "CPF inválido";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
