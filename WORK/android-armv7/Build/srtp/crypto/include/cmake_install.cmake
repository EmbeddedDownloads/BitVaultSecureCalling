# Install script for directory: /home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include

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
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/srtp" TYPE FILE MESSAGE_LAZY PERMISSIONS OWNER_READ OWNER_WRITE GROUP_READ WORLD_READ FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/aes.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/aes_cbc.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/aes_icm.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/alloc.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/auth.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/cipher.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/crypto.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/crypto_kernel.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/crypto_math.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/crypto_types.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/cryptoalg.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/datatypes.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/err.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/gf2_8.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/hmac.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/integers.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/kernel_compat.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/key.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/null_auth.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/null_cipher.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/prng.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/rand_source.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/rdb.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/rdbx.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/sha1.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/stat.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp/crypto/include/xfm.h"
    )
endif()

