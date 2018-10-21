package org.linphone.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.linphone.R;
import org.linphone.utils.AppKeyHelper;
import org.linphone.utils.PublicKey;
import org.linphone.wallet.WalletInformation;

import java.util.List;


public class PublicKeyViewAdapter extends RecyclerView.Adapter<PublicKeyViewAdapter.PublicKeyViewHolder> {

    private List<PublicKey> publicKeyList;
    private Activity activity;
    public int mHeight = 0;
    public String mUserName ;
    public String mPhotoUri ;

    public PublicKeyViewAdapter(Activity activity, List<PublicKey> publicKeyList, String mUserName, String phtotUri) {
        this.publicKeyList = publicKeyList;
        this.activity = activity;
        this.mUserName = mUserName;
        this.mPhotoUri = phtotUri;
    }

    @Override
    public PublicKeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.publickey_view_cell, parent, false);

        itemView.post(new Runnable() {
            @Override
            public void run() {
                mHeight = itemView.getHeight(); //height is ready

            }
        });

        return new PublicKeyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PublicKeyViewHolder holder, final int position) {

        final PublicKey key = publicKeyList.get(position);
        if (key.getPublicKey() != null && key.getPublicKey().length() > 0) {
            holder.setKey(key.getPublicKey());
        }

        holder.publicImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                if (key.getPublicKey() != null && mUserName!=null) {
                    Intent intent = new Intent(activity, WalletInformation.class);
                    intent.putExtra(AppKeyHelper.KEY_ADDRESS, key.getPublicKey());
                    intent.putExtra(AppKeyHelper.KEY_NAME, mUserName);
                    intent.putExtra(AppKeyHelper.KEY_PHOTO_URI, mPhotoUri);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                    activity.finish();

                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return publicKeyList.size();

    }

    public class PublicKeyViewHolder extends RecyclerView.ViewHolder {

        private ImageView publicImageView;
        private TextView publicKeyTxt;

        public PublicKeyViewHolder(View itemView) {
            super(itemView);
            publicImageView = (ImageView) itemView.findViewById(R.id.callingImg);
            publicKeyTxt = (TextView) itemView.findViewById(R.id.publicKeyTxt);
        }

        public void setKey(String key) {
            publicKeyTxt.setText(key);
        }
    }


}
