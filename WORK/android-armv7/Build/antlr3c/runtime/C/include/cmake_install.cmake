# Install script for directory: /home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include

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
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include" TYPE FILE MESSAGE_LAZY PERMISSIONS OWNER_READ OWNER_WRITE GROUP_READ WORLD_READ FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3baserecognizer.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3basetree.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3basetreeadaptor.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3bitset.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3collections.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3commontoken.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3commontree.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3commontreeadaptor.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3commontreenodestream.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3convertutf.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3cyclicdfa.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3debugeventlistener.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3defs.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3encodings.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3errors.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3exception.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3filestream.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3input.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3interfaces.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3intstream.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3lexer.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3memory.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3parser.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3parsetree.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3recognizersharedstate.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3rewritestreams.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3string.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3tokenstream.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/antlr3/runtime/C/include/antlr3treeparser.h"
    )
endif()

