package org.linphone.utils;


import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.linphone.R;
import org.linphone.iclasses.HeaderViewClickListener;


public class HeaderViewManager {
    /**
     * Instance of this class
     */
    public static HeaderViewManager mHeaderManagerInstance;
    /**
     * Debugging TAG
     */
    private String TAG = HeaderViewManager.class.getSimpleName();

    /**
     * Header View Instance
     */
    private RelativeLayout header_view_parent, headerLeftView, headerRightView;
    private TextView headerHeadingText;
    private TextView headerLeftText, headerRightText;
    private BitVaultFont headerLeftImage;
    private ImageView headerRightImage;

    /**
     * Instance of Header View Manager
     *
     * @return
     */
    public static HeaderViewManager getInstance() {
        if (mHeaderManagerInstance == null) {
            mHeaderManagerInstance = new HeaderViewManager();
        }
        return mHeaderManagerInstance;
    }

    /**
     * Initialize Header View
     *
     * @param mActivity
     * @param mView
     * @param headerViewClickListener
     */
    public void InitializeHeaderView(Activity mActivity, View mView, boolean isParentViewColor,
                                     HeaderViewClickListener headerViewClickListener) {
        if (mActivity != null) {
            header_view_parent = (RelativeLayout) mActivity.findViewById(R.id.header_view_parent);
            if (isParentViewColor) {
                if (header_view_parent != null)
                    header_view_parent.setBackgroundResource(R.color.headerColor);
            }

            headerLeftView = (RelativeLayout) mActivity
                    .findViewById(R.id.headerLeftView);
            headerRightView = (RelativeLayout) mActivity
                    .findViewById(R.id.headerRightView);
            headerHeadingText = (TextView) mActivity
                    .findViewById(R.id.headerTextView);
            headerLeftText = (TextView) mActivity
                    .findViewById(R.id.headerLeftTextView);
            headerRightText = (TextView) mActivity
                    .findViewById(R.id.headerRightTextView);
            headerLeftImage = (BitVaultFont) mActivity
                    .findViewById(R.id.headerLeftViewImage);
            headerRightImage = (ImageView) mActivity
                    .findViewById(R.id.headerRightViewImage);
        } else if (mView != null) {
            header_view_parent = (RelativeLayout) mActivity.findViewById(R.id.header_view_parent);
            if (isParentViewColor)
                header_view_parent.setBackgroundResource(R.color.headerColor);
            headerLeftView = (RelativeLayout) mView
                    .findViewById(R.id.headerLeftView);
            headerRightView = (RelativeLayout) mView
                    .findViewById(R.id.headerRightView);
            headerHeadingText = (TextView) mView
                    .findViewById(R.id.headerTextView);
            headerLeftText = (TextView) mView
                    .findViewById(R.id.headerLeftTextView);
            headerRightText = (TextView) mView
                    .findViewById(R.id.headerRightTextView);
            headerLeftImage = (BitVaultFont) mView
                    .findViewById(R.id.headerLeftViewImage);
            headerRightImage = (ImageView) mView
                    .findViewById(R.id.headerRightViewImage);
        }
        manageClickOnViews(headerViewClickListener);
    }

    /**
     * ManageClickOn Header view
     *
     * @param headerViewClickListener
     */
    private void manageClickOnViews(
            final HeaderViewClickListener headerViewClickListener) {
        /********* Click on Header Left View **********/
        headerLeftView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                headerViewClickListener.onClickOfHeaderLeftView();
            }
        });
        /********* Click on Header Right View **********/
        headerRightView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                headerViewClickListener.onClickOfHeaderRightView();
            }
        });
    }

    /**
     * Set Heading View Text
     *
     * @param isVisible
     * @param headingStr
     */
    public void setHeading(Activity mActivity, boolean isVisible,
                           String headingStr) {
        if (headerHeadingText != null) {
            if (isVisible) {
                headerHeadingText.setVisibility(View.VISIBLE);
                headerHeadingText.setText(headingStr);
            } else {
                headerHeadingText.setVisibility(View.GONE);
            }
        } else {
        }
    }

    /**
     * Set Header Left View
     *
     * @param isVisibleImage
     * @param isVisibleText
     * @param ImageId
     * @param LeftString
     */

    public void setLeftSideHeaderView(boolean isVisibleImage,
                                      boolean isVisibleText, String ImageId, String LeftString) {
        if (!isVisibleImage && !isVisibleText) {
            headerLeftView.setVisibility(View.GONE);
        } else if (headerLeftView == null || headerLeftText == null
                || headerLeftImage == null) {
//            AppUtils.showErrorLog(TAG, "Header Left View is null");
        } else if (isVisibleImage) {
            headerLeftView.setVisibility(View.VISIBLE);
            headerLeftText.setVisibility(View.GONE);
            headerLeftImage.setVisibility(View.VISIBLE);
            if (!ImageId.equals("")) {
                headerLeftImage.setText(ImageId);
            } else {
//                AppUtils.showErrorLog(TAG,
//                        "Header left image id is null");
            }

        } else if (isVisibleText) {
            headerLeftView.setVisibility(View.VISIBLE);
            headerLeftText.setVisibility(View.VISIBLE);
            headerLeftImage.setVisibility(View.GONE);
            if (LeftString != null && !LeftString.isEmpty()) {
                headerLeftText.setText(LeftString);
            } else {
//                AppUtils.showErrorLog(TAG,
//                        "Header left header string is null");
            }
        }
    }

    /**
     * Set Header Right Side View
     *
     * @param isVisibleImage
     * @param isVisibleText
     * @param ImageId
     * @param RightString
     */
    public void setRightSideHeaderView(boolean isVisibleImage,
                                       boolean isVisibleText, int ImageId, String RightString) {
        if (!isVisibleImage && !isVisibleText) {
            headerRightView.setVisibility(View.GONE);
        } else if (headerRightView == null || headerRightText == null
                || headerRightImage == null) {
//            AppUtils.showErrorLog(TAG, "Header Right View is null");
        } else if (isVisibleImage) {
            headerRightView.setVisibility(View.VISIBLE);
            headerRightText.setVisibility(View.GONE);
            headerRightImage.setVisibility(View.VISIBLE);
            if (ImageId > 0) {
                headerRightImage.setImageResource(ImageId);
            } else {
//                AppUtils.showErrorLog(TAG,
//                        "Header Right image id is null");
            }

        } else if (isVisibleText) {
            headerRightView.setVisibility(View.VISIBLE);
            headerRightText.setVisibility(View.VISIBLE);
            headerRightImage.setVisibility(View.GONE);
            if (RightString != null && !RightString.isEmpty()) {
                headerRightText.setText(RightString);
            } else {
//                AppUtils.showErrorLog(TAG,
//                        "Header Right header string is null");
            }
        }

    }
}
