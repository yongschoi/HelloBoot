package yongs.temp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	/* Interceptor 예제 
	@Autowired
	private LoginInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/resources/**")
				.excludePathPatterns("/loginPage")
				.excludePathPatterns("/login")
				.excludePathPatterns("/user/createPage")
				.excludePathPatterns("/user/create")
				.excludePathPatterns("/yongs-api/**");
	}
	*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/scripts/**")
          .addResourceLocations("/resources/scripts/");
    }
}
