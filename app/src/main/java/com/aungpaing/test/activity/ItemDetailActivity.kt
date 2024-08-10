package com.aungpaing.test.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpaing.test.R
import com.aungpaing.test.adapter.ColorListAdapter
import com.aungpaing.test.adapter.SizeListAdapter
import com.aungpaing.test.data.vos.ColorVO
import com.aungpaing.test.data.vos.ItemVO
import com.aungpaing.test.data.vos.SizeVO
import com.aungpaing.test.delegate.ItemDetailDelegate
import com.aungpaing.test.mvp.presenter.ItemDetailPresenterImpl
import com.aungpaing.test.mvp.view.ItemDetailView
import com.aungpaing.test.utils.SIZE_LIST_SIZE
import com.aungpaing.test.utils.isNetwork
import com.aungpaing.test.utils.showErrorDialog
import com.aungpaing.test.utils.showInfoDialog
import com.bumptech.glide.Glide
import com.google.vr.sdk.widgets.pano.VrPanoramaView
import kotlinx.android.synthetic.main.activity_item_detail.iv_item
import kotlinx.android.synthetic.main.activity_item_detail.iv_minus
import kotlinx.android.synthetic.main.activity_item_detail.iv_plus
import kotlinx.android.synthetic.main.activity_item_detail.iv_toolbar
import kotlinx.android.synthetic.main.activity_item_detail.iv_toolbar_love
import kotlinx.android.synthetic.main.activity_item_detail.iv_top_down_arrow_description
import kotlinx.android.synthetic.main.activity_item_detail.iv_top_down_arrow_free_delivery
import kotlinx.android.synthetic.main.activity_item_detail.rv_color_list
import kotlinx.android.synthetic.main.activity_item_detail.rv_size_list
import kotlinx.android.synthetic.main.activity_item_detail.tv_description_lbl
import kotlinx.android.synthetic.main.activity_item_detail.tv_description_value
import kotlinx.android.synthetic.main.activity_item_detail.tv_free_delivery_lbl
import kotlinx.android.synthetic.main.activity_item_detail.tv_free_delivery_value
import kotlinx.android.synthetic.main.activity_item_detail.tv_item_type
import kotlinx.android.synthetic.main.activity_item_detail.tv_name
import kotlinx.android.synthetic.main.activity_item_detail.tv_price
import kotlinx.android.synthetic.main.activity_item_detail.tv_qty_value
import kotlinx.android.synthetic.main.activity_main.iv_toolbar_cart

class ItemDetailActivity: BaseActivity(), ItemDetailView, ItemDetailDelegate {

    private lateinit var mPresenter: ItemDetailPresenterImpl
    private lateinit var loadingDialog: Dialog
    private lateinit var itemVO: ItemVO
    private lateinit var sizeListAdapter: SizeListAdapter
    private lateinit var sizeVOList: MutableList<SizeVO>
    private lateinit var colorListAdapter: ColorListAdapter
    private lateinit var colorVOList: MutableList<ColorVO>
    private var isDescriptionDown = true
    private var isFreeDeliveryDown = true

    companion object {
        private const val ITEM_VO = "itemVO"
        fun newIntent(context: Context, itemVO: ItemVO): Intent {
            val intent = Intent(context, ItemDetailActivity::class.java)
            intent.putExtra(ITEM_VO, itemVO)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setUpPresenter()
        mPresenter.onCreate()
        loaData()
        load360DegreeImage()
    }

    private fun setUpPresenter() {
        mPresenter = ItemDetailPresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun init() {
        itemVO = intent.getSerializableExtra(ITEM_VO) as ItemVO
        sizeVOList = ArrayList()
        colorVOList = ArrayList()
    }

    override fun setUpAdapter() {
        sizeListAdapter = SizeListAdapter(this, this)
        rv_size_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_size_list.adapter = sizeListAdapter

        sizeVOList.add(SizeVO(1, "5", false))
        sizeVOList.add(SizeVO(1, "5.5", true))
        sizeVOList.add(SizeVO(1, "6", false))
        sizeVOList.add(SizeVO(1, "6.5", false))
        sizeVOList.add(SizeVO(1, "7", false))
        sizeVOList.add(SizeVO(1, "7.5", false))
        SIZE_LIST_SIZE = sizeVOList.size
        sizeListAdapter.setData(sizeVOList)

        colorListAdapter = ColorListAdapter(this, this)
        rv_color_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_color_list.adapter = colorListAdapter

        colorVOList.add(ColorVO(1, "white", true))
        colorVOList.add(ColorVO(2, "black", false))
        colorVOList.add(ColorVO(3, "green", false))
        colorVOList.add(ColorVO(4, "blue", false))
        colorListAdapter.setData(colorVOList)
    }

    @SuppressLint("SetTextI18n")
    private fun loaData() {
        val imgLink = if (itemVO.imageVO != null) {
            itemVO.imageVO.src
        } else {
            R.drawable.ic_placeholder
        }
        Glide.with(this)
            .load(imgLink)
            .into(iv_item)
        tv_item_type.text = itemVO.productType
        tv_name.text = itemVO.title
        tv_price.text = "$${itemVO.variantsVOList[0].price}"
    }

    private fun load360DegreeImage() {
//        val options = VrPanoramaView.Options()
//        try {
//            options.inputType = VrPanoramaView.Options.TYPE_MONO
//            iv_item.loadImageFromBitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_puma), options)
//        } catch (e: Exception) {
//            Log.d("test_data", "err = ${e.printStackTrace()}")
//        }
    }

    override fun setUpLoadingDialog() {
        loadingDialog = com.aungpaing.test.utils.setUpLoadingDialog(this)
    }

    override fun checkNetwork() {
        if (isNetwork(this)) {

        } else {
            showInfoDialog(this, getString(R.string.network_body))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun listener() {
        iv_plus.setOnClickListener {
            tv_qty_value.text = (tv_qty_value.text.toString().toInt() + 1).toString()
        }

        iv_minus.setOnClickListener {
            val qty = tv_qty_value.text.toString().toInt()
            if (qty > 1) {
                tv_qty_value.text = (qty - 1).toString()
            }
        }

        tv_description_lbl.setOnClickListener {
            tapDescription()
        }

        iv_top_down_arrow_description.setOnClickListener {
            tapDescription()
        }

        tv_free_delivery_lbl.setOnClickListener {
            tapFreeDeliver()
        }

        iv_top_down_arrow_free_delivery.setOnClickListener {
            tapFreeDeliver()
        }

        iv_toolbar.setOnClickListener {
            finish()
        }

        iv_toolbar_love.setOnClickListener {
            Toast.makeText(this, getString(R.string.click), Toast.LENGTH_SHORT).show()
        }
    }

    private fun tapDescription() {
        if (isDescriptionDown) {
            iv_top_down_arrow_description.setImageResource(R.drawable.ic_top_arrow)
            tv_description_value.text = "It is Description"
            tv_description_value.visibility = View.VISIBLE
            isDescriptionDown = false
        } else {
            iv_top_down_arrow_description.setImageResource(R.drawable.ic_down_arrow)
            tv_description_value.text = "It is Description"
            tv_description_value.visibility = View.GONE
            isDescriptionDown = true
        }
    }

    private fun tapFreeDeliver() {
        if (isFreeDeliveryDown) {
            iv_top_down_arrow_free_delivery.setImageResource(R.drawable.ic_top_arrow)
            tv_free_delivery_value.text = "It is Free Delivery and Returns"
            tv_free_delivery_value.visibility = View.VISIBLE
            isFreeDeliveryDown = false
        } else {
            iv_top_down_arrow_free_delivery.setImageResource(R.drawable.ic_down_arrow)
            tv_free_delivery_value.text = "It is Description"
            tv_free_delivery_value.visibility = View.GONE
            isFreeDeliveryDown = true
        }
    }

    override fun showLoading() {
        loadingDialog.show()
    }

    override fun hideLoading() {
        loadingDialog.dismiss()
    }

    override fun showErrorMessage(message: String) {
        showErrorDialog(this, message)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun onTapSize(position: Int, vo: SizeVO) {
        for (i in 0 until sizeVOList.size) {
            sizeVOList[i].isSelected = vo.size == sizeVOList[i].size
        }
        sizeListAdapter.setData(sizeVOList)
    }

    override fun onTapColor(position: Int, vo: ColorVO) {
        for (i in 0 until colorVOList.size) {
            colorVOList[i].isSelected = vo.color == colorVOList[i].color
        }
        colorListAdapter.setData(colorVOList)
    }

}