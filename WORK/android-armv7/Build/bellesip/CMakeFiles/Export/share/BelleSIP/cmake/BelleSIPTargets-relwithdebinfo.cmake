#----------------------------------------------------------------
# Generated CMake target import file for configuration "RelWithDebInfo".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "bellesip-static" for configuration "RelWithDebInfo"
set_property(TARGET bellesip-static APPEND PROPERTY IMPORTED_CONFIGURATIONS RELWITHDEBINFO)
set_target_properties(bellesip-static PROPERTIES
  IMPORTED_LINK_INTERFACE_LANGUAGES_RELWITHDEBINFO "C"
  IMPORTED_LOCATION_RELWITHDEBINFO "${_IMPORT_PREFIX}/lib/libbellesip.a"
  )

list(APPEND _IMPORT_CHECK_TARGETS bellesip-static )
list(APPEND _IMPORT_CHECK_FILES_FOR_bellesip-static "${_IMPORT_PREFIX}/lib/libbellesip.a" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
