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

# Utility rule file for EP_bzrtp.

# Include the progress variables for this target.
include CMakeFiles/EP_bzrtp.dir/progress.make

CMakeFiles/EP_bzrtp: CMakeFiles/EP_bzrtp-complete


CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-install
CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-mkdir
CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-download
CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-update
CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-patch
CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure
CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-build
CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-install
CMakeFiles/EP_bzrtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-force_build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Completed 'EP_bzrtp'"
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles/EP_bzrtp-complete
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp/EP_bzrtp-done

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-install: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Performing install step for 'EP_bzrtp'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/bzrtp && $(MAKE) install
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/bzrtp && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp/EP_bzrtp-install

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-mkdir:
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Creating directories for 'EP_bzrtp'"
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/submodules/bzrtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/bzrtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Install/EP_bzrtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//tmp/EP_bzrtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Download/EP_bzrtp
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp/EP_bzrtp-mkdir

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-download: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-mkdir
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "No download step for 'EP_bzrtp'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp/EP_bzrtp-download

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-update: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-download
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "No update step for 'EP_bzrtp'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp/EP_bzrtp-update

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-patch: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-download
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "No patch step for 'EP_bzrtp'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp/EP_bzrtp-patch

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bctoolbox/EP_bctoolbox-done
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_xml2/EP_xml2-done
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_sqlite3/EP_sqlite3-done
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bcunit/EP_bcunit-done
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/tmp/EP_bzrtp/EP_bzrtp-cfgcmd.txt
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-update
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-patch
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Performing configure step for 'EP_bzrtp'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/bzrtp && /usr/local/bin/cmake -DENABLE_TESTS=NO -DENABLE_STATIC=YES -DENABLE_SHARED=NO -C/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//tmp/EP_bzrtp/EP_bzrtp-cache-RelWithDebInfo.cmake "-GUnix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/bzrtp
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/bzrtp && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp/EP_bzrtp-configure

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure
/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-force_build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Performing build step for 'EP_bzrtp'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/bzrtp && $(MAKE)
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Build/bzrtp && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7//Stamp/EP_bzrtp/EP_bzrtp-build

/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-force_build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_9) "Forcing build for 'EP_bzrtp'"
	/usr/local/bin/cmake -E echo_append

EP_bzrtp: CMakeFiles/EP_bzrtp
EP_bzrtp: CMakeFiles/EP_bzrtp-complete
EP_bzrtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-install
EP_bzrtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-mkdir
EP_bzrtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-download
EP_bzrtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-update
EP_bzrtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-patch
EP_bzrtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-configure
EP_bzrtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-build
EP_bzrtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/Stamp/EP_bzrtp/EP_bzrtp-force_build
EP_bzrtp: CMakeFiles/EP_bzrtp.dir/build.make

.PHONY : EP_bzrtp

# Rule to build all files generated by this target.
CMakeFiles/EP_bzrtp.dir/build: EP_bzrtp

.PHONY : CMakeFiles/EP_bzrtp.dir/build

CMakeFiles/EP_bzrtp.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/EP_bzrtp.dir/cmake_clean.cmake
.PHONY : CMakeFiles/EP_bzrtp.dir/clean

CMakeFiles/EP_bzrtp.dir/depend:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake /home/vvdn/linphone/linphone-android-arpit/WORK/android-armv7/cmake/CMakeFiles/EP_bzrtp.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/EP_bzrtp.dir/depend
