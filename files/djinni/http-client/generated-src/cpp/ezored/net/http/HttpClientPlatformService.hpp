// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from proj.djinni

#pragma once

namespace ezored { namespace net { namespace http {

struct HttpRequest;
struct HttpResponse;

class HttpClientPlatformService {
public:
    virtual ~HttpClientPlatformService() {}

    virtual HttpResponse doRequest(const HttpRequest & request) = 0;
};

} } }  // namespace ezored::net::http