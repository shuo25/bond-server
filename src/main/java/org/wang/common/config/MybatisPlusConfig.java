package org.wang.common.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: 18615
 * Date: 2024/3/18 21:34
 */
@Configuration
@MapperScan("org.wang.**.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInnerInterceptor paginationInterceptor() {
        return new PaginationInnerInterceptor();
    }
}
