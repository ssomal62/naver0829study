package mini.naver.storage;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
public class NaverConfig {

    @Value("https://kr.object.ncloudstorage.com")
    private String endPoint;

    @Value("kr-standard")
    private String regionName;

    @Value("8WkR3bZnWbDIyydbmk8t")
    private String accessKey;

    @Value("9xw3qYYmxXHWiHMprko5tCZKaFs0AcgdMXJQFifA")
    private String secretKey;

}
