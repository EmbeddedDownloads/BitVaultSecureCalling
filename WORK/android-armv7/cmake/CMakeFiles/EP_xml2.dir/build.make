# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.8

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/local/bin/cmake

# The command to remove a file.
RM = /usr/local/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake

# Utility rule file for EP_xml2.

# Include the progress variables for this target.
include CMakeFiles/EP_xml2.dir/progress.make

CMakeFiles/EP_xml2: CMakeFiles/EP_xml2-complete


CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-install
CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-mkdir
CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-download
CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-update
CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-patch
CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-configure
CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-build
CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-install
CMakeFiles/EP_xml2-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-force_build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Completed 'EP_xml2'"
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles/EP_xml2-complete
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2/EP_xml2-done

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-install: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Performing install step for 'EP_xml2'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2 && $(MAKE) install
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2 && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2/EP_xml2-install

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-mkdir:
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Creating directories for 'EP_xml2'"
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Install/EP_xml2
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//tmp/EP_xml2
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Download/EP_xml2
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2/EP_xml2-mkdir

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-download: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-mkdir
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "No download step for 'EP_xml2'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2/EP_xml2-download

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-update: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-download
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "No update step for 'EP_xml2'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2/EP_xml2-update

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-patch: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-download
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Performing patch step for 'EP_xml2'"
	cd /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2 && /usr/local/bin/cmake -E copy /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder/builders/xml2/CMakeLists.txt /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2
	cd /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2 && /usr/local/bin/cmake -E copy /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder/builders/xml2/config.h.cmake /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2
	cd /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2 && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2/EP_xml2-patch

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/tmp/EP_xml2/EP_xml2-cfgcmd.txt
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-update
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-patch
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Performing configure step for 'EP_xml2'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2 && /usr/local/bin/cmake -DENABLE_STATIC=YES -DENABLE_SHARED=NO -C/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//tmp/EP_xml2/EP_xml2-cache-RelWithDebInfo.cmake "-GUnix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/externals/libxml2
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2 && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2/EP_xml2-configure

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-configure
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-force_build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Performing build step for 'EP_xml2'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2 && $(MAKE)
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/xml2 && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_xml2/EP_xml2-build

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-force_build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-configure
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_9) "Forcing build for 'EP_xml2'"
	/usr/local/bin/cmake -E echo_append

EP_xml2: CMakeFiles/EP_xml2
EP_xml2: CMakeFiles/EP_xml2-complete
EP_xml2: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-install
EP_xml2: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-mkdir
EP_xml2: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-download
EP_xml2: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-update
EP_xml2: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-patch
EP_xml2: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-configure
EP_xml2: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-build
EP_xml2: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-force_build
EP_xml2: CMakeFiles/EP_xml2.dir/build.make

.PHONY : EP_xml2

# Rule to build all files generated by this target.
CMakeFiles/EP_xml2.dir/build: EP_xml2

.PHONY : CMakeFiles/EP_xml2.dir/build

CMakeFiles/EP_xml2.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/EP_xml2.dir/cmake_clean.cmake
.PHONY : CMakeFiles/EP_xml2.dir/clean

CMakeFiles/EP_xml2.dir/depend:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles/EP_xml2.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/EP_xml2.dir/depend

