package com.shendx.ark.base.lib.util.permission

import android.Manifest
import android.support.v4.app.FragmentActivity
import com.shendx.ark.base.lib.util.toast.toast
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * name
 * describe
 * Created by SHEN on 2017/11/20.
 */
object RxPermissionsUtil {
    private fun requestSingle(activity: FragmentActivity, permission: String, granted: () -> Unit = {}, errorHint: String = "请允许获取权限") {
        RxPermissions(activity)
                .requestEach(permission)
                .subscribe {
                    when {
                        it.granted -> {
                            granted()
                        }
                        else -> {
                            toast(errorHint)
                        }
                    }
                }
    }

    private fun requestMulti(activity: FragmentActivity, vararg permissions: String, granted: () -> Unit = {}, errorHint: String = "请允许获取权限") {
        RxPermissions(activity)
                .request(*permissions)
                .subscribe {
                    when {
                        it -> {
                            granted()
                        }
                        else -> {
                            toast(errorHint)
                        }
                    }
                }
    }

    /**
     * 手机存储
     */
    fun writeExternalStorage(activity: FragmentActivity, granted: () -> Unit) {
        requestSingle(
                activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                granted,
                "请允许 读写手机存储 权限")
    }

    /**
     * 相册
     */
    @JvmStatic
    fun openAlbum(activity: FragmentActivity, granted: () -> Unit) {
        val permissions = arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        )
        requestMulti(
                activity = activity,
                permissions = *permissions,
                granted = granted,
                errorHint = "请允许 拍照和读写手机存储 权限")
    }
}