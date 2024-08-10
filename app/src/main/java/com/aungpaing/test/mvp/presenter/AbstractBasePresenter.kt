package com.aungpaing.test.mvp.presenter

import com.aungpaing.test.mvp.view.BaseView

abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T> {

    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}