package id.my.hendisantika.springbootelasticsearchdemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 08:59
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDescription, @Value("${application" +
            "-version}") String appVersion) {
        Contact contact = new Contact();
        contact.setEmail("hendisantika@yahoo.co.id");
        contact.setName("HENDI SANTIKA");
        contact.setUrl("https://s.id/hendisantika");
        return new OpenAPI()
                .info(new Info()
                        .title("Microservice Base Service Application API")
                        .version(appVersion)
                        .description(appDescription)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org"))
                        .contact(contact)
                );

    }


    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Spring Data Elasticsearch example")
                .description("Spring Data Elasticsearch example with Testcontainers")
                .version("v0.0.2")
                .contact(getContactDetails())
                .license(getLicenseDetails()));
    }

    private Contact getContactDetails() {
        return new Contact().name("Hendi Santika")
                .email("hendisantika@yahoo.co.id")
                .url("https://s.id/hendisantika");
    }

    private License getLicenseDetails() {
        return new License().name("GNU General Public License v3.0")
                .url("https://springdoc.org");
    }
}
