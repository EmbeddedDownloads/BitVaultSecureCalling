package org.linphone.adapter;

/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dhruvvaishnav.sectionindexrecyclerviewlib.IndicatorScrollRecyclerView;

import org.linphone.appControl.ApplicationLifecycleHandler;
import org.linphone.ContactViewActivity;
import org.linphone.ContactsListFragment;
import org.linphone.R;
import org.linphone.utils.AppConstants;
import org.linphone.utils.AppKeyHelper;
import org.linphone.utils.CircularImageView;
import org.linphone.utils.Contacts;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import utils.SDKUtils;

import static org.linphone.ContactsListFragment.ADD_CONTACT_CODE;
import static org.linphone.ContactsListFragment.DELETE_CONTACT_CODE;


public class ContactListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements IndicatorScrollRecyclerView.SectionedAdapter {

    private static final String TAG = ContactListAdapter.class.getCanonicalName();

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private Map<String, Integer> map = new LinkedHashMap<String, Integer>();

    private List<Integer> al = new ArrayList<Integer>();
    private List<Contacts> listContact;
    ContactsListFragment mContactsListFragment;
    Activity activity;
    private String[] sections;
    private ArrayList<String> sectionsList;
    String profileID = "";

    public ContactListAdapter(Activity mActivity, ContactsListFragment mContactsListFragment, List<Contacts> listContact) {
        activity = mActivity;
        this.mContactsListFragment = mContactsListFragment;
        updateDataSet(listContact);
        this.listContact = listContact;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.setup_layout, parent, false);
            return new ContactViewHolder(v);
        } else if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_cell, parent, false);
            return new GenericViewHolder(v);
        }
        return null;
    }

    private Contacts getItem(int position) {

        return listContact.get(position);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ContactViewHolder) {
            ContactViewHolder headerHolder = (ContactViewHolder) holder;
            loadProfile(headerHolder);
            headerHolder.setup_profile_rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(activity, "Clicked Header", Toast.LENGTH_SHORT).show();
                    if (profileID == null) {
                        Intent intent = new Intent();
                        intent.putExtra(AppKeyHelper.KEY_EDIT,
                                activity.getResources().getString(R.string.intent_edit));
                        intent.putExtra(AppKeyHelper.KEY_TITLE, activity.getResources().getString(R.string.my_profile));
                        intent.setAction(Intent.ACTION_MAIN);
                        //intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setComponent(new ComponentName(AppConstants.packageName, AppConstants.packageClass));
                        try {
                            ApplicationLifecycleHandler.isInAddContact = false;
                            mContactsListFragment.startActivityForResult(intent, ADD_CONTACT_CODE);
                        } catch (Exception e) {
                            Toast.makeText(activity, "contact(s) app add activity not found", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                    } else {

                        Intent intent = new Intent(activity, ContactViewActivity.class);
                        intent.putExtra(AppKeyHelper.KEY_TITLE, activity.getResources().getString(R.string.my_profile));
                        mContactsListFragment.startActivityForResult(intent, DELETE_CONTACT_CODE);
                    }
                }
            });
        } else if (holder instanceof GenericViewHolder) {
            Contacts currentItem = getItem(position - 1);
            GenericViewHolder genericViewHolder = (GenericViewHolder) holder;


            if (currentItem.getPhotoUri() != null) {
                genericViewHolder.contactImage.setVisibility(View.VISIBLE);
                genericViewHolder.contactText.setVisibility(View.GONE);
                genericViewHolder.contactImage.setImageURI(Uri.parse(currentItem.getPhotoUri()));
            } else {
                genericViewHolder.contactImage.setVisibility(View.GONE);
                genericViewHolder.contactText.setVisibility(View.VISIBLE);
            }
            setTextImage(genericViewHolder, currentItem, position);


            if (!al.contains(position - 1)) {
                genericViewHolder.sepratorLout.setVisibility(View.INVISIBLE);
            } else {
                genericViewHolder.sepratorLout.setVisibility(View.VISIBLE);
                String fullName = currentItem.getName();
                if (fullName != null && !fullName.isEmpty()) {
                    if (Character.isDigit(fullName.charAt(0))) {
                        fullName = "#";
                    }
                    genericViewHolder.sepratorText.setText(String.valueOf(fullName.charAt(0)));
                }
            }


            genericViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(activity, "Clicked item" + (position - 1), Toast.LENGTH_SHORT).show();
                    if (AppConstants.mContactsList != null && !AppConstants.mContactsList.isEmpty()) {
//
                        Contacts contacts = AppConstants.mContactsList.get(position - 1);
                        Intent intent = new Intent(activity, ContactViewActivity.class);
                        intent.putExtra(activity.getResources().getString(R.string.intent_contact_id), contacts.getContactId());
                        intent.putExtra(activity.getResources().getString(R.string.intent_name), contacts.getName());
                        SDKUtils.showLog(TAG, contacts.getContactId());
                        if (!(contacts.getPhotoUri() != null && contacts.getPhotoUri().length() > 0)) {
                            intent.putExtra(activity.getResources().getString(R.string.intent_color), contacts.getColorPos());
                        } else if (contacts.getPhotoUri() != null) {
                            intent.putExtra(activity.getResources().getString(R.string.intent_image), contacts.getPhotoUri());
                        } else {
                            intent.putExtra(activity.getResources().getString(R.string.intent_color), contacts.getColorPos());
                        }
                        mContactsListFragment.startActivityForResult(intent, DELETE_CONTACT_CODE);
                    }
                }

            });
        }
    }

    //    need to override this method
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }


    @Override
    public int getItemCount() {
        if (listContact.size() > 0)
            return listContact.size() + 1;
        return 1;

    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        if (position == 0) {
            return String.valueOf(getItem(position).getName().charAt(0));
        } else {
            return String.valueOf(getItem(position - 1).getName().charAt(0));
        }
    }


    class ContactViewHolder extends RecyclerView.ViewHolder {
        LinearLayout setup_profile_rl;
        TextView profileImageTxt, profileNameTxt, setUpTxt;
        CircularImageView profileImageView;

        public ContactViewHolder(View itemView) {
            super(itemView);
            setup_profile_rl = (LinearLayout) itemView.findViewById(R.id.profileLout);
            profileImageTxt = (TextView) itemView.findViewById(R.id.profileImgTxt);
            profileImageView = (CircularImageView) itemView.findViewById(R.id.profileImg);
            profileNameTxt = (TextView) itemView.findViewById(R.id.profileNameTxt);
            setUpTxt = (TextView) itemView.findViewById(R.id.setUpTxt);
        }
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        LinearLayout sepratorLout;
        TextView sepratorText;
        CircularImageView contactImage;
        TextView contactText;
        TextView contactNameTxt;

        GenericViewHolder(View itemView) {
            super(itemView);
            sepratorLout = (LinearLayout) itemView.findViewById(R.id.separator);
            sepratorText = (TextView) itemView.findViewById(R.id.separator_text);
            contactImage = (CircularImageView) itemView.findViewById(R.id.contact_picture);
            contactText = (TextView) itemView.findViewById(R.id.contact_image);
            contactNameTxt = (TextView) itemView.findViewById(R.id.name);
        }
    }

    /**
     * color code randomly
     *
     * @param name
     * @return
     */
    private int getContactColorCode(String name) {
        int size = name.length();
        if (size > 2) {
            char lastChar = name.charAt(size - 1);
            char secondLastChar = name.charAt(size - 2);
            int lastASCII = (int) lastChar;
            int secondLastASCII = (int) secondLastChar;
            int Added = lastASCII + secondLastASCII;
            int remainder = (Added % 5);
            switch (remainder) {

                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;

            }
        }
        return 5;
    }


    /**
     * Update list notify
     *
     * @param list
     */
    public void updateDataSet(List<Contacts> list) {
        listContact = list;
        if (listContact.size() > 0 && !listContact.isEmpty()) {

            map = new LinkedHashMap<String, Integer>();
            String prevLetter = null;
            for (int i = 0; i < list.size(); i++) {
                Contacts contact = list.get(i);
                String fullName = contact.getName();
                if (fullName == null || fullName.isEmpty()) {
                    continue;
                }
                String firstLetter = fullName.substring(0, 1).toUpperCase(Locale.getDefault());
                if (Character.isDigit(firstLetter.charAt(0))) {
                    firstLetter = "#";
                }
                if (!firstLetter.equals(prevLetter)) {
                    prevLetter = firstLetter;
                    al.add(i);
                    map.put(firstLetter, i);
                }
            }
            sectionsList = new ArrayList<String>(map.keySet());
            sections = new String[sectionsList.size()];
            sectionsList.toArray(sections);

            notifyDataSetChanged();
        }
    }

    /**
     * Set background color for circle text
     *
     * @param holder
     * @param contacts
     * @param position
     */
    private void setTextImage(GenericViewHolder holder, Contacts contacts, int position) {

        if (contacts.getName() != null) {
            holder.contactNameTxt.setText(contacts.getName());
            String name = contacts.getName().substring(0, 1);

            holder.contactText.setText(name.toUpperCase());
            int code = getContactColorCode(contacts.getName());
            if (code == 0) {
                holder.contactText.setBackground(activity.getDrawable(R.drawable.contact_circle_view_0));
            } else if (code == 1) {
                holder.contactText.setBackground(activity.getDrawable(R.drawable.contact_circle_view_1));
            } else if (code == 2) {
                holder.contactText.setBackground(activity.getDrawable(R.drawable.contact_circle_view_2));
            } else if (code == 3) {
                holder.contactText.setBackground(activity.getDrawable(R.drawable.contact_circle_view_3));
            } else if (code == 4) {
                holder.contactText.setBackground(activity.getDrawable(R.drawable.contact_circle_view_4));
            } else {
                holder.contactText.setBackground(activity.getDrawable(R.drawable.contact_circle_view));
            }


            if (ContactsListFragment.mContactsListFragmentInstance != null)
                if (position > 0) {
                    ContactsListFragment.mContactsListFragmentInstance.updateList(position - 1, code);
                }
        } else {
            for (int i = 0; i < contacts.getListNumber().size(); i++) {
                if (contacts.getListNumber().get(i) != null) {
                    holder.contactNameTxt.setText(contacts.getListNumber().get(i).getNumber());
                    break;
                }
            }

        }
    }

    /**
     * load user profile
     */
    private void loadProfile(ContactViewHolder holder) {
        Cursor pCursor = activity.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);

        assert pCursor != null;
        if (pCursor != null) {
            pCursor.moveToFirst();
            if (pCursor.getCount() == 0) {
                holder.setUpTxt.setVisibility(View.VISIBLE);
                holder.profileNameTxt.setVisibility(View.GONE);
                holder.profileImageTxt.setVisibility(View.GONE);
                holder.profileImageView.setVisibility(View.GONE);
                profileID = null;


            } else {
                profileID = pCursor.getString(pCursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = pCursor.getString(pCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                holder.setUpTxt.setVisibility(View.GONE);
                holder.profileNameTxt.setVisibility(View.VISIBLE);
                holder.profileNameTxt.setText(name);
                if (pCursor.getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI)) != null) {
                    holder.profileImageView.setImageURI(Uri.parse(pCursor.
                            getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))));
                    holder.profileImageView.setVisibility(View.VISIBLE);
                    holder.profileImageTxt.setVisibility(View.GONE);
                } else {
                    holder.profileImageTxt.setVisibility(View.VISIBLE);
                    holder.profileImageView.setVisibility(View.GONE);
                    if (name != null) {
                        holder.profileImageTxt.setText(name.substring(0, 1));
                    }
                }
                pCursor.close();
            }

        }
    }

}
