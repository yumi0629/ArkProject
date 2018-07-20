package com.shendx.ark.biz.wanandroid.ui.home

import com.shendx.ark.base.lib.ui.BasePresenter
import com.shendx.ark.base.lib.ui.BaseView
import com.shendx.ark.biz.wanandroid.bean.response.ArticleListBean
import com.shendx.ark.biz.wanandroid.bean.response.ArticleListItem

interface MainContract {
    interface MainView : BaseView {
        fun showData(data: List<ArticleListItem>)
    }

    interface IMainPresenter : BasePresenter {

    }
}