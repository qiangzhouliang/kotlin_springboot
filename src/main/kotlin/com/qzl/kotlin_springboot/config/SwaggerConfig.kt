package com.qzl.kotlin_springboot.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @ClassName SwaggerConfig
 * @Description 接口文档配置
 * @Author qzl
 * @Date 2019-03-06 12:08
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {
    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    @Value(value = "\${swagger.enabled}")
    internal var swaggerEnabled: Boolean = false

    @Bean
    fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.qzl.kotlin_springboot"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/")
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("kotlin+springboot+gradle+Swagger2集成和使用")
                .description("kotlin+springboot+gradle编写接口")
                // 作者信息
                .contact(Contact("强周亮", "", "2538096489@qq.com"))
                .version("1.0.0")
                .build()
    }
}
