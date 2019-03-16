// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from proj.djinni

package com.ezored.net.http;

import java.util.ArrayList;

public final class HttpRequest {


    /*package*/ final String mUrl;

    /*package*/ final HttpMethod mMethod;

    /*package*/ final ArrayList<HttpRequestParam> mParams;

    /*package*/ final ArrayList<HttpHeader> mHeaders;

    /*package*/ final String mBody;

    public HttpRequest(
            String url,
            HttpMethod method,
            ArrayList<HttpRequestParam> params,
            ArrayList<HttpHeader> headers,
            String body) {
        this.mUrl = url;
        this.mMethod = method;
        this.mParams = params;
        this.mHeaders = headers;
        this.mBody = body;
    }

    public String getUrl() {
        return mUrl;
    }

    public HttpMethod getMethod() {
        return mMethod;
    }

    public ArrayList<HttpRequestParam> getParams() {
        return mParams;
    }

    public ArrayList<HttpHeader> getHeaders() {
        return mHeaders;
    }

    public String getBody() {
        return mBody;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "mUrl=" + mUrl +
                "," + "mMethod=" + mMethod +
                "," + "mParams=" + mParams +
                "," + "mHeaders=" + mHeaders +
                "," + "mBody=" + mBody +
        "}";
    }

}