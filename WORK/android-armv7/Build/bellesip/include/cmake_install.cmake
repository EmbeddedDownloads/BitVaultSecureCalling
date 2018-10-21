# Install script for directory: /home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include

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
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/belle-sip" TYPE FILE MESSAGE_LAZY PERMISSIONS OWNER_READ OWNER_WRITE GROUP_READ WORLD_READ FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/auth-helper.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/belle-sdp.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/belle-sip.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/bodyhandler.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/defs.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/dialog.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/dict.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/generic-uri.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/headers.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/http-listener.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/http-message.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/http-provider.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/list.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/listener.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/listeningpoint.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/mainloop.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/message.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/object.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/parameters.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/provider.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/refresher.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/resolver.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/sipstack.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/sip-uri.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/transaction.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/types.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/utils.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/belle-sip/include/belle-sip/wakelock.h"
    )
endif()

