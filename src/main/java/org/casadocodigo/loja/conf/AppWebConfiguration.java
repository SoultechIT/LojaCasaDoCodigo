package org.casadocodigo.loja.conf;

import org.casadocodigo.loja.controllers.HomeController;
import org.casadocodigo.loja.controllers.ProdutosController;
import org.casadocodigo.loja.daos.ProductDao;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProdutosController.class, ProductDao.class})
//@ComponentScan(basePackages = "org.casadocodigo.loja")
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
    	
    	System.out.println("Spring MVC OK!");
    	
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    public MessageSource messageSource() {
    	ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
    	bundle.setBasename("/WEB-INF/messages");
    	bundle.setDefaultEncoding("UTF-8");
    	bundle.setCacheSeconds(1);
    	return bundle;
    }
    
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
		registrar.registerFormatters(conversionService);
		return conversionService;
	}
}
