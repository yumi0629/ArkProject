package com.shendx.ark.base.lib.ui.list

import android.os.Bundle
import android.support.annotation.DimenRes
import android.support.annotation.Nullable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.shendx.ark.base.lib.R
import com.shendx.ark.base.lib.ui.BaseActivity
import com.shendx.ark.base.lib.util.AppUtil
import com.shendx.ark.base.lib.util.ex.isNotNull
import com.shendx.ark.base.lib.util.getDimensionPixelOffsetRes
import com.shendx.ark.base.lib.util.getDimensionPixelSizeRes
import com.shendx.ark.base.lib.util.loge

abstract class BaseListActivity<T : BaseQuickAdapter<K, *>, K> : BaseActivity() {

    protected val recyclerView: RecyclerView? by lazy { findViewById<RecyclerView>(R.id.list_recycler) }

    protected open val listLayoutManager by lazy { LinearLayoutManager(this) }
    protected val listAdapter: T? by lazy { getAdapter() }
    protected open val listOnItemClickListener: OnItemClickListener? = null
    protected open val listItemDecoration: RecyclerView.ItemDecoration? = null
    @DimenRes
    protected open val listItemDecorationDimen: Int = 0

    override fun bindView(savedInstanceState: Bundle?) {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView?.let {
            it.layoutManager = listLayoutManager
            it.adapter = listAdapter

            val itemClickListener = listOnItemClickListener
            itemClickListener.isNotNull { it2 ->
                it.addOnItemTouchListener(it2)
            }

            val itemDecoration = listItemDecoration

            when {
                itemDecoration.isNotNull -> {
                    loge("itemDecoration.isNotNull")
                }
                listItemDecorationDimen != 0 -> {
                    loge("listItemDecorationDimen != 0")
                    val itemDecorationDimen = ItemDecorationV1(
                            dividerHeight = getDimensionPixelOffsetRes(listItemDecorationDimen))
                    it.addItemDecoration(itemDecorationDimen)
                }
            }
        }
    }

    fun setAdapterData(@Nullable data: List<K>) {
        listAdapter?.apply {
            setNewData(data)
            notifyDataSetChanged()
        }
    }

    abstract fun getAdapter(): T?
}