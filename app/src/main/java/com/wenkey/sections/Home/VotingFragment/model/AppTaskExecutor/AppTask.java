package com.wenkey.sections.Home.VotingFragment.model.AppTaskExecutor;

import android.support.annotation.Nullable;

public interface AppTask<T> {

    T execute();

    void onPostExecute(@Nullable final T result);

    abstract class SimpleAppTask implements AppTask<Boolean> {

        @Override
        public Boolean execute() {
            simpleExecute();
            return true;
        }

        @Override
        public void onPostExecute(@Nullable final Boolean result) {
            onPostExecute();
        }

        public abstract void simpleExecute();

        public abstract void onPostExecute();
    }
}
