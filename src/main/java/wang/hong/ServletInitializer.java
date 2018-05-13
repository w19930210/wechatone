package wang.hong;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * 项目打war包类
 * 部署需要继承SpringBootServletInitializer类并重写configure方法
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WechatOneApplication.class);
	}

}
