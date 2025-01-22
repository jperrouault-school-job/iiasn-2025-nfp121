package fr.formation;

import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;

public class HttpClientProxy extends HttpClient {
    private final HttpClient http = HttpClient.newBuilder().build();
    private final Map<String, HttpResponse<?>> cache = new HashMap<>();

    @Override
    public <T> HttpResponse<T> send(HttpRequest request, BodyHandler<T> bodyHandler) throws IOException, InterruptedException {
        String uri = request.uri().toString();

        if (this.cache.containsKey(uri)) {
            return (HttpResponse<T>) this.cache.get(uri);
        }
        
        System.out.println("Cache inexistant, requête HTTP !");
        HttpResponse<T> response = this.http.send(request, bodyHandler);

        this.cache.put(uri, response);

        return response;
    }

    @Override
    public Optional<Authenticator> authenticator() {
        return this.http.authenticator();
    }

    @Override
    public Optional<Duration> connectTimeout() {
        return this.http.connectTimeout();
    }

    @Override
    public Optional<CookieHandler> cookieHandler() {
        return this.http.cookieHandler();
    }

    @Override
    public Optional<Executor> executor() {
        return this.http.executor();
    }

    @Override
    public Redirect followRedirects() {
        return this.http.followRedirects();
    }

    @Override
    public Optional<ProxySelector> proxy() {
        return this.http.proxy();
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, BodyHandler<T> bodyHandler) {
        return this.http.sendAsync(request, bodyHandler);
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, BodyHandler<T> bodyHandler, PushPromiseHandler<T> promiseHandler) {
        return this.http.sendAsync(request, bodyHandler, promiseHandler);
    }

    @Override
    public SSLContext sslContext() {
        return this.http.sslContext();
    }

    @Override
    public SSLParameters sslParameters() {
        return this.http.sslParameters();
    }

    @Override
    public Version version() {
        return this.http.version();
    }
}
