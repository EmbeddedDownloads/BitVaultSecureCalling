# Install script for directory: /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2

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
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib" TYPE STATIC_LIBRARY MESSAGE_LAZY PERMISSIONS OWNER_READ OWNER_WRITE OWNER_EXECUTE GROUP_READ GROUP_EXECUTE WORLD_READ WORLD_EXECUTE FILES "/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2/libxml2.a")
endif()

if("${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/libxml2/libxml" TYPE FILE MESSAGE_LAZY PERMISSIONS OWNER_READ OWNER_WRITE GROUP_READ WORLD_READ FILES
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/DOCBparser.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/HTMLparser.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/HTMLtree.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/SAX.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/SAX2.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/c14n.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/catalog.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/chvalid.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/debugXML.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/dict.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/encoding.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/entities.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/globals.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/hash.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/list.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/nanoftp.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/nanohttp.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/parser.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/parserInternals.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/pattern.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/relaxng.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/schemasInternals.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/schematron.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/threads.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/tree.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/uri.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/valid.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xinclude.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xlink.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlIO.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlautomata.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlerror.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlexports.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlmemory.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlmodule.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlreader.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlregexp.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlsave.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlschemas.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlschemastypes.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlstring.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlunicode.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlwin32version.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xmlwriter.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xpath.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xpathInternals.h"
    "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2/include/libxml/xpointer.h"
    "/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2/libxml/xmlversion.h"
    )
endif()

if(CMAKE_INSTALL_COMPONENT)
  set(CMAKE_INSTALL_MANIFEST "install_manifest_${CMAKE_INSTALL_COMPONENT}.txt")
else()
  set(CMAKE_INSTALL_MANIFEST "install_manifest.txt")
endif()

string(REPLACE ";" "\n" CMAKE_INSTALL_MANIFEST_CONTENT
       "${CMAKE_INSTALL_MANIFEST_FILES}")
file(WRITE "/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2/${CMAKE_INSTALL_MANIFEST}"
     "${CMAKE_INSTALL_MANIFEST_CONTENT}")
