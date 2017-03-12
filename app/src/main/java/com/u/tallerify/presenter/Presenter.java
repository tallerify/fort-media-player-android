package com.u.tallerify.presenter;

import android.content.Context;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.squareup.coordinators.Coordinator;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;
import com.u.tallerify.contract.ContractView;
import com.u.tallerify.controller.abstracts.BaseDialogController;
import com.u.tallerify.utils.RouterInteractor;

/**
 * Created by saguilera on 3/12/17.
 */
public abstract class Presenter<VIEW extends ContractView> extends Coordinator {

    public Presenter() {}

    protected @Nullable Context getContext() {
        return RouterInteractor.instance().mainRouter().getActivity();
    }

    protected @NonNull Router getMainRouter() {
        return RouterInteractor.instance().mainRouter();
    }

    protected @NonNull Router getAuxiliaryRouter() {
        return RouterInteractor.instance().auxRouter();
    }

    @SuppressWarnings("ConstantConditions")
    protected void showDialog(@NonNull BaseDialogController controller) {
        RouterInteractor.instance().auxRouter()
            .setPopsLastView(true)
            .setRoot(RouterTransaction.with(controller)
                .popChangeHandler(new FadeChangeHandler())
                .pushChangeHandler(new FadeChangeHandler()));
    }

    @NonNull
    @CheckResult
    protected final <T> LifecycleTransformer<T> bindToLifecycle(@NonNull View view) {
        return RxLifecycleAndroid.bindView(view);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void attach(@NonNull final View view) {
        super.attach(view);
        onAttach((VIEW) view);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void detach(@NonNull final View view) {
        super.detach(view);
        onDetach((VIEW) view);
    }

    protected abstract void onAttach(final @NonNull VIEW view);
    protected void onDetach(final @NonNull VIEW view) {}

}