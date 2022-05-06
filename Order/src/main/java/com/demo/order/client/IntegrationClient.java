package com.demo.order.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.demo.order.config.BaseWebClient;
@Service
public class IntegrationClient extends BaseWebClient {
    public static final String INTEGRATION_WEB_CLIENT = "Integration-web-client";
    public static final String INTEGRATION_WEB_CLIENT_SSL = "Integration-web-client-ssl";
    @Autowired
    @Qualifier(INTEGRATION_WEB_CLIENT)
    private WebClient webClient;
    /**
     * @param <T>
     * @param uri
     * @param method
     * @param entity
     * @return calling API using provided url ,HTTP method and
     * HttpEntity
     */
    public <T> ResponseEntity<T> getResponse(String uri, HttpMethod method, HttpEntity<?> entity,
                                             Class<T> responseType) {
        return getResponseEntityMonoForIntegrationClient(webClient, uri, method, entity, responseType)
                .block();
    }
}