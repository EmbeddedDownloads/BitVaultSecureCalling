package org.linphone.appControl;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import controller.SDKControl;

/*******************************************************************************
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 * @author VVDN
 *         Class Name: AppController
 *         Description: This class is used as a controller of the application.
 ******************************************************************************/
public class AppController extends SDKControl {
    /**
     * Debuggable TAG
     */
    public static final String TAG = AppController.class
            .getSimpleName();
    /**
     * AppController reference object
     */
    public static AppController mInstance;
    /**
     * RequestQueue reference object
     */
    private RequestQueue mRequestQueue, serialRequestQueue;
    /**
     * ImageLoader reference object
     */
    private ImageLoader mImageLoader;
//    private AbstractHttpClient mHttpClient;
    int MAX_SERIAL_THREAD_POOL_SIZE = 1;
    final int MAX_CACHE_SIZE = 2 * 1024 * 1024; // 2 MB

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
        mInstance = this;
//        mHttpClient = new DefaultHttpClient();

        ApplicationLifecycleHandler handler = new ApplicationLifecycleHandler();
        registerActivityLifecycleCallbacks(handler);
        registerComponentCallbacks(handler);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());//,new HurlStack(null, ClientSSLSocketFactory.getSocketFactory()));
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}
