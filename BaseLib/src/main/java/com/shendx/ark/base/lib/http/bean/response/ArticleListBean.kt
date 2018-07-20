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

/*
"apkLink":"",
"author":"crazyandcoder",
"chapterId":367,
"chapterName":"资源聚合类",
"collect":false,
"courseId":13,
"desc":"Android 项目优化、面试题集，包含Android、Java、数据结构、算法、个人blog备份等。",
"envelopePic":"http://www.wanandroid.com/resources/image/pc/default_project_img.jpg",
"fresh":false,
"id":3127,
"link":"http://www.wanandroid.com/blog/show/2215",
"niceDate":"2018-07-10",
"origin":"",
"projectLink":"https://github.com/crazyandcoder/blog_backups",
"publishTime":1531236366000,
"superChapterId":294,
"superChapterName":"开源项目主Tab",
"tags":[
    {
        "name":"项目",
        "url":"/project/list/1?cid=367"
    }
],
"title":"Android 项目优化、面试题集 blog_backups",
"type":0,
"userId":-1,
"visible":1,
"zan":0
*/

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

