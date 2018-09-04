package com.wenkey.sections.Home.VotingFragment.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;

import com.wenkey.R;
import com.wenkey.sections.Home.VotingFragment.model.user.UserProfile;

/**
 * Created by Ali Assadi on 10/21/2017.
 */

public class MatchDialog extends Dialog {
    public static final String NAME_AND_AGE_STRING_FORMAT = "%s, %d";

    private final ImageView mProfileImage;
    private final TextView mUserDetails;

    public MatchDialog(@NonNull final Context context) {
        super(context);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.match_dialog);
        mProfileImage = (ImageView) findViewById(R.id.profile_image);
        mUserDetails = (TextView) findViewById(R.id.user_profile);
        findViewById(R.id.chat_button).setOnClickListener(new OnChatClicked());
    }

    void setProfile(@NonNull final UserProfile profile) {
        Glide.with(getContext()).load(profile.getImageUrl()).centerCrop().crossFade().into(mProfileImage);
        mUserDetails.setText(String.format(Locale.getDefault(), NAME_AND_AGE_STRING_FORMAT, profile.getName(),
                profile.getAge()));

    }


    private class OnChatClicked implements View.OnClickListener {
        @Override
        public void onClick(final View view) {
            dismiss();
        }
    }
}
