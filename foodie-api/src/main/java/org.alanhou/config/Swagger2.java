package org.alanhou.config;

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
public class Swagger2 {
    // 原文档地址：http://localhost:8088/swagger-ui.html
    // 自定义样式文档地址：http://localhost:8088/doc.html
    // 配置 swagger2核心配置 docket
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2) // 指定 api 类型为 swagger2
                .apiInfo( apiInfo())                   // 用于定义api 文档汇总信息
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("org.alanhou.controller")) // 指定 controller 包
                .paths(PathSelectors.any())            // 所有 controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台接口API")         // 文档页标题
                .contact(new Contact("Alan Hou",
                        "https://alanhou.org",
                        "i@alanhou.org"))         // 联系人信息
                .description("专为天天吃货提供的 API 文档") // 详细信息
                .version("1.0.1")                        // 文档版本号
                .termsOfServiceUrl("https:alanhou.org")  // 网站服务地址
                .build();
    }
}
