# Configurations
cmake_minimum_required(VERSION 2.8.12)
get_filename_component(CMAKE_SOURCE_REALPATH "${CMAKE_SOURCE_DIR}/../../../../" REALPATH)

set(PROJECT_CONFIG_NAME "Core" CACHE STRING "Project name")
set(PROJECT_CONFIG_VERSION "1.0.0" CACHE STRING "")
set(PROJECT_CONFIG_CPP_STANDARD "11" CACHE STRING "11")
set(PROJECT_TARGET_NAME "ios_framework" CACHE STRING "Target name")
set(PROJECT_CONFIG_ARCH "" CACHE STRING "Architecture")
set(PROJECT_ROOT_PATH ${CMAKE_SOURCE_REALPATH})
set(PROJECT_BUILD_DIR ${PROJECT_ROOT_PATH}/build/${PROJECT_TARGET_NAME}/${CMAKE_BUILD_TYPE}/${PROJECT_CONFIG_ARCH} CACHE INTERNAL "")

# Include: common
add_subdirectory(
    ${PROJECT_ROOT_PATH}/files/cmake/common
    ${PROJECT_BUILD_DIR}/common
)

# Suppress macOS X RPATH warnings and adopt new related behaviors
if(NOT CMAKE_VERSION VERSION_LESS 3.9)
    cmake_policy(SET CMP0068 NEW)
endif()

# Platform configurations
set(DEVELOPMENT_TEAM_ID "" CACHE STRING "Development Team ID")
set(CODE_SIGN_IDENTITY "iPhone Developer" CACHE STRING "Sign Identity")
set(FRAMEWORK_NAME "${PROJECT_CONFIG_NAME}" CACHE STRING "Framework Name")
set(FRAMEWORK_BUNDLE_IDENTIFIER "com.ezored.core" CACHE STRING "Bundle Identifier")
set(DEPLOYMENT_TARGET "9.0" CACHE STRING "Minimum iOS deployment version")
set(DEVICE_FAMILY "1,2" CACHE STRING "Device Family")

# Project
project(${PROJECT_CONFIG_NAME})

# Header search paths
set(PROJECT_HEADER_SEARCH_PATHS
    ${PROJECT_HEADER_SEARCH_PATHS}
    "${PROJECT_ROOT_PATH}/files/djinni/support-lib"
    "${PROJECT_ROOT_PATH}/files/djinni/support-lib/objc"

    "${PROJECT_ROOT_PATH}/files/djinni/001-app-domain/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/002-app-core/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/003-app-data-services/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/004-app-system-service/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/005-app-helpers/generated-src/objc"

    "${PROJECT_ROOT_PATH}/files/djinni/core/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/logger/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/httpclient/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/file-helper/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/shared-data/generated-src/objc"
    "${PROJECT_ROOT_PATH}/files/djinni/datetime/generated-src/objc"

    "${PROJECT_ROOT_PATH}/files/src/logger/objc"
    "${PROJECT_ROOT_PATH}/files/src/httpclient/objc"
    "${PROJECT_ROOT_PATH}/files/src/file-helper/objc"
    "${PROJECT_ROOT_PATH}/files/src/shared-data/objc"
    "${PROJECT_ROOT_PATH}/files/src/datetime/objc"

    CACHE INTERNAL ""
)

# Header files
file(GLOB H_FILES_SUPPORT_LIB_CPP "${PROJECT_ROOT_PATH}/files/djinni/support-lib/*.hpp")
file(GLOB H_FILES_SUPPORT_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/support-lib/objc/*.h")

file(GLOB_RECURSE H_FILES_APP_DOMAIN_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/001-app-domain/generated-src/objc/*.h")
file(GLOB_RECURSE H_FILES_APP_CORE_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/002-app-core/generated-src/objc/*.h")
file(GLOB_RECURSE H_FILES_APP_DATA_SERVICES_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/003-app-data-services/generated-src/objc/*.h")
file(GLOB_RECURSE H_FILES_APP_SYSTEM_SERVICES_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/004-app-system-service/generated-src/objc/*.h")
file(GLOB_RECURSE H_FILES_APP_HELPERS_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/005-app-helpers/generated-src/objc/*.h")

file(GLOB_RECURSE H_FILES_LOGGER_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/logger/generated-src/objc/*.h")
file(GLOB H_FILES_LOGGER_LIB_IMPL "${PROJECT_ROOT_PATH}/files/src/logger/objc/ezored/util/*.h")

file(GLOB_RECURSE H_FILES_HTTPCLIENT_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/httpclient/generated-src/objc/*.h")
file(GLOB H_FILES_HTTPCLIENT_LIB_IMPL "${PROJECT_ROOT_PATH}/files/src/httpclient/objc/ezored/net/http/*.h")

file(GLOB_RECURSE H_FILES_FILE_HELPER_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/file-helper/generated-src/objc/*.h")
file(GLOB H_FILES_FILE_HELPER_LIB_IMPL "${PROJECT_ROOT_PATH}/files/src/file-helper/objc/ezored/io/*.h")

file(GLOB_RECURSE H_FILES_SHARED_DATA_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/shared-data/generated-src/objc/*.h")
file(GLOB H_FILES_SHARED_DATA_LIB_IMPL "${PROJECT_ROOT_PATH}/files/src/shared-data/objc/ezored/data/*.h")

file(GLOB_RECURSE H_FILES_DATETIME_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/datetime/generated-src/objc/*.h")

# Source files
file(GLOB S_FILES_SUPPORT_LIB_CPP "${PROJECT_ROOT_PATH}/files/djinni/support-lib/*.cpp")
file(GLOB S_FILES_SUPPORT_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/support-lib/objc/*.mm")

file(GLOB_RECURSE S_FILES_APP_DOMAIN_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/001-app-domain/generated-src/objc/*.mm")
file(GLOB_RECURSE S_FILES_APP_CORE_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/002-app-core/generated-src/objc/*.mm")
file(GLOB_RECURSE S_FILES_APP_DATA_SERVICES_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/003-app-data-services/generated-src/objc/*.mm")
file(GLOB_RECURSE S_FILES_APP_SYSTEM_SERVICES_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/004-app-system-service/generated-src/objc/*.mm")
file(GLOB_RECURSE S_FILES_APP_HELPERS_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/005-app-helpers/generated-src/objc/*.mm")

file(GLOB_RECURSE S_FILES_LOGGER_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/logger/generated-src/objc/*.mm")
file(GLOB S_FILES_LOGGER_LIB_IMPL "${PROJECT_ROOT_PATH}/files/src/logger/objc/ezored/util/*.m")

file(GLOB_RECURSE S_FILES_HTTPCLIENT_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/httpclient/generated-src/objc/*.mm")
file(GLOB S_FILES_HTTPCLIENT_LIB_IMPL "${PROJECT_ROOT_PATH}/files/src/httpclient/objc/ezored/net/http/*.m")

file(GLOB_RECURSE S_FILES_FILE_HELPER_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/file-helper/generated-src/objc/*.mm")
file(GLOB S_FILES_FILE_HELPER_LIB_IMPL "${PROJECT_ROOT_PATH}/files/src/file-helper/objc/ezored/io/*.m")

file(GLOB_RECURSE S_FILES_SHARED_DATA_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/shared-data/generated-src/objc/*.mm")
file(GLOB S_FILES_SHARED_DATA_LIB_IMPL "${PROJECT_ROOT_PATH}/files/src/shared-data/objc/ezored/data/*.m")

file(GLOB_RECURSE S_FILES_DATETIME_LIB_OBJC "${PROJECT_ROOT_PATH}/files/djinni/datetime/generated-src/objc/*.mm")

# Merge lists
set(
    TARGET_HEADER_FILES 
    ${H_FILES_SUPPORT_LIB_CPP}
    ${H_FILES_SUPPORT_LIB_OBJC}
    ${H_FILES_APP_DOMAIN_LIB_OBJC}
    ${H_FILES_APP_CORE_LIB_OBJC}
    ${H_FILES_APP_DATA_SERVICES_LIB_OBJC}
    ${H_FILES_APP_SYSTEM_SERVICES_LIB_OBJC}
    ${H_FILES_APP_HELPERS_LIB_OBJC}
    ${H_FILES_LOGGER_LIB_OBJC}
    ${H_FILES_LOGGER_LIB_IMPL}
    ${H_FILES_HTTPCLIENT_LIB_OBJC}
    ${H_FILES_HTTPCLIENT_LIB_IMPL}
    ${H_FILES_FILE_HELPER_LIB_OBJC}
    ${H_FILES_FILE_HELPER_LIB_IMPL}
    ${H_FILES_SHARED_DATA_LIB_OBJC}
    ${H_FILES_SHARED_DATA_LIB_IMPL}
    ${H_FILES_DATETIME_LIB_OBJC}
)

set(
    TARGET_SOURCE_FILES 
    ${S_FILES_SUPPORT_LIB_CPP}
    ${S_FILES_SUPPORT_LIB_OBJC}
    ${S_FILES_APP_DOMAIN_LIB_OBJC}
    ${S_FILES_APP_CORE_LIB_OBJC}
    ${S_FILES_APP_DATA_SERVICES_LIB_OBJC}
    ${S_FILES_APP_SYSTEM_SERVICES_LIB_OBJC}
    ${S_FILES_APP_HELPERS_LIB_OBJC}
    ${S_FILES_LOGGER_LIB_OBJC}
    ${S_FILES_LOGGER_LIB_IMPL}
    ${S_FILES_HTTPCLIENT_LIB_OBJC}
    ${S_FILES_HTTPCLIENT_LIB_IMPL}
    ${S_FILES_FILE_HELPER_LIB_OBJC}
    ${S_FILES_FILE_HELPER_LIB_IMPL}
    ${S_FILES_SHARED_DATA_LIB_OBJC}
    ${S_FILES_SHARED_DATA_LIB_IMPL}
    ${S_FILES_DATETIME_LIB_OBJC}
)

set(
    PROJECT_HEADER_FILES
    ${PROJECT_HEADER_FILES}
    ${TARGET_HEADER_FILES}
    CACHE INTERNAL ""
)

set(
    PROJECT_SOURCE_FILES
    ${PROJECT_SOURCE_FILES}
    ${TARGET_HEADER_FILES}
    ${TARGET_SOURCE_FILES}
    CACHE INTERNAL ""
)

# Framework links
set(PROJECT_FRAMEWORK_LINKS
    ${PROJECT_FRAMEWORK_LINKS}
	"-framework Foundation"
	"-framework AVFoundation"
	"-framework UIKit"
    "-framework CoreFoundation"
    CACHE INTERNAL ""
)

# CFlags
set(PROJECT_CMAKE_C_FLAGS "${PROJECT_CMAKE_C_FLAGS} -fobjc-arc" CACHE INTERNAL "")

# CXXFlags
set(PROJECT_CMAKE_CXX_FLAGS "${PROJECT_CMAKE_CXX_FLAGS} -fobjc-arc -stdlib=libc++" CACHE INTERNAL "")

# Conan
include(${PROJECT_BUILD_DIR}/conan/conanbuildinfo.cmake)
conan_basic_setup()

# Project
include_directories(${PROJECT_HEADER_SEARCH_PATHS})
link_directories(${PROJECT_LIBRARY_SEARCH_PATHS})

add_library(${PROJECT_CONFIG_NAME} SHARED ${PROJECT_SOURCE_FILES})

target_link_libraries(${PROJECT_CONFIG_NAME} "${PROJECT_LIBRARY_LINKS}")
target_link_libraries(${PROJECT_CONFIG_NAME} "${PROJECT_FRAMEWORK_LINKS}")
target_link_libraries(${PROJECT_CONFIG_NAME} "${CONAN_LIBS}")

set_target_properties(${PROJECT_CONFIG_NAME} PROPERTIES
    CXX_STANDARD "${PROJECT_CONFIG_CPP_STANDARD}"
    CXX_STANDARD_REQUIRED true
    CXX_EXTENSIONS false
    CXX_VISIBILITY_PRESET default
    FRAMEWORK TRUE
    FRAMEWORK_VERSION A
    MACOSX_FRAMEWORK_IDENTIFIER "${FRAMEWORK_BUNDLE_IDENTIFIER}"
    MACOSX_FRAMEWORK_BUNDLE_VERSION "${PROJECT_CONFIG_VERSION}"
    MACOSX_FRAMEWORK_SHORT_VERSION_STRING "${PROJECT_CONFIG_VERSION}"
    VERSION "${PROJECT_CONFIG_VERSION}"
    SOVERSION "${PROJECT_CONFIG_VERSION}"
    XCODE_ATTRIBUTE_IPHONEOS_DEPLOYMENT_TARGET "${DEPLOYMENT_TARGET}"
    XCODE_ATTRIBUTE_CODE_SIGN_IDENTITY "${CODE_SIGN_IDENTITY}"
    XCODE_ATTRIBUTE_DEVELOPMENT_TEAM "${DEVELOPMENT_TEAM_ID}"
    XCODE_ATTRIBUTE_TARGETED_DEVICE_FAMILY "${DEVICE_FAMILY}"
    XCODE_ATTRIBUTE_ONLY_ACTIVE_ARCH NO
    XCODE_ATTRIBUTE_SKIP_INSTALL YES
    XCODE_ATTRIBUTE_INSTALL_PATH "@loader_path/Frameworks"
)

# Adapt install directory to allow distributing dylibs/frameworks in user's frameworks/application bundle
set_target_properties(${PROJECT_CONFIG_NAME} PROPERTIES INSTALL_NAME_DIR "@rpath")

if(NOT CMAKE_SKIP_BUILD_RPATH)
    if(CMAKE_VERSION VERSION_LESS 3.9)
        set_target_properties(${PROJECT_CONFIG_NAME} PROPERTIES BUILD_WITH_INSTALL_RPATH TRUE)
    else()
        set_target_properties(${PROJECT_CONFIG_NAME} PROPERTIES BUILD_WITH_INSTALL_NAME_DIR TRUE)
    endif()
endif()

target_compile_options(${PROJECT_CONFIG_NAME} PUBLIC "${PROJECT_COMPILE_OPTIONS}")