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
CMAKE_SOURCE_DIR = /home/vvdn/linphone/linphone-android-arpit/submodules/belr

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr

# Include any dependencies generated for this target.
include src/CMakeFiles/belr-static.dir/depend.make

# Include the progress variables for this target.
include src/CMakeFiles/belr-static.dir/progress.make

# Include the compile flags for this target's objects.
include src/CMakeFiles/belr-static.dir/flags.make

src/CMakeFiles/belr-static.dir/abnf.cc.o: src/CMakeFiles/belr-static.dir/flags.make
src/CMakeFiles/belr-static.dir/abnf.cc.o: /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/abnf.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object src/CMakeFiles/belr-static.dir/abnf.cc.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -o CMakeFiles/belr-static.dir/abnf.cc.o -c /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/abnf.cc

src/CMakeFiles/belr-static.dir/abnf.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/belr-static.dir/abnf.cc.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -E /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/abnf.cc > CMakeFiles/belr-static.dir/abnf.cc.i

src/CMakeFiles/belr-static.dir/abnf.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/belr-static.dir/abnf.cc.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -S /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/abnf.cc -o CMakeFiles/belr-static.dir/abnf.cc.s

src/CMakeFiles/belr-static.dir/abnf.cc.o.requires:

.PHONY : src/CMakeFiles/belr-static.dir/abnf.cc.o.requires

src/CMakeFiles/belr-static.dir/abnf.cc.o.provides: src/CMakeFiles/belr-static.dir/abnf.cc.o.requires
	$(MAKE) -f src/CMakeFiles/belr-static.dir/build.make src/CMakeFiles/belr-static.dir/abnf.cc.o.provides.build
.PHONY : src/CMakeFiles/belr-static.dir/abnf.cc.o.provides

src/CMakeFiles/belr-static.dir/abnf.cc.o.provides.build: src/CMakeFiles/belr-static.dir/abnf.cc.o


src/CMakeFiles/belr-static.dir/belr.cc.o: src/CMakeFiles/belr-static.dir/flags.make
src/CMakeFiles/belr-static.dir/belr.cc.o: /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/belr.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object src/CMakeFiles/belr-static.dir/belr.cc.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -o CMakeFiles/belr-static.dir/belr.cc.o -c /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/belr.cc

src/CMakeFiles/belr-static.dir/belr.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/belr-static.dir/belr.cc.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -E /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/belr.cc > CMakeFiles/belr-static.dir/belr.cc.i

src/CMakeFiles/belr-static.dir/belr.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/belr-static.dir/belr.cc.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -S /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/belr.cc -o CMakeFiles/belr-static.dir/belr.cc.s

src/CMakeFiles/belr-static.dir/belr.cc.o.requires:

.PHONY : src/CMakeFiles/belr-static.dir/belr.cc.o.requires

src/CMakeFiles/belr-static.dir/belr.cc.o.provides: src/CMakeFiles/belr-static.dir/belr.cc.o.requires
	$(MAKE) -f src/CMakeFiles/belr-static.dir/build.make src/CMakeFiles/belr-static.dir/belr.cc.o.provides.build
.PHONY : src/CMakeFiles/belr-static.dir/belr.cc.o.provides

src/CMakeFiles/belr-static.dir/belr.cc.o.provides.build: src/CMakeFiles/belr-static.dir/belr.cc.o


src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o: src/CMakeFiles/belr-static.dir/flags.make
src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o: /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/grammarbuilder.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -o CMakeFiles/belr-static.dir/grammarbuilder.cc.o -c /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/grammarbuilder.cc

src/CMakeFiles/belr-static.dir/grammarbuilder.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/belr-static.dir/grammarbuilder.cc.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -E /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/grammarbuilder.cc > CMakeFiles/belr-static.dir/grammarbuilder.cc.i

src/CMakeFiles/belr-static.dir/grammarbuilder.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/belr-static.dir/grammarbuilder.cc.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -S /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/grammarbuilder.cc -o CMakeFiles/belr-static.dir/grammarbuilder.cc.s

src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o.requires:

.PHONY : src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o.requires

src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o.provides: src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o.requires
	$(MAKE) -f src/CMakeFiles/belr-static.dir/build.make src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o.provides.build
.PHONY : src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o.provides

src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o.provides.build: src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o


src/CMakeFiles/belr-static.dir/parser.cc.o: src/CMakeFiles/belr-static.dir/flags.make
src/CMakeFiles/belr-static.dir/parser.cc.o: /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/parser.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object src/CMakeFiles/belr-static.dir/parser.cc.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -o CMakeFiles/belr-static.dir/parser.cc.o -c /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/parser.cc

src/CMakeFiles/belr-static.dir/parser.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/belr-static.dir/parser.cc.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -E /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/parser.cc > CMakeFiles/belr-static.dir/parser.cc.i

src/CMakeFiles/belr-static.dir/parser.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/belr-static.dir/parser.cc.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=i686-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-14/arch-x86 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=deprecated-declarations -Qunused-arguments -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -fno-strict-aliasing -std=c++11 -S /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src/parser.cc -o CMakeFiles/belr-static.dir/parser.cc.s

src/CMakeFiles/belr-static.dir/parser.cc.o.requires:

.PHONY : src/CMakeFiles/belr-static.dir/parser.cc.o.requires

src/CMakeFiles/belr-static.dir/parser.cc.o.provides: src/CMakeFiles/belr-static.dir/parser.cc.o.requires
	$(MAKE) -f src/CMakeFiles/belr-static.dir/build.make src/CMakeFiles/belr-static.dir/parser.cc.o.provides.build
.PHONY : src/CMakeFiles/belr-static.dir/parser.cc.o.provides

src/CMakeFiles/belr-static.dir/parser.cc.o.provides.build: src/CMakeFiles/belr-static.dir/parser.cc.o


# Object files for target belr-static
belr__static_OBJECTS = \
"CMakeFiles/belr-static.dir/abnf.cc.o" \
"CMakeFiles/belr-static.dir/belr.cc.o" \
"CMakeFiles/belr-static.dir/grammarbuilder.cc.o" \
"CMakeFiles/belr-static.dir/parser.cc.o"

# External object files for target belr-static
belr__static_EXTERNAL_OBJECTS =

src/libbelr.a: src/CMakeFiles/belr-static.dir/abnf.cc.o
src/libbelr.a: src/CMakeFiles/belr-static.dir/belr.cc.o
src/libbelr.a: src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o
src/libbelr.a: src/CMakeFiles/belr-static.dir/parser.cc.o
src/libbelr.a: src/CMakeFiles/belr-static.dir/build.make
src/libbelr.a: src/CMakeFiles/belr-static.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Linking CXX static library libbelr.a"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && $(CMAKE_COMMAND) -P CMakeFiles/belr-static.dir/cmake_clean_target.cmake
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/belr-static.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/CMakeFiles/belr-static.dir/build: src/libbelr.a

.PHONY : src/CMakeFiles/belr-static.dir/build

src/CMakeFiles/belr-static.dir/requires: src/CMakeFiles/belr-static.dir/abnf.cc.o.requires
src/CMakeFiles/belr-static.dir/requires: src/CMakeFiles/belr-static.dir/belr.cc.o.requires
src/CMakeFiles/belr-static.dir/requires: src/CMakeFiles/belr-static.dir/grammarbuilder.cc.o.requires
src/CMakeFiles/belr-static.dir/requires: src/CMakeFiles/belr-static.dir/parser.cc.o.requires

.PHONY : src/CMakeFiles/belr-static.dir/requires

src/CMakeFiles/belr-static.dir/clean:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src && $(CMAKE_COMMAND) -P CMakeFiles/belr-static.dir/cmake_clean.cmake
.PHONY : src/CMakeFiles/belr-static.dir/clean

src/CMakeFiles/belr-static.dir/depend:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/belr /home/vvdn/linphone/linphone-android-arpit/submodules/belr/src /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src /home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/belr/src/CMakeFiles/belr-static.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : src/CMakeFiles/belr-static.dir/depend

