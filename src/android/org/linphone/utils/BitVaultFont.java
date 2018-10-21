package org.linphone.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Font file used for displaying the icons as a text.
 */

public class BitVaultFont extends TextView {

    public BitVaultFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BitVaultFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitVaultFont(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/" +
                        "bitcaller.ttf");
        setTypeface(tf);
    }

}