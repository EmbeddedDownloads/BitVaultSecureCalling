package org.linphone.appControl;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**********************************************************************
 * LruBitmapCache.java
 * Created on May 16, 2016
 * Copyright (c) 2014, DoorLock, Inc.
 * 350 East Plumeria, San Jose California, 95134, U.S.A.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * DoorLock, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with DoorLock.
 *
 * @author VVDN
 *         Class Name: LruBitmapCache
 *         Description: This class is for caching the image.
 ********************************************************************/
public class LruBitmapCache extends LruCache<String, Bitmap> implements
        ImageLoader.ImageCache {

    public LruBitmapCache() {
        this(getDefaultLruCacheSize());
    }

    public LruBitmapCache(int sizeInKiloBytes) {
        super(sizeInKiloBytes);
    }

    public static int getDefaultLruCacheSize() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;

        return cacheSize;
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight() / 1024;
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }
}
