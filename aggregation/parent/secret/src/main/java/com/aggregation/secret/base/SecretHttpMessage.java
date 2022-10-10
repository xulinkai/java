package com.aggregation.secret.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
public class SecretHttpMessage implements HttpInputMessage {

    private InputStream body;
    private HttpHeaders httpHeaders;

    @Override
    public InputStream getBody() throws IOException {
        return this.body;
    }

    @Override
    public HttpHeaders getHeaders() {
        return this.httpHeaders;
    }

    public void setBody(InputStream body) {
        this.body = body;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }
}
