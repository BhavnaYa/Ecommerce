package com.demo.order.config;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
@Component
public class BaseWebClient {
    public static final String HTTP_METHOD_DELETE = "DELETE";
    public static final String HTTP_METHOD_GET = "GET";
    /**
     *
     * @param <T>
     * @param uri
     * @param method
     * @param entity
     * @param responseType
     * @return
     */
    protected <T> Mono<ResponseEntity<T>> getResponseEntityMonoForIntegrationClient(WebClient webClient, String uri, HttpMethod method,
                                                                                    HttpEntity<?> entity, Class<T> responseType) {
        String httpMethodName = method.name();
        switch (httpMethodName) {
            case HTTP_METHOD_DELETE:
            case HTTP_METHOD_GET:
                return webClient.method(method).uri(uri).headers(headers -> headers.addAll(entity.getHeaders())).retrieve()
                        .onStatus(HttpStatus::is4xxClientError,
                                response -> response.bodyToMono(String.class).flatMap(body -> {
                                    HttpStatus httpStatus = response.statusCode();
                                    return Mono.error(new HttpClientErrorException(body, httpStatus,
                                            response.statusCode() + " : " + httpStatus.getReasonPhrase(),
                                            response.headers().asHttpHeaders(), body.getBytes(), null));
                                }))
                        .onStatus(HttpStatus::is5xxServerError,
                                response -> response.bodyToMono(String.class).flatMap(body -> {
                                    HttpStatus httpStatus = response.statusCode();
                                    return Mono.error(new HttpServerErrorException(body, httpStatus,
                                            response.statusCode() + " : " + httpStatus.getReasonPhrase(),
                                            response.headers().asHttpHeaders(), body.getBytes(), null));
                                }))
                        .toEntity(responseType);
            default:
                return webClient.method(method).uri(uri).headers(headers -> headers.addAll(entity.getHeaders()))
                        .bodyValue(entity.getBody() == null ? "{}" : entity.getBody()).retrieve()
                        .onStatus(HttpStatus::is4xxClientError,
                                response -> response.bodyToMono(String.class).flatMap(body -> {
                                    HttpStatus httpStatus = response.statusCode();
                                    return Mono.error(new HttpClientErrorException(body, httpStatus,
                                            response.statusCode() + " : " + httpStatus.getReasonPhrase(),
                                            response.headers().asHttpHeaders(), body.getBytes(), null));
                                }))
                        .onStatus(HttpStatus::is5xxServerError,
                                response -> response.bodyToMono(String.class).flatMap(body -> {
                                    HttpStatus httpStatus = response.statusCode();
                                    return Mono.error(new HttpServerErrorException(body, httpStatus,
                                            response.statusCode() + " : " + httpStatus.getReasonPhrase(),
                                            response.headers().asHttpHeaders(), body.getBytes(), null));
                                }))
                        .toEntity(responseType);
        }
    }
}