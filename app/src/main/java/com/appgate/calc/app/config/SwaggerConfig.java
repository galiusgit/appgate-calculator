package com.appgate.calc.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Custom docket.
	 *
	 * @return the docket
	 */
	@Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant(ApiVersion.V1 + "/**"))
                .build()
                .apiInfo(apiInfo());
        
    }

    /**
     * Api info.
     *
     * @return the api info
     */
    private ApiInfo apiInfo() {
    	Contact contact = new Contact(
		 "Jorge Luis Romero Castañeda",
		 "linkedin.com/in/jorge-luisromero-castañeda-04791167", 
		 "jorgeromen27@gmail.com"
    	);
    	@SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();
        return new ApiInfo(
                "Appgate calculator API",
                "The application provides tools to evaluate arithmetic operations (session calculator)",
                "Appgate calculator API v1",
                "Terms of service Appgate calc",
                contact,
                "License of API",
                "https://swagger.io/docs/", 
                vendorExtensions);
    }
    
}
