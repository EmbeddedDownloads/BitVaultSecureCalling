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
CMAKE_SOURCE_DIR = /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox

# Include any dependencies generated for this target.
include src/CMakeFiles/bctoolbox.dir/depend.make

# Include the progress variables for this target.
include src/CMakeFiles/bctoolbox.dir/progress.make

# Include the compile flags for this target's objects.
include src/CMakeFiles/bctoolbox.dir/flags.make

src/CMakeFiles/bctoolbox.dir/containers/list.c.o: src/CMakeFiles/bctoolbox.dir/flags.make
src/CMakeFiles/bctoolbox.dir/containers/list.c.o: /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/containers/list.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object src/CMakeFiles/bctoolbox.dir/containers/list.c.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -o CMakeFiles/bctoolbox.dir/containers/list.c.o   -c /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/containers/list.c

src/CMakeFiles/bctoolbox.dir/containers/list.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/bctoolbox.dir/containers/list.c.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -E /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/containers/list.c > CMakeFiles/bctoolbox.dir/containers/list.c.i

src/CMakeFiles/bctoolbox.dir/containers/list.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/bctoolbox.dir/containers/list.c.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -S /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/containers/list.c -o CMakeFiles/bctoolbox.dir/containers/list.c.s

src/CMakeFiles/bctoolbox.dir/containers/list.c.o.requires:

.PHONY : src/CMakeFiles/bctoolbox.dir/containers/list.c.o.requires

src/CMakeFiles/bctoolbox.dir/containers/list.c.o.provides: src/CMakeFiles/bctoolbox.dir/containers/list.c.o.requires
	$(MAKE) -f src/CMakeFiles/bctoolbox.dir/build.make src/CMakeFiles/bctoolbox.dir/containers/list.c.o.provides.build
.PHONY : src/CMakeFiles/bctoolbox.dir/containers/list.c.o.provides

src/CMakeFiles/bctoolbox.dir/containers/list.c.o.provides.build: src/CMakeFiles/bctoolbox.dir/containers/list.c.o


src/CMakeFiles/bctoolbox.dir/logging/logging.c.o: src/CMakeFiles/bctoolbox.dir/flags.make
src/CMakeFiles/bctoolbox.dir/logging/logging.c.o: /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/logging/logging.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object src/CMakeFiles/bctoolbox.dir/logging/logging.c.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -o CMakeFiles/bctoolbox.dir/logging/logging.c.o   -c /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/logging/logging.c

src/CMakeFiles/bctoolbox.dir/logging/logging.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/bctoolbox.dir/logging/logging.c.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -E /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/logging/logging.c > CMakeFiles/bctoolbox.dir/logging/logging.c.i

src/CMakeFiles/bctoolbox.dir/logging/logging.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/bctoolbox.dir/logging/logging.c.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -S /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/logging/logging.c -o CMakeFiles/bctoolbox.dir/logging/logging.c.s

src/CMakeFiles/bctoolbox.dir/logging/logging.c.o.requires:

.PHONY : src/CMakeFiles/bctoolbox.dir/logging/logging.c.o.requires

src/CMakeFiles/bctoolbox.dir/logging/logging.c.o.provides: src/CMakeFiles/bctoolbox.dir/logging/logging.c.o.requires
	$(MAKE) -f src/CMakeFiles/bctoolbox.dir/build.make src/CMakeFiles/bctoolbox.dir/logging/logging.c.o.provides.build
.PHONY : src/CMakeFiles/bctoolbox.dir/logging/logging.c.o.provides

src/CMakeFiles/bctoolbox.dir/logging/logging.c.o.provides.build: src/CMakeFiles/bctoolbox.dir/logging/logging.c.o


src/CMakeFiles/bctoolbox.dir/utils/port.c.o: src/CMakeFiles/bctoolbox.dir/flags.make
src/CMakeFiles/bctoolbox.dir/utils/port.c.o: /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/utils/port.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building C object src/CMakeFiles/bctoolbox.dir/utils/port.c.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -o CMakeFiles/bctoolbox.dir/utils/port.c.o   -c /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/utils/port.c

src/CMakeFiles/bctoolbox.dir/utils/port.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/bctoolbox.dir/utils/port.c.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -E /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/utils/port.c > CMakeFiles/bctoolbox.dir/utils/port.c.i

src/CMakeFiles/bctoolbox.dir/utils/port.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/bctoolbox.dir/utils/port.c.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -S /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/utils/port.c -o CMakeFiles/bctoolbox.dir/utils/port.c.s

src/CMakeFiles/bctoolbox.dir/utils/port.c.o.requires:

.PHONY : src/CMakeFiles/bctoolbox.dir/utils/port.c.o.requires

src/CMakeFiles/bctoolbox.dir/utils/port.c.o.provides: src/CMakeFiles/bctoolbox.dir/utils/port.c.o.requires
	$(MAKE) -f src/CMakeFiles/bctoolbox.dir/build.make src/CMakeFiles/bctoolbox.dir/utils/port.c.o.provides.build
.PHONY : src/CMakeFiles/bctoolbox.dir/utils/port.c.o.provides

src/CMakeFiles/bctoolbox.dir/utils/port.c.o.provides.build: src/CMakeFiles/bctoolbox.dir/utils/port.c.o


src/CMakeFiles/bctoolbox.dir/vfs.c.o: src/CMakeFiles/bctoolbox.dir/flags.make
src/CMakeFiles/bctoolbox.dir/vfs.c.o: /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/vfs.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building C object src/CMakeFiles/bctoolbox.dir/vfs.c.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -o CMakeFiles/bctoolbox.dir/vfs.c.o   -c /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/vfs.c

src/CMakeFiles/bctoolbox.dir/vfs.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/bctoolbox.dir/vfs.c.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -E /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/vfs.c > CMakeFiles/bctoolbox.dir/vfs.c.i

src/CMakeFiles/bctoolbox.dir/vfs.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/bctoolbox.dir/vfs.c.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -S /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/vfs.c -o CMakeFiles/bctoolbox.dir/vfs.c.s

src/CMakeFiles/bctoolbox.dir/vfs.c.o.requires:

.PHONY : src/CMakeFiles/bctoolbox.dir/vfs.c.o.requires

src/CMakeFiles/bctoolbox.dir/vfs.c.o.provides: src/CMakeFiles/bctoolbox.dir/vfs.c.o.requires
	$(MAKE) -f src/CMakeFiles/bctoolbox.dir/build.make src/CMakeFiles/bctoolbox.dir/vfs.c.o.provides.build
.PHONY : src/CMakeFiles/bctoolbox.dir/vfs.c.o.provides

src/CMakeFiles/bctoolbox.dir/vfs.c.o.provides.build: src/CMakeFiles/bctoolbox.dir/vfs.c.o


src/CMakeFiles/bctoolbox.dir/vconnect.c.o: src/CMakeFiles/bctoolbox.dir/flags.make
src/CMakeFiles/bctoolbox.dir/vconnect.c.o: /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/vconnect.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building C object src/CMakeFiles/bctoolbox.dir/vconnect.c.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -o CMakeFiles/bctoolbox.dir/vconnect.c.o   -c /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/vconnect.c

src/CMakeFiles/bctoolbox.dir/vconnect.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/bctoolbox.dir/vconnect.c.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -E /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/vconnect.c > CMakeFiles/bctoolbox.dir/vconnect.c.i

src/CMakeFiles/bctoolbox.dir/vconnect.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/bctoolbox.dir/vconnect.c.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -S /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/vconnect.c -o CMakeFiles/bctoolbox.dir/vconnect.c.s

src/CMakeFiles/bctoolbox.dir/vconnect.c.o.requires:

.PHONY : src/CMakeFiles/bctoolbox.dir/vconnect.c.o.requires

src/CMakeFiles/bctoolbox.dir/vconnect.c.o.provides: src/CMakeFiles/bctoolbox.dir/vconnect.c.o.requires
	$(MAKE) -f src/CMakeFiles/bctoolbox.dir/build.make src/CMakeFiles/bctoolbox.dir/vconnect.c.o.provides.build
.PHONY : src/CMakeFiles/bctoolbox.dir/vconnect.c.o.provides

src/CMakeFiles/bctoolbox.dir/vconnect.c.o.provides.build: src/CMakeFiles/bctoolbox.dir/vconnect.c.o


src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o: src/CMakeFiles/bctoolbox.dir/flags.make
src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o: /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/crypto/mbedtls.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building C object src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -o CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o   -c /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/crypto/mbedtls.c

src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -E /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/crypto/mbedtls.c > CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.i

src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -Werror -Wdeclaration-after-statement -Wstrict-prototypes -S /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/crypto/mbedtls.c -o CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.s

src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o.requires:

.PHONY : src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o.requires

src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o.provides: src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o.requires
	$(MAKE) -f src/CMakeFiles/bctoolbox.dir/build.make src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o.provides.build
.PHONY : src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o.provides

src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o.provides.build: src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o


src/CMakeFiles/bctoolbox.dir/containers/map.cc.o: src/CMakeFiles/bctoolbox.dir/flags.make
src/CMakeFiles/bctoolbox.dir/containers/map.cc.o: /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/containers/map.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Building CXX object src/CMakeFiles/bctoolbox.dir/containers/map.cc.o"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -o CMakeFiles/bctoolbox.dir/containers/map.cc.o -c /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/containers/map.cc

src/CMakeFiles/bctoolbox.dir/containers/map.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/bctoolbox.dir/containers/map.cc.i"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -E /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/containers/map.cc > CMakeFiles/bctoolbox.dir/containers/map.cc.i

src/CMakeFiles/bctoolbox.dir/containers/map.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/bctoolbox.dir/containers/map.cc.s"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && /home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++ --target=aarch64-none-linux-android --gcc-toolchain=/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64 --sysroot=/home/vvdn/android-ndk-r14b/platforms/android-21/arch-arm64 $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS)  -Wall -Wuninitialized -Wno-error=unknown-warning-option -Qunused-arguments -Wno-tautological-compare -Wno-builtin-requires-header -Wno-unused-function -Wno-gnu-designator -Wno-array-bounds -Werror -Wextra -Wno-unused-parameter -Wno-error=unknown-pragmas -Wno-missing-field-initializers -fno-strict-aliasing -S /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src/containers/map.cc -o CMakeFiles/bctoolbox.dir/containers/map.cc.s

src/CMakeFiles/bctoolbox.dir/containers/map.cc.o.requires:

.PHONY : src/CMakeFiles/bctoolbox.dir/containers/map.cc.o.requires

src/CMakeFiles/bctoolbox.dir/containers/map.cc.o.provides: src/CMakeFiles/bctoolbox.dir/containers/map.cc.o.requires
	$(MAKE) -f src/CMakeFiles/bctoolbox.dir/build.make src/CMakeFiles/bctoolbox.dir/containers/map.cc.o.provides.build
.PHONY : src/CMakeFiles/bctoolbox.dir/containers/map.cc.o.provides

src/CMakeFiles/bctoolbox.dir/containers/map.cc.o.provides.build: src/CMakeFiles/bctoolbox.dir/containers/map.cc.o


# Object files for target bctoolbox
bctoolbox_OBJECTS = \
"CMakeFiles/bctoolbox.dir/containers/list.c.o" \
"CMakeFiles/bctoolbox.dir/logging/logging.c.o" \
"CMakeFiles/bctoolbox.dir/utils/port.c.o" \
"CMakeFiles/bctoolbox.dir/vfs.c.o" \
"CMakeFiles/bctoolbox.dir/vconnect.c.o" \
"CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o" \
"CMakeFiles/bctoolbox.dir/containers/map.cc.o"

# External object files for target bctoolbox
bctoolbox_EXTERNAL_OBJECTS =

src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/containers/list.c.o
src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/logging/logging.c.o
src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/utils/port.c.o
src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/vfs.c.o
src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/vconnect.c.o
src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o
src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/containers/map.cc.o
src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/build.make
src/libbctoolbox-arm64-v8a.so: /home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-arm64/lib/libmbedtls.a
src/libbctoolbox-arm64-v8a.so: /home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-arm64/lib/libmbedx509.a
src/libbctoolbox-arm64-v8a.so: /home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-arm64/lib/libmbedcrypto.a
src/libbctoolbox-arm64-v8a.so: src/CMakeFiles/bctoolbox.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Linking CXX shared library libbctoolbox-arm64-v8a.so"
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/bctoolbox.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/CMakeFiles/bctoolbox.dir/build: src/libbctoolbox-arm64-v8a.so

.PHONY : src/CMakeFiles/bctoolbox.dir/build

src/CMakeFiles/bctoolbox.dir/requires: src/CMakeFiles/bctoolbox.dir/containers/list.c.o.requires
src/CMakeFiles/bctoolbox.dir/requires: src/CMakeFiles/bctoolbox.dir/logging/logging.c.o.requires
src/CMakeFiles/bctoolbox.dir/requires: src/CMakeFiles/bctoolbox.dir/utils/port.c.o.requires
src/CMakeFiles/bctoolbox.dir/requires: src/CMakeFiles/bctoolbox.dir/vfs.c.o.requires
src/CMakeFiles/bctoolbox.dir/requires: src/CMakeFiles/bctoolbox.dir/vconnect.c.o.requires
src/CMakeFiles/bctoolbox.dir/requires: src/CMakeFiles/bctoolbox.dir/crypto/mbedtls.c.o.requires
src/CMakeFiles/bctoolbox.dir/requires: src/CMakeFiles/bctoolbox.dir/containers/map.cc.o.requires

.PHONY : src/CMakeFiles/bctoolbox.dir/requires

src/CMakeFiles/bctoolbox.dir/clean:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src && $(CMAKE_COMMAND) -P CMakeFiles/bctoolbox.dir/cmake_clean.cmake
.PHONY : src/CMakeFiles/bctoolbox.dir/clean

src/CMakeFiles/bctoolbox.dir/depend:
	cd /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox /home/vvdn/linphone/linphone-android-arpit/submodules/bctoolbox/src /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src /home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/bctoolbox/src/CMakeFiles/bctoolbox.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : src/CMakeFiles/bctoolbox.dir/depend

