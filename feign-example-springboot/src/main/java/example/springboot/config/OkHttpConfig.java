package example.springboot.config;

import feign.okhttp.OkHttpClient;
import okhttp3.ConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yangmingyang
 * @Date: 2020/5/26
 */
@Configuration
//@ConditionalOnClass(Feign.class)
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        okhttp3.OkHttpClient okhttp3Client = new okhttp3.OkHttpClient.Builder()
                //设置连接超时
                .connectTimeout(10, TimeUnit.SECONDS)
                //设置读超时
                .readTimeout(10, TimeUnit.SECONDS)
                //设置写超时
                .writeTimeout(10, TimeUnit.SECONDS)
                //是否自动重连
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES))
                .build();
        return new OkHttpClient(okhttp3Client);
    }

}
