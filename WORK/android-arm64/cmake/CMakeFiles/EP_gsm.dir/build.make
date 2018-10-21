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

# Utility rule file for EP_gsm.

# Include the progress variables for this target.
include CMakeFiles/EP_gsm.dir/progress.make

CMakeFiles/EP_gsm: CMakeFiles/EP_gsm-complete


CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-install
CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-mkdir
CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-download
CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-update
CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-patch
CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-configure
CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-build
CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-install
CMakeFiles/EP_gsm-complete: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-force_build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Completed 'EP_gsm'"
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles/EP_gsm-complete
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm/EP_gsm-done

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-install: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Performing install step for 'EP_gsm'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/gsm && $(MAKE) install
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/gsm && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm/EP_gsm-install

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-mkdir:
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Creating directories for 'EP_gsm'"
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/submodules/externals/gsm
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/gsm
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Install/EP_gsm
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//tmp/EP_gsm
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm
	/usr/local/bin/cmake -E make_directory /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Download/EP_gsm
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm/EP_gsm-mkdir

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-download: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-mkdir
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "No download step for 'EP_gsm'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm/EP_gsm-download

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-update: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-download
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "No update step for 'EP_gsm'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm/EP_gsm-update

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-patch: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-download
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "No patch step for 'EP_gsm'"
	/usr/local/bin/cmake -E echo_append
	/usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm/EP_gsm-patch

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/tmp/EP_gsm/EP_gsm-cfgcmd.txt
/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-update
/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-configure: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-patch
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Performing configure step for 'EP_gsm'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/gsm && /usr/local/bin/cmake -DENABLE_STATIC=YES -DENABLE_SHARED=NO -C/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//tmp/EP_gsm/EP_gsm-cache-RelWithDebInfo.cmake "-GUnix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/externals/gsm
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/gsm && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm/EP_gsm-configure

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-configure
/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-force_build
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Performing build step for 'EP_gsm'"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/gsm && $(MAKE)
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/gsm && /usr/local/bin/cmake -E touch /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64//Stamp/EP_gsm/EP_gsm-build

/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-force_build: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-configure
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles --progress-num=$(CMAKE_PROGRESS_9) "Forcing build for 'EP_gsm'"
	/usr/local/bin/cmake -E echo_append

EP_gsm: CMakeFiles/EP_gsm
EP_gsm: CMakeFiles/EP_gsm-complete
EP_gsm: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-install
EP_gsm: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-mkdir
EP_gsm: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-download
EP_gsm: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-update
EP_gsm: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-patch
EP_gsm: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-configure
EP_gsm: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-build
EP_gsm: /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Stamp/EP_gsm/EP_gsm-force_build
EP_gsm: CMakeFiles/EP_gsm.dir/build.make

.PHONY : EP_gsm

# Rule to build all files generated by this target.
CMakeFiles/EP_gsm.dir/build: EP_gsm

.PHONY : CMakeFiles/EP_gsm.dir/build

CMakeFiles/EP_gsm.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/EP_gsm.dir/cmake_clean.cmake
.PHONY : CMakeFiles/EP_gsm.dir/clean

CMakeFiles/EP_gsm.dir/depend:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/CMakeFiles/EP_gsm.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/EP_gsm.dir/depend

