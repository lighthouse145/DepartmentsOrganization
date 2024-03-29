package altarix.test.departments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("altarix.test.departments"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Управление организационно-штатной структурой компании",
                "Компания представляет собой древовидную структуру неограниченной глубины, состоящую из департаментов.\n\r" +
                        " За каждым департаментом закреплены сотрудники. Сотрудник может числиться только в одном департаменте.\n\r" +
                        " У каждого департамента есть руководитель из числа сотрудников департамента.",
                "1.0",
                "",
                "",
                "",
                ""
        );
    }
}
