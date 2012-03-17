package no.zsoft.faktura.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "no.zsoft")
//@ImportResource({ "classpath*:*-config.xml" })
//@PropertySource("jdbc.properties")
//public class WebConfig extends WebMvcConfigurerAdapter {
	public class WebConfig{
	// @Bean
	// public InternalResourceViewResolver
	// configureInternalResourceViewResolver() {
	// InternalResourceViewResolver resolver = new
	// InternalResourceViewResolver();
	// resolver.setPrefix("/WEB-INF/");
	// resolver.setSuffix(".jsp");
	// return resolver;
	// }
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages.properties");
//		return messageSource;
//	}
}
