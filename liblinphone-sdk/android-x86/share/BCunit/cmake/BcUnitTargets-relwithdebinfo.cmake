#----------------------------------------------------------------
# Generated CMake target import file for configuration "RelWithDebInfo".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "bcunit-static" for configuration "RelWithDebInfo"
set_property(TARGET bcunit-static APPEND PROPERTY IMPORTED_CONFIGURATIONS RELWITHDEBINFO)
set_target_properties(bcunit-static PROPERTIES
  IMPORTED_LINK_INTERFACE_LANGUAGES_RELWITHDEBINFO "C"
  IMPORTED_LOCATION_RELWITHDEBINFO "${_IMPORT_PREFIX}/lib/libbcunit.a"
  )

list(APPEND _IMPORT_CHECK_TARGETS bcunit-static )
list(APPEND _IMPORT_CHECK_FILES_FOR_bcunit-static "${_IMPORT_PREFIX}/lib/libbcunit.a" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
