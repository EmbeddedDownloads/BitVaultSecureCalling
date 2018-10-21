package org.linphone.register;
import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.linphone.assistant.AssistantActivity;
import org.linphone.core.LinphoneAddress;
import org.linphone.iclasses.WebAPIResponseListener;
import org.linphone.utils.AppConstants;
import org.linphone.utils.AppKeyHelper;

import java.util.Map;

import utils.SDKUtils;



public class RegisterAPI {
    /**
     * Debugging TAG to debug this class
     */
    private String TAG = RegisterAPI.class.getSimpleName();

    private JSONObject mJsonObject;
    private WebAPIResponseListener  webAPIResponseListener;
    public void registerUserOnSip(final Context context, final String publicAddress, final WebAPIResponseListener webAPIResponseListener) {
        mJsonObject = new JSONObject();
        this.webAPIResponseListener=webAPIResponseListener;

        try {
            //creating json
            mJsonObject.put(AppKeyHelper.KEY_PUBLIC_ADDRESS, publicAddress);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //getting json throw volley
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, AppConstants.REGISTER_URL,
                mJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //getting the json response
                    String status = response.getString(AppKeyHelper.KEY_STATUS);
                    if (status.equals(AppKeyHelper.KEY_RESPONSE_SUCCESS)) {
                        if(AssistantActivity.instance()!=null)
                        AssistantActivity.instance().genericLogIn(publicAddress, AppConstants.REGISTER_PASSWORD, null, AppConstants.REGISTER_IP, LinphoneAddress.TransportType.LinphoneTransportTcp);
                   else
                       SDKUtils.showLog(TAG,"AssistantActivity  null instance");
                    } else if (status.equals(AppKeyHelper.KEY_RESPONSE_FAILURE)) {
                        registerUserOnSip(context, publicAddress,webAPIResponseListener);
                    }
                } catch (Exception e) {
                    if(webAPIResponseListener!=null)
                    webAPIResponseListener.onFailOfResponse(response.toString());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error.getMessage()!=null)
                SDKUtils.showLog(TAG, error.getMessage());
                if(webAPIResponseListener!=null)
                    webAPIResponseListener.onFailOfResponse(error.toString());

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {


                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                return super.parseNetworkResponse(response);
            }
        };


        //adding in request queue
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonObjectRequest);
    }


}
