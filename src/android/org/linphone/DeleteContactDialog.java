package org.linphone;
/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.linphone.iclasses.OnDeleteDialogListener;


public class DeleteContactDialog extends Dialog implements View.OnClickListener{


    private OnDeleteDialogListener listener;

    public DeleteContactDialog(@NonNull Context context, OnDeleteDialogListener listener) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog);
        this.listener=listener;
        Window window = getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        findViewById(R.id.delete_button).setOnClickListener(this);
        findViewById(R.id.cancel_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.delete_button:
                listener.onDialogButtonPress(true);
                dismiss();
                break;
            case R.id.cancel_button:
                listener.onDialogButtonPress(false);
                dismiss();
                break;
        }
    }
}
