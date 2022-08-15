package com.github.kop.template.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class DateTimeFormatConfiguration extends WebMvcConfigurationSupport {

  @Override
  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    super.configureMessageConverters(converters);
    converters.add(new MappingJackson2HttpMessageConverter(objectMapper()));
  }

  @Bean
  @Override
  public FormattingConversionService mvcConversionService() {
    DefaultFormattingConversionService conversionService =
        new DefaultFormattingConversionService(false);

    DateTimeFormatterRegistrar dateTimeRegistrar = new DateTimeFormatterRegistrar();
    dateTimeRegistrar.setDateFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    dateTimeRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    dateTimeRegistrar.registerFormatters(conversionService);

    DateFormatterRegistrar dateRegistrar = new DateFormatterRegistrar();
    dateRegistrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
    dateRegistrar.registerFormatters(conversionService);

    return conversionService;
  }

  private String localDateTimeFormat = "yyyy-MM-dd HH:mm:ss";
  private String localDateFormat = "yyyy-MM-dd";
  private String localTimeFormat = "HH:mm:ss";

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper om = new ObjectMapper();
    JavaTimeModule javaTimeModule = new JavaTimeModule();
    // 序列化
    javaTimeModule.addSerializer(
        LocalDateTime.class,
        new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(localDateTimeFormat)));
    javaTimeModule.addSerializer(
        LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(localDateFormat)));
    javaTimeModule.addSerializer(
        LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(localTimeFormat)));
    // 反序列化
    javaTimeModule.addDeserializer(
        LocalDateTime.class,
        new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(localDateTimeFormat)));
    javaTimeModule.addDeserializer(
        LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(localDateFormat)));
    javaTimeModule.addDeserializer(
        LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(localTimeFormat)));
    om.registerModule(javaTimeModule);
    return om;
  }
}
