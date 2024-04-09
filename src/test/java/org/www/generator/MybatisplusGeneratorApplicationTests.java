package org.www.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

/**
 * 代码生成器测试类
 * Author: 18615
 * Date: 2024/4/9 10:07
 */

public class MybatisplusGeneratorApplicationTests {
    @Test
    void testGenerator() {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/bady_bond?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai", "root", "123456")
                //1.全局配置
                .globalConfig(builder -> {
                    builder.author("wangshuo")
                            .outputDir("D:\\project\\java\\boot\\bond-server\\src\\main\\java") // 设置生成路径
                            .dateType(DateType.ONLY_DATE);
                })
                //2.包的配置
                .packageConfig(builder -> {
                    builder.moduleName("permission")
                            .parent("org.wang")
                            .entity("entity")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller");
                })
                //3.策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("t_permission") // 设置要映射的表
                            .addTablePrefix("t_")  // 设置过滤表前缀
                            .entityBuilder().enableLombok() // 自动lombok
                            .idType(IdType.ASSIGN_ID) //全局主键策略
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .logicDeletePropertyName("delFlag")
                    ;  // 逻辑删除
                    builder.mapperBuilder()
                            .superClass(BaseMapper.class)
                            .enableMapperAnnotation()
                            .build();
                })
                //4.Freemarker引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
