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
CMAKE_SOURCE_DIR = /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder/builders/androidsupport

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/androidsupport

# Include any dependencies generated for this target.
include CMakeFiles/support.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/support.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/support.dir/flags.make

CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o: CMakeFiles/support.dir/flags.make
CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o: /home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/androidsupport/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o"
	/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o   -c /home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c

CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.i"
	/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c > CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.i

CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.s"
	/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c -o CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.s

CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o.requires:

.PHONY : CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o.requires

CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o.provides: CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o.requires
	$(MAKE) -f CMakeFiles/support.dir/build.make CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o.provides.build
.PHONY : CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o.provides

CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o.provides.build: CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o


# Object files for target support
support_OBJECTS = \
"CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o"

# External object files for target support
support_EXTERNAL_OBJECTS =

libsupport.a: CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o
libsupport.a: CMakeFiles/support.dir/build.make
libsupport.a: CMakeFiles/support.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/androidsupport/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C static library libsupport.a"
	$(CMAKE_COMMAND) -P CMakeFiles/support.dir/cmake_clean_target.cmake
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/support.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/support.dir/build: libsupport.a

.PHONY : CMakeFiles/support.dir/build

CMakeFiles/support.dir/requires: CMakeFiles/support.dir/home/vvdn/android-ndk-r14b/sources/android/support/src/musl-multibyte/wctomb.c.o.requires

.PHONY : CMakeFiles/support.dir/requires

CMakeFiles/support.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/support.dir/cmake_clean.cmake
.PHONY : CMakeFiles/support.dir/clean

CMakeFiles/support.dir/depend:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/androidsupport && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder/builders/androidsupport /home/vvdn/linphone/linphone-android-arpit/submodules/cmake-builder/builders/androidsupport /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/androidsupport /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/androidsupport /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/androidsupport/CMakeFiles/support.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/support.dir/depend

