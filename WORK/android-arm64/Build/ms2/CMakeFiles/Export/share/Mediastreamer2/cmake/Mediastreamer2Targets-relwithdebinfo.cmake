#----------------------------------------------------------------
# Generated CMake target import file for configuration "RelWithDebInfo".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "mediastreamer_base" for configuration "RelWithDebInfo"
set_property(TARGET mediastreamer_base APPEND PROPERTY IMPORTED_CONFIGURATIONS RELWITHDEBINFO)
set_target_properties(mediastreamer_base PROPERTIES
  IMPORTED_LOCATION_RELWITHDEBINFO "${_IMPORT_PREFIX}/lib/libmediastreamer_base-arm64-v8a.so"
  IMPORTED_SONAME_RELWITHDEBINFO "libmediastreamer_base-arm64-v8a.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS mediastreamer_base )
list(APPEND _IMPORT_CHECK_FILES_FOR_mediastreamer_base "${_IMPORT_PREFIX}/lib/libmediastreamer_base-arm64-v8a.so" )

# Import target "mediastreamer_voip" for configuration "RelWithDebInfo"
set_property(TARGET mediastreamer_voip APPEND PROPERTY IMPORTED_CONFIGURATIONS RELWITHDEBINFO)
set_target_properties(mediastreamer_voip PROPERTIES
  IMPORTED_LOCATION_RELWITHDEBINFO "${_IMPORT_PREFIX}/lib/libmediastreamer_voip-arm64-v8a.so"
  IMPORTED_SONAME_RELWITHDEBINFO "libmediastreamer_voip-arm64-v8a.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS mediastreamer_voip )
list(APPEND _IMPORT_CHECK_FILES_FOR_mediastreamer_voip "${_IMPORT_PREFIX}/lib/libmediastreamer_voip-arm64-v8a.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
