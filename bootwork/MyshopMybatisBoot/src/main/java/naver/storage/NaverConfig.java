package naver.storage;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("classpath:/naver.properties")
@ConfigurationProperties(prefix="ncp")
public class NaverConfig {
    private String endPoint;
    private String regionName;
    private String accessKey;
    private String secretKey;
}
