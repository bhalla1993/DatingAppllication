package com.wenkey.sections.Home.VotingFragment.model.AppTaskExecutor;

import android.support.annotation.NonNull;

/**
 * Created by Ali Assadi on 10/21/2017.
 */
public interface TaskExecutor {

    <T> void async(@NonNull final AppTask<T> task);
}
