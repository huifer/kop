package com.github.kop.pm.codegenerator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class CodeGenerator {
    public static final String MYSQL_INFO = "code-gen.properties";

    static String url;
    static String username;
    static String password;
    static String author;
    static String packageName;
    static String table;
    static String out_put_file;

    static {
        InputStream in = CodeGenerator.class.getClassLoader().getResourceAsStream(MYSQL_INFO);
        Properties properties = new Properties();
        try {
            properties.load(in);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            author = properties.getProperty("author");
            packageName = properties.getProperty("package");
            table = properties.getProperty("table");
            table = properties.getProperty("table");
            out_put_file = properties.getProperty("out_put_file");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        FastAutoGenerator.create(url, username, password)
            .globalConfig(
                (scanner, builder) -> builder.author(author).fileOverride()
                    .outputDir(out_put_file)
            )
            .packageConfig((scanner, builder) -> builder.parent(packageName)
                .pathInfo(
                    Collections.singletonMap(OutputFile.xml, out_put_file))) // mapper xml 文件生产地址

            .strategyConfig((scanner, builder) ->
                builder
                    .addTablePrefix("bbs")
                    .addInclude(getTables(table))
                    .controllerBuilder().enableRestStyle().enableHyphenStyle()
                    .entityBuilder().enableLombok()
                    .enableTableFieldAnnotation()
                    .addTableFills(
                        new Column("create_time", FieldFill.INSERT),
                        new Column("create_user_id", FieldFill.INSERT),
                        new Column("update_time", FieldFill.INSERT_UPDATE),
                        new Column("update_user_id", FieldFill.INSERT_UPDATE)

                    ).build())
                .execute();


    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
