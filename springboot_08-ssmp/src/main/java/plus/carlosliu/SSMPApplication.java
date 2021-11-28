package plus.carlosliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSMPApplication {

    public static void main(String[] args) {
//        String[] arg = new String[1];
//        arg[0] = "--server.port=8888";
//        SpringApplication.run(SSMPApplication.class, arg);
        // 可以在启动boot程序时断开读取外部临时配置对应的入口，也就是去掉读取外部参数的形参
        SpringApplication.run(SSMPApplication.class);
    }

}
