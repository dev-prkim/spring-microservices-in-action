package sample;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class OrganizationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrganizationServiceApplication.class, args);
  }

  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
    localeResolver.setDefaultLocale(Locale.US);
    return localeResolver;
  }

  @Bean
  public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setUseCodeAsDefaultMessage(true); // 메시지를 찾을 수 없는 경우 메시지 코드를 반환한다.
    messageSource.setBasenames("messages"); // 언어 프로퍼티 파일의 기본 이름을 설정한다.
    return messageSource;
  }

}