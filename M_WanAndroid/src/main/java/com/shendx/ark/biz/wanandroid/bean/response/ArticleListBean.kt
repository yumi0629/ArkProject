package com.shendx.ark.biz.wanandroid.bean.response

/**
 * PS:
 * Created by sdx on 2018/7/11.
 */
data class ArticleListBean(
        var curPage: Int = 0,
        var datas: MutableList<ArticleListItem> = mutableListOf(),
        var offset: Int = 0,
        var over: Boolean = false,
        var pageCount: Int = 0,
        var size: Int = 0,
        var total: Int = 0
)

data class ArticleListItem(
        var apkLink: String = "",
        var author: String = "",
        var chapterId: Int = 0,
        var chapterName: String = "",
        var collect: Boolean = false,
        var courseId: Int = 0,
        var desc: String = "",
        var envelopePic: String = "",
        var fresh: Boolean = false,
        var id: Int = 0,
        var link: String = "",
        var niceDate: String = "",
        var origin: String = "",
        var projectLink: String = "",
        var publishTime: Long = 0,
        var superChapterId: Int = 0,
        var superChapterName: String = "",
        var tags: MutableList<Tag> = mutableListOf(),
        var title: String = "",
        var type: Int = 0,
        var userId: Int = 0,
        var visible: Int = 0,
        var zan: Int = 0
)

data class Tag(
        var name: String = "",
        var url: String = ""
)

