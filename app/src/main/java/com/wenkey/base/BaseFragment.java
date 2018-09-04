package com.wenkey.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import butterknife.ButterKnife;

/**
 * Created by Ali Assadi on 10/15/2017.
 */

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment {

    protected Presenter mPresenter;

    @NonNull
    protected abstract Presenter createPresenter(@NonNull final Context context);

    @CallSuper
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter(getContext());
        mPresenter.onCreate(savedInstanceState);
    }


    @CallSuper
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @CallSuper
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @CallSuper
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        mPresenter.onSaveInstanceState(outState);
    }

    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @CallSuper
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions,
                                           @NonNull final int[] grantResults) {
        mPresenter.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }


}
