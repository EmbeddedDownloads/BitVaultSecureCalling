#!/bin/sh

if [ -n "" ]
then
	export AS="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang"
else
	if [ -n "" ]
	then
		export AS=""
	fi
fi
export CC="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang"
export CXX="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++"
export OBJC="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang"
export LD="/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64/bin/aarch64-linux-android-ld"
export AR="/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64/bin/aarch64-linux-android-ar"
export RANLIB="/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64/bin/aarch64-linux-android-ranlib"
export STRIP="/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64/bin/aarch64-linux-android-strip"
export NM="/home/vvdn/android-ndk-r14b/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64/bin/aarch64-linux-android-nm"
export CC_NO_LAUNCHER="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang"
export CXX_NO_LAUNCHER="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++"
export OBJC_NO_LAUNCHER="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang"

ASFLAGS=" "
CPPFLAGS="  -w"
CFLAGS=" "
CXXFLAGS=" "
OBJCFLAGS=" "
LDFLAGS=" "

export PATH="$PATH:/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/cmake/programs"
export PKG_CONFIG="/usr/bin/pkg-config"
export PKG_CONFIG_PATH=""
export PKG_CONFIG_LIBDIR=""

cd "/home/vvdn/linphone/linphone-android-arpit/WORK/android-arm64/Build/vpx"
make V=0  install 
