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
export LD="/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64/bin/i686-linux-android-ld"
export AR="/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64/bin/i686-linux-android-ar"
export RANLIB="/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64/bin/i686-linux-android-ranlib"
export STRIP="/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64/bin/i686-linux-android-strip"
export NM="/home/vvdn/android-ndk-r14b/toolchains/x86-4.9/prebuilt/linux-x86_64/bin/i686-linux-android-nm"
export CC_NO_LAUNCHER="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang"
export CXX_NO_LAUNCHER="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang++"
export OBJC_NO_LAUNCHER="/home/vvdn/android-ndk-r14b/toolchains/llvm/prebuilt/linux-x86_64/bin/clang"

ASFLAGS=" "
CPPFLAGS="  -w"
CFLAGS=" "
CXXFLAGS=" "
OBJCFLAGS=" "
LDFLAGS=" "

export PATH="$PATH:/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/cmake/programs"
export PKG_CONFIG="/usr/bin/pkg-config"
export PKG_CONFIG_PATH=""
export PKG_CONFIG_LIBDIR=""

cd "/home/vvdn/linphone/linphone-android-arpit/WORK/android-x86/Build/vpx"

if [ ! -f "vpx_config.h" ]
then
	 
	CC=$CC_NO_LAUNCHER LD=$CC_NO_LAUNCHER ASFLAGS=$ASFLAGS CFLAGS=$CFLAGS LDFLAGS=$LDFLAGS "/home/vvdn/linphone/linphone-android-arpit/submodules/externals/libvpx/configure"  "--prefix=/home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-x86" "--target=x86-android-gcc" "--prefix=/home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-x86" "--target=x86-android-gcc" "--enable-static" "--disable-shared" "--enable-error-concealment" "--enable-multithread" "--enable-realtime-only" "--enable-spatial-resampling" "--enable-vp8" "--disable-vp9" "--enable-libs" "--disable-install-docs" "--disable-debug-libs" "--disable-examples" "--disable-unit-tests" "--as=yasm" "--sdk-path=/home/vvdn/android-ndk-r14b/" 
fi
