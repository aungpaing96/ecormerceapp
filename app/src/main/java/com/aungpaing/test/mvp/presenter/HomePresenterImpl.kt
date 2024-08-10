package com.aungpaing.test.mvp.presenter

import com.aungpaing.test.data.models.MyModel
import com.aungpaing.test.data.models.MyModelImpl
import com.aungpaing.test.mvp.view.HomeView

class HomePresenterImpl: HomePresenter, AbstractBasePresenter<HomeView>() {

    private val mModel: MyModel = MyModelImpl

    override fun onStart() {

    }

    override fun onCreate() {

    }

    override fun onCreateView() {
        mView?.init()
    }

    override fun onViewCreated() {
        mView?.setUpLoadingDialog()
        mView?.setUpAdapter()
        mView?.checkNetwork()
        mView?.listener()
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {
        mView = null
    }

    override fun getItemList() {
        mModel.itemList(
            onSuccess = {
                mView?.itemListResponse(it)
                mView?.hideLoading()
            },
            onError = {
                mView?.showErrorMessage(it)
                mView?.hideLoading()
            }
        )
    }
}