package com.aungpaing.test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpaing.test.R
import com.aungpaing.test.activity.ItemDetailActivity
import com.aungpaing.test.adapter.BrandListForHorizontalAdapter
import com.aungpaing.test.adapter.ItemListAdapter
import com.aungpaing.test.data.vos.BrandVO
import com.aungpaing.test.data.vos.ItemVO
import com.aungpaing.test.delegate.HomeDelegate
import com.aungpaing.test.mvp.presenter.HomePresenterImpl
import com.aungpaing.test.mvp.view.HomeView
import com.aungpaing.test.network.response.ItemListResponse
import com.aungpaing.test.utils.BRAND_LIST_SIZE
import com.aungpaing.test.utils.isNetwork
import com.aungpaing.test.utils.showErrorDialog
import com.aungpaing.test.utils.showInfoDialog
import kotlinx.android.synthetic.main.fragment_home.pb_loading
import kotlinx.android.synthetic.main.fragment_home.rv_brand_list
import kotlinx.android.synthetic.main.fragment_home.rv_item_list

class HomeFragment: BaseFragment(), HomeView, HomeDelegate {

    private lateinit var mPresenter: HomePresenterImpl
    private lateinit var brandListAdapter: BrandListForHorizontalAdapter
    private lateinit var itemListAdapter: ItemListAdapter
    private lateinit var itemVOList: MutableList<ItemVO>
    private lateinit var brandVOList: MutableList<BrandVO>

    companion object {
        fun newFragment(): Fragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setUpPresenter()
        mPresenter.onCreateView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.onViewCreated()
    }

    private fun setUpPresenter() {
        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(this)
    }

    override fun itemListResponse(response: ItemListResponse) {
        itemVOList = response.itemVOList
        itemListAdapter.setData(itemVOList)
    }

    override fun init() {
        brandVOList = ArrayList()
        itemVOList = ArrayList()
    }

    override fun setUpAdapter() {
        brandListAdapter = BrandListForHorizontalAdapter(requireContext(), this)
        rv_brand_list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rv_brand_list.adapter = brandListAdapter

        brandVOList.add(BrandVO(1, "Nike", R.drawable.ic_nike))
        brandVOList.add(BrandVO(1, "Adidas", R.drawable.ic_adidas))
        brandVOList.add(BrandVO(1, "Puma", R.drawable.ic_puma))
        brandVOList.add(BrandVO(1, "Nike", R.drawable.ic_nike))
        brandVOList.add(BrandVO(1, "Adidas", R.drawable.ic_adidas))
        BRAND_LIST_SIZE = brandVOList.size
        brandListAdapter.setData(brandVOList)

        itemListAdapter = ItemListAdapter(requireContext(), this)
        rv_item_list.layoutManager = LinearLayoutManager(requireContext())
        rv_item_list.adapter = itemListAdapter
    }

    override fun setUpLoadingDialog() {

    }

    override fun checkNetwork() {
        if (isNetwork(requireContext())) {
            mPresenter.getItemList()
        } else {
            showInfoDialog(requireContext(), getString(R.string.network_body))
        }
    }

    override fun listener() {

    }

    override fun showLoading() {
        pb_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
    }

    override fun showErrorMessage(message: String) {
        showErrorDialog(requireContext(), message)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun onTapLove(position: Int, vo: ItemVO) {

    }

    override fun onTapCart(position: Int, vo: ItemVO) {

    }

    override fun onTapItem(position: Int, vo: ItemVO) {
        startActivity(ItemDetailActivity.newIntent(requireContext(), vo))
    }
}