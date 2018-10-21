/* Copyright (c) 2011 The WebM project authors. All Rights Reserved. */
/*  */
/* Use of this source code is governed by a BSD-style license */
/* that can be found in the LICENSE file in the root of the source */
/* tree. An additional intellectual property rights grant can be found */
/* in the file PATENTS.  All contributing project authors may */
/* be found in the AUTHORS file in the root of the source tree. */
#include "vpx/vpx_codec.h"
static const char* const cfg = "--prefix=/home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-armv7 --target=armv7-android-gcc --prefix=/home/vvdn/linphone/linphone-android-arpit/liblinphone-sdk/android-armv7 --target=armv7-android-gcc --enable-static --disable-shared --enable-error-concealment --enable-multithread --enable-realtime-only --enable-spatial-resampling --enable-vp8 --disable-vp9 --enable-libs --disable-install-docs --disable-debug-libs --disable-examples --disable-unit-tests --as=yasm --sdk-path=/home/vvdn/android-ndk-r14b/";
const char *vpx_codec_build_config(void) {return cfg;}
