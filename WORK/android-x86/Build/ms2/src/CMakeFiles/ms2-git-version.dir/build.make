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
CMAKE_SOURCE_DIR = /home/vvdn/linphone/linphone-android-arpit/submodules/mediastreamer2

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/ms2

# Utility rule file for ms2-git-version.

# Include the progress variables for this target.
include src/CMakeFiles/ms2-git-version.dir/progress.make

src/CMakeFiles/ms2-git-version:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/ms2/src && /usr/local/bin/cmake -DGIT_EXECUTABLE=/usr/bin/git -DMEDIASTREAMER_VERSION=2.15.1 -DWORK_DIR=/home/vvdn/linphone/linphone-android-arpit/submodules/mediastreamer2/src -DOUTPUT_DIR=/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/ms2/src -P /home/vvdn/linphone/linphone-android-arpit/submodules/mediastreamer2/src/gitversion.cmake

ms2-git-version: src/CMakeFiles/ms2-git-version
ms2-git-version: src/CMakeFiles/ms2-git-version.dir/build.make

.PHONY : ms2-git-version

# Rule to build all files generated by this target.
src/CMakeFiles/ms2-git-version.dir/build: ms2-git-version

.PHONY : src/CMakeFiles/ms2-git-version.dir/build

src/CMakeFiles/ms2-git-version.dir/clean:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/ms2/src && $(CMAKE_COMMAND) -P CMakeFiles/ms2-git-version.dir/cmake_clean.cmake
.PHONY : src/CMakeFiles/ms2-git-version.dir/clean

src/CMakeFiles/ms2-git-version.dir/depend:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/ms2 && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/mediastreamer2 /home/vvdn/linphone/linphone-android-arpit/submodules/mediastreamer2/src /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/ms2 /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/ms2/src /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/ms2/src/CMakeFiles/ms2-git-version.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : src/CMakeFiles/ms2-git-version.dir/depend

