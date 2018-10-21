# Install script for directory: /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include

# Set the install prefix
if(NOT DEFINED CMAKE_INSTALL_PREFIX)
  set(CMAKE_INSTALL_PREFIX "/home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-x86")
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
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/bctoolbox" TYPE FILE MESSAGE_LAZY PERMISSIONS OWNER_READ OWNER_WRITE GROUP_READ WORLD_READ FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include/bctoolbox/crypto.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include/bctoolbox/list.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include/bctoolbox/logging.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include/bctoolbox/map.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include/bctoolbox/port.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include/bctoolbox/vfs.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include/bctoolbox/vconnect.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/include/bctoolbox/tester.h"
    )
endif()

