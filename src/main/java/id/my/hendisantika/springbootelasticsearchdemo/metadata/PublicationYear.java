package id.my.hendisantika.springbootelasticsearchdemo.metadata;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 09:12
 * To change this template use File | Settings | File Templates.
 */
@Documented
@Retention(RUNTIME)
@Target({FIELD, ANNOTATION_TYPE, PARAMETER})
@Constraint(validatedBy = PublicationYearValidator.class)
public @interface PublicationYear {

    String message() default "Publication year cannot be future year";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
