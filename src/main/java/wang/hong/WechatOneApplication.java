package wang.hong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目的初始启动类
 */
@SpringBootApplication
@MapperScan("wang.goods.mapper")
@ComponentScan(basePackages = "wang.goods")
public class WechatOneApplication {

	public static void main(String[] args) {

		SpringApplication.run(WechatOneApplication.class, args);
	}
}
