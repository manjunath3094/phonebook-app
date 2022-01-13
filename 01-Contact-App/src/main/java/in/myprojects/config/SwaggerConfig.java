package in.myprojects.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDocumentGeneration() {  // Docket is an object of Swagger that generates documentation
		return new Docket(DocumentationType.SWAGGER_2)
				.select()  //select api's of "in.myprojects.restcontroller"& generate Documentation of all restController classes
				.apis(RequestHandlerSelectors.basePackage("in.myprojects.restcontroller")) 
				.paths(PathSelectors.any())  // any() -i.e any request(post, get, delete etc)
				.build();
	}

}
