#----------------------------------------------------------------
# Generated CMake target import file for configuration "RelWithDebInfo".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "ortp" for configuration "RelWithDebInfo"
set_property(TARGET ortp APPEND PROPERTY IMPORTED_CONFIGURATIONS RELWITHDEBINFO)
set_target_properties(ortp PROPERTIES
  IMPORTED_LOCATION_RELWITHDEBINFO "${_IMPORT_PREFIX}/lib/libortp-x86.so"
  IMPORTED_SONAME_RELWITHDEBINFO "libortp-x86.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS ortp )
list(APPEND _IMPORT_CHECK_FILES_FOR_ortp "${_IMPORT_PREFIX}/lib/libortp-x86.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
