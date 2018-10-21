# Install script for directory: /home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include

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
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/linphone" TYPE FILE MESSAGE_LAZY PERMISSIONS OWNER_READ OWNER_WRITE GROUP_READ WORLD_READ FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/account_creator.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/account_creator_service.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/address.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/auth_info.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/buffer.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/call.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/callbacks.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/call_log.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/call_params.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/call_stats.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/chat.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/conference.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/contactprovider.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/content.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/core.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/core_utils.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/defs.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/dictionary.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/error_info.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/event.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/factory.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/friend.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/friendlist.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/im_encryption_engine.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/im_notif_policy.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/info_message.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/ldapprovider.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/lpconfig.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/misc.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/nat_policy.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/payload_type.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/player.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/presence.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/proxy_config.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/ringtoneplayer.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/sipsetup.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/tunnel.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/types.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/vcard.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/video_definition.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/wrapper_utils.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/xmlrpc.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/linphonecore.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/linphonecore_utils.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/linphonefriend.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/linphonepresence.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/linphone_proxy_config.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/linphone/include/linphone/linphone_tunnel.h"
    )
endif()

