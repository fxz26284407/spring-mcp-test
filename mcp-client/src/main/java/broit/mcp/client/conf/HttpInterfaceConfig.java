package broit.mcp.client.conf;

import broit.mcp.client.api.RagFlowApi;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class HttpInterfaceConfig {
    @Value("${rag.chunk-url}")
    private String chunkUrl;
    @Value("${rag.api-key}")
    private String apiKey;

    @Bean
    WebClient ragWebClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 600000)
                .doOnConnected(conn -> conn
                        .addHandlerFirst(new ReadTimeoutHandler(600, TimeUnit.SECONDS))
                        .addHandlerFirst(new WriteTimeoutHandler(300)));
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(chunkUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    @Bean
    RagFlowApi ragFlowApi(WebClient ragWebClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(ragWebClient)).build();
        return factory.createClient(RagFlowApi.class);
    }
}
