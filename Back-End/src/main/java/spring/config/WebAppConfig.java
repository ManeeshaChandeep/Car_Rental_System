package spring.config;
import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"spring.controller","spring.advisor"})
public class WebAppConfig {
        public WebAppConfig(){
                System.out.println("WebAppConfig:Web App Instantiated");
        }
}

