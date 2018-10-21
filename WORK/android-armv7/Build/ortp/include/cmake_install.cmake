# Install script for directory: /home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include

# Set the install prefix
if(NOT DEFINED CMAKE_INSTALL_PREFIX)
  set(CMAKE_INSTALL_PREFIX "/home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-armv7")
endif()
string(REGEX REPLACE "/$" "" CMAKE_INSTALL_PREFIX "${CMAKE_INSTALL_PREFIX}")

# Set the install configuration name.
if(NOT DEFINED CMAKE_INSTALL_CONFIG_NAME)
  if(BUILD_TYPE)
    string(REGEX REPLACE "^[^A-Za-z0-9_]+" ""
           CMAKE_INSTALL_CONFIG_NAME "${BUILD_TYPE}")
  else()
    set(CMAKE_INSTALL_CONFIG_NAME "RelWithDebInfo")
  endif()
  message(STATUS "Install configuration: \"${CMAKE_INSTALL_CONFIG_NAME}\"")
endif()

# Set the component getting installed.
if(NOT CMAKE_INSTALL_COMPONENT)
  if(COMPONENT)
    message(STATUS "Install component: \"${COMPONENT}\"")
    set(CMAKE_INSTALL_COMPONENT "${COMPONENT}")
  else()
    set(CMAKE_INSTALL_COMPONENT)
  endif()
endif()

# Install shared libraries without execute permission?
if(NOT DEFINED CMAKE_INSTALL_SO_NO_EXE)
  set(CMAKE_INSTALL_SO_NO_EXE "1")
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/ortp" TYPE FILE MESSAGE_LAZY PERMISSIONS OWNER_READ OWNER_WRITE GROUP_READ WORLD_READ FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/b64.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/event.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/logging.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/ortp.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/payloadtype.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/port.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/rtcp.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/rtp.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/rtpprofile.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/rtpsession.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/rtpsignaltable.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/sessionset.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/str_utils.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/telephonyevents.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/oRTP/include/ortp/utils.h"
    )
endif()

