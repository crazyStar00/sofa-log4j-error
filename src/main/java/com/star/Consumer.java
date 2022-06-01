package com.star;

import com.alipay.sofa.rpc.config.ApplicationConfig;
import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import com.star.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author star
 * @date 2022/6/1 9:39 PM
 */
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    public static void main(String[] args) {
        ApplicationConfig application = new ApplicationConfig().setAppName("hermes-proxy");
        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setApplication(application)
                .setInterfaceId(HelloService.class.getName())
                .setDirectUrl("127.0.0.1:1111")
                .setRetries(0);
        HelloService helloService = consumerConfig.refer();
        String result = helloService.hello("star");
        LOGGER.info("result is :{}",result);
    }
}
