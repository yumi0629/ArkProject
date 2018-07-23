package com.shendx.ark.biz.wanandroid.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.shendx.ark.base.lib.ui.list.BaseListActivity
import com.shendx.ark.base.lib.util.img.loadUrl
import com.shendx.ark.base.lib.util.json.toJson
import com.shendx.ark.base.lib.util.logd
import com.shendx.ark.biz.wanandroid.R
import com.shendx.ark.biz.wanandroid.bean.response.ArticleListItem
import kotlinx.android.synthetic.main.m_wan_item_main.view.*

class MainActivity : BaseListActivity<MainActivity.MainAdapter, ArticleListItem>()
        , MainContract.MainView {

    private val presenter: MainPresenter by lazy { MainPresenter(this) }

    override fun getAdapter(): MainAdapter? = MainAdapter()

    override fun getTitleText(): Int? = R.string.base_app_name

    override fun getLayoutId(): Int = R.layout.m_wan_activity_main

    override val listLayoutManager by lazy { LinearLayoutManager(this) }
    override val listItemDecorationDimen: Int = R.dimen.base_list_decoration

    override fun bindView(savedInstanceState: Bundle?) {
        super.bindView(savedInstanceState)
    }

    override fun initData() {
        presenter.articleList(1)
    }

    override fun showData(data: List<ArticleListItem>) {
        logd(data.toJson())
        setAdapterData(data)
    }

    override val listOnItemClickListener: OnItemClickListener?
            by lazy {
                object : OnItemClickListener() {
                    override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
                    }
                }
            }

    inner class MainAdapter : BaseQuickAdapter<ArticleListItem, BaseViewHolder>(R.layout.m_wan_item_main) {
        override fun convert(helper: BaseViewHolder, item: ArticleListItem) {
            val itemView = helper.itemView
            helper.setText(R.id.text_name, item.author)
                    .setText(R.id.text_content, item.desc)

            itemView.img_icon.loadUrl(item.envelopePic)
        }
    }
}
