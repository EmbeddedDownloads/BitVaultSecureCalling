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
CMAKE_BINARY_DIR = /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake

# Utility rule file for EP_srtp.

# Include the progress variables for this target.
include CMakeFiles/EP_srtp.dir/progress.make

CMakeFiles/EP_srtp: CMakeFiles/EP_srtp-complete


CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-install
CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-mkdir
CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-download
CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-update
CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-patch
CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-configure
CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-build
CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-install
CMakeFiles/EP_srtp-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-force_build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Completed 'EP_srtp'"
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles/EP_srtp-complete
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp/EP_srtp-done

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-install: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Performing install step for 'EP_srtp'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/srtp && $(MAKE) install
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/srtp && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp/EP_srtp-install

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-mkdir:
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Creating directories for 'EP_srtp'"
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/srtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Install/EP_srtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//tmp/EP_srtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Download/EP_srtp
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp/EP_srtp-mkdir

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-download: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-mkdir
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "No download step for 'EP_srtp'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp/EP_srtp-download

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-update: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-download
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "No update step for 'EP_srtp'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp/EP_srtp-update

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-patch: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-download
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "No patch step for 'EP_srtp'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp/EP_srtp-patch

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/tmp/EP_srtp/EP_srtp-cfgcmd.txt
/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-update
/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-patch
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Performing configure step for 'EP_srtp'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/srtp && /usr/local/bin/cmake -DENABLE_STATIC=YES -DENABLE_SHARED=NO -C/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//tmp/EP_srtp/EP_srtp-cache-RelWithDebInfo.cmake "-GUnix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/externals/srtp
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/srtp && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp/EP_srtp-configure

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-configure
/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-force_build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Performing build step for 'EP_srtp'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/srtp && $(MAKE)
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/srtp && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_srtp/EP_srtp-build

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-force_build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-configure
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_9) "Forcing build for 'EP_srtp'"
	/usr/local/bin/cmake -E echo_append

EP_srtp: CMakeFiles/EP_srtp
EP_srtp: CMakeFiles/EP_srtp-complete
EP_srtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-install
EP_srtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-mkdir
EP_srtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-download
EP_srtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-update
EP_srtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-patch
EP_srtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-configure
EP_srtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-build
EP_srtp: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_srtp/EP_srtp-force_build
EP_srtp: CMakeFiles/EP_srtp.dir/build.make

.PHONY : EP_srtp

# Rule to build all files generated by this target.
CMakeFiles/EP_srtp.dir/build: EP_srtp

.PHONY : CMakeFiles/EP_srtp.dir/build

CMakeFiles/EP_srtp.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/EP_srtp.dir/cmake_clean.cmake
.PHONY : CMakeFiles/EP_srtp.dir/clean

CMakeFiles/EP_srtp.dir/depend:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles/EP_srtp.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/EP_srtp.dir/depend

