package com.malik.covid.utils

import android.content.Context
import com.kaopiz.kprogresshud.KProgressHUD

class DialogUtils {
    companion object {

        fun showProgressDialog(context: Context): KProgressHUD {
            return showProgressDialog(context, "")
        }

        fun showProgressDialog(context: Context, message: String = "", cancelable: Boolean = false): KProgressHUD {
            return KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(message)
                .setCancellable(cancelable)
                .setMaxProgress(100) as KProgressHUD
        }
    }
}