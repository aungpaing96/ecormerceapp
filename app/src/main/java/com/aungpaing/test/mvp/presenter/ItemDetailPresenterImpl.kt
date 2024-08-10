package com.aungpaing.test.mvp.presenter

import com.aungpaing.test.data.models.MyModel
import com.aungpaing.test.data.models.MyModelImpl
import com.aungpaing.test.mvp.view.ItemDetailView

class ItemDetailPresenterImpl: ItemDetailPresenter, AbstractBasePresenter<ItemDetailView>() {

    private val mModel: MyModel = MyModelImpl

    override fun onStart() {

    }

    override fun onCreate() {
        mView?.init()
        mView?.setUpLoadingDialog()
        mView?.setUpAdapter()
        mView?.checkNetwork()
        mView?.listener()
    }

    override fun onCreateView() {

    }

    override fun onViewCreated() {

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
}