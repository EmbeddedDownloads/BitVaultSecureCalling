package org.linphone.controls;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.linphone.R;
import org.linphone.iclasses.HeaderViewClickListener;




public class HeaderControl {
    /***
     * Activity reference of the calling class
     */
    private Activity mActivity = null;
    /***
     * Relative layout object reference
     */
    private RelativeLayout mHeaderLeftIconRl = null, mHeaderRightIconRl = null;
    /***
     * Image view objects reference
     */
    private ImageView header_left_img_icon = null, header_right_icon = null;
    /**
     * Text view objects reference
     */
    private TextView header_center_tv = null, header_left_tv = null, header_right_tv = null;
    /**
     * Interface object to call the method on click
     */
    private HeaderViewClickListener mHeaderViewsController;
    /**
     * View object reference
     */
    private View mView = null;

    /**************************************************
     * @param mActivity
     * @param mHeaderViewsController
     * @Method Name: HeaderControl
     * @Description: Public constructor of this class
     *************************************************/
    public HeaderControl(Activity mActivity, View mView, HeaderViewClickListener
            mHeaderViewsController) {
        this.mActivity = mActivity;
        this.mView = mView;
        this.mHeaderViewsController =  mHeaderViewsController;
        initViews();
        assignClicks();
    }

    /*****************************************************
     * @Mathod Name: assignClicks
     * @Description: This method is used to assign clicks to the
     * views
     *****************************************************/
    private void assignClicks() {
        if (mHeaderViewsController != null) {
            mHeaderLeftIconRl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mHeaderViewsController.onClickOfHeaderLeftView();
                }
            });
            mHeaderRightIconRl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mHeaderViewsController.onClickOfHeaderRightView();
                }
            });
        }
    }

    /**************************************************
     * @Method Name: initViews
     * @Description: Get all the views of this xml layout
     * and assign id's to the actionar
     *************************************************/
    private void initViews() {
        if (mActivity != null) {
            mHeaderLeftIconRl = (RelativeLayout) mActivity.
                    findViewById(R.id.mHeaderLeftIconRl);
            header_left_img_icon = (ImageView) mActivity.
                    findViewById(R.id.headerLeftViewImage);
            header_center_tv = (TextView) mActivity.
                    findViewById(R.id.header_center_tv);
            mHeaderRightIconRl = (RelativeLayout) mActivity.
                    findViewById(R.id.mHeaderRightIconRl);
            header_right_icon = (ImageView) mActivity.
                    findViewById(R.id.header_right_icon);
            header_left_tv = (TextView) mActivity.
                    findViewById(R.id.header_left_tv);
            header_right_tv = (TextView) mActivity.
                    findViewById(R.id.header_right_tv);
        } else if (mView != null) {
            mHeaderLeftIconRl = (RelativeLayout) mView.
                    findViewById(R.id.mHeaderLeftIconRl);
            header_left_img_icon = (ImageView) mView.
                    findViewById(R.id.headerLeftViewImage);
            header_center_tv = (TextView) mView.
                    findViewById(R.id.header_center_tv);
            mHeaderRightIconRl = (RelativeLayout) mView.
                    findViewById(R.id.mHeaderRightIconRl);
            header_right_icon = (ImageView) mView.
                    findViewById(R.id.header_right_icon);
            header_left_tv = (TextView) mView.
                    findViewById(R.id.header_left_tv);
            header_right_tv = (TextView) mView.
                    findViewById(R.id.header_right_tv);
        }
    }

    /***************************************************************
     * @param isLeftIconVisible
     * @param isLeftTextVisible
     * @param leftIcon
     * @param left_tv
     ****************************************************************/
    public void setLeftControlsOnHeader(boolean isLeftIconVisible,
                                        boolean isLeftTextVisible,
                                        int leftIcon,
                                        String left_tv) {
        if (isLeftIconVisible) {
            header_left_img_icon.setVisibility(View.VISIBLE);
            header_left_tv.setVisibility(View.GONE);
            if (leftIcon > 0)
                header_left_img_icon.setImageResource(leftIcon);
        } else if (isLeftTextVisible) {
            header_left_img_icon.setVisibility(View.GONE);
            header_left_tv.setVisibility(View.VISIBLE);
            if (left_tv.length() > 0)
                header_left_tv.setText(left_tv);
        }
    }

    /****************************************************************
     * @param isRightIconVisible
     * @param isRightTextVisible
     * @param rightIcon
     * @param right_tv
     ****************************************************************/
    public void setRightControlsOnHeader(boolean isRightIconVisible,
                                         boolean isRightTextVisible,
                                         int rightIcon,
                                         String right_tv) {
        if (isRightIconVisible) {
            header_right_icon.setVisibility(View.VISIBLE);
            header_right_tv.setVisibility(View.GONE);
            if (rightIcon > 0)
                header_right_icon.setImageResource(rightIcon);
        } else if (isRightTextVisible) {
            header_right_icon.setVisibility(View.GONE);
            header_right_tv.setVisibility(View.VISIBLE);
            if (right_tv.length() > 0)
                header_right_tv.setText(right_tv);
        }
    }

    /*********************************************************
     * Description: This method is used to manage the header text
     * in the center
     *
     * @param isCenterTextVisible
     * @param centerTv
     *********************************************************/
    public void setCenterTextHeader(boolean isCenterTextVisible,
                                    String centerTv) {
        if (isCenterTextVisible) {
            header_center_tv.setVisibility(View.VISIBLE);
            if (centerTv.length() > 0)
                header_center_tv.setText(centerTv);
        } else {
            header_center_tv.setVisibility(View.GONE);
        }
    }

    /****************************************************************
     * Description: This method is used to manage right text in the header
     *
     * @return
     ***************************************************************/
    public String getRightText() {
        String mRightTxt = "";
        if (!header_right_tv.getText().toString().equalsIgnoreCase(""))
            mRightTxt = header_right_tv.getText().toString();
        return mRightTxt;
    }

    /****************************************************************
     * Description: This method is used to manage left text in the header
     *
     * @return
     ***************************************************************/
    public String getLeftText() {
        String mLeftTxt = "";
        if (!header_left_tv.getText().toString().equalsIgnoreCase(""))
            mLeftTxt = header_left_tv.getText().toString();
        return mLeftTxt;
    }
}
