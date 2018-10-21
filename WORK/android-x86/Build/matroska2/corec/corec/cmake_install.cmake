# Install script for directory: /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec

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
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec" TYPE FILE MESSAGE_LAZY FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/banned.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/confhelper.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/corec.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/err.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helper.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/memalloc.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/memheap.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/portab.h"
    )
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/array" TYPE FILE MESSAGE_LAZY FILES "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/array/array.h")
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/helpers/charconvert" TYPE FILE MESSAGE_LAZY FILES "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/charconvert/charconvert.h")
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/helpers/date" TYPE FILE MESSAGE_LAZY FILES "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/date/date.h")
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/helpers/file" TYPE FILE MESSAGE_LAZY FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/file/file.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/file/streams.h"
    )
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/helpers/md5" TYPE FILE MESSAGE_LAZY FILES "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/md5/md5.h")
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/helpers/parser" TYPE FILE MESSAGE_LAZY FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/parser/buffer.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/parser/dataheap.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/parser/hotkey.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/parser/nodelookup.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/parser/parser.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/parser/strtab.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/parser/strtypes.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/parser/urlpart.h"
    )
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/helpers/system" TYPE FILE MESSAGE_LAZY FILES "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/helpers/system/ccsystem.h")
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/multithread" TYPE FILE MESSAGE_LAZY FILES "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/multithread/multithread.h")
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/node" TYPE FILE MESSAGE_LAZY FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/node/node.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/node/node_internal.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/node/nodebase.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/node/nodetools.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/node/nodetree.h"
    )
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/corec/str" TYPE FILE MESSAGE_LAZY FILES "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libmatroska-c/corec/corec/str/str.h")
endif()

