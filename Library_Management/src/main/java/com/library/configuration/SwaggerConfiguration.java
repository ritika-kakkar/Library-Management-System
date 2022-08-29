package com.library.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
	public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        			.select()
        			.apis(RequestHandlerSelectors.any())
        			.paths(PathSelectors.any())
        		    .build()
        			.directModelSubstitute(LocalDate.class, java.sql.Date.class)
        			.directModelSubstitute(LocalDateTime.class, java.util.Date.class)
        			.apiInfo(apiInfo());
        	}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Library Management System")
                .description("Students and Books Data")
                .build();
    }

}
