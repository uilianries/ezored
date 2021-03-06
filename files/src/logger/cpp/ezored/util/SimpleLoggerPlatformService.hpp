#pragma once

#include <string>
#include "ezored/util/LoggerPlatformService.hpp"

namespace ezored { namespace util {

class SimpleLoggerPlatformService: public LoggerPlatformService {

public:
    virtual ~SimpleLoggerPlatformService() {}

    void v(const std::string & message) override;
    void d(const std::string & message) override;
    void i(const std::string & message) override;
    void w(const std::string & message) override;
    void e(const std::string & message) override;

    void setGroup(const std::string & group) override;
};

} }
