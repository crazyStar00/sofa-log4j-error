package com.star;

import com.alipay.sofa.rpc.config.ApplicationConfig;
import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.star.service.HelloService;
import com.star.service.impl.HelloServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author star
 * @date 2022/6/1 9:39 PM
 */
public class Provider {
    private static final Logger LOGGER = LoggerFactory.getLogger(Provider.class);
    public static void main(String[] args) {
        ApplicationConfig application = new ApplicationConfig().setAppName("test");
        HelloService helloService = new HelloServiceImpl();
        ServerConfig serverConfig = new ServerConfig().setPort(1111).setDaemon(false);

        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName())
                .setApplication(application)
                .setRef(helloService)
                .setServer(serverConfig);
        providerConfig.export();
        LOGGER.info("启动成功");
    }
}
