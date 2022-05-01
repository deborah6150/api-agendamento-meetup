package com.womakerscode.microservicemeetup.agendamentomeetup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis( RequestHandlerSelectors.basePackage("com.womakerscode.microservicemeetup.agendamentomeetup") )
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Meetups API")
                .description("RestApi de meetup produzida no bootcamp de Java da Womakerscode")
                .version("1.0")
                .contact(contact())
                .build();
    }

    private Contact contact() {
        return new Contact("Deborah Caroline Rodrigues Oliveira",
        		"https://github.com/deborah6150/api-agendamento-meetup/",
        		"deborahcaroline615@gmail.com");
    }
}

//package com.womakerscode.microservicemeetup.agendamentomeetup.config;
//
//import java.util.ArrayList;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.VendorExtension;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//	@Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.womakerscode.microservicemeetup.agendamentomeetup"))
//                .paths(regex("/api.*"))
//                .build()
//                .apiInfo(metaInfo());
//    }
//
//    private ApiInfo metaInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Meetups API",
//                "O objetivo é que desenvolver um serviço HTTP resolvendo a funcionalidade de Meetup.\n" +
//                        " Esse serviço atende aos seguintes requisitos:\n" +
//                		"- Cadastrar um Meetup" +
//                        "- Cadastrar um Registration no Meetup;\n" +
//                        "- Remover um Rigistration;\n" +
//                        "- Consultar todos os dados Rigistration;\n" +
//                        "- Consultar se um determinado registration",
//                "1.1",
//                "Terms od Service",
//                new Contact("Deborah Caroline ", "https://github.com/deborah6150/api-agendamento-meetup/", "deborahcaroline615@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html",
//                new ArrayList<VendorExtension>()
//        );
//    return apiInfo;
//    }
//}
