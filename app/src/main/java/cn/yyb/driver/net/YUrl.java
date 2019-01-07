package cn.yyb.driver.net;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * retrofit接口注解
 */
@Documented
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface YUrl {
    /**
     * @return 对应的url
     */
    UrlEnum value();

}
