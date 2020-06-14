package example.springboot.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * 使用自定义的RequestInterceptor，在request发送之前，将信息放入请求
 * @version
 * @author yangmingyang
 * @Date: 2020/6/1
 * @since 1.8
 */
@Component
public class TokenRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        String method = template.method();
        String url = template.url();
        System.out.println("method:" + method);
        System.out.println("url:" + url);
    }
}
