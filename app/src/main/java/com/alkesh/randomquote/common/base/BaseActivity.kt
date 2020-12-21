package com.alkesh.randomquote.common.base

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alkesh.randomquote.presentation.general.dialog.LoadingDialog

abstract class BaseActivity : AppCompatActivity() {
    var loadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        init()
        setEvents()
        setObservers()

    }

    fun showMessage(text: String?) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    fun showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog()
            loadingDialog?.let {
                it.isCancelable = false
                it.show(supportFragmentManager, LoadingDialog::class.java.name)
            }
        } else {
            loadingDialog?.apply {
                this.show(supportFragmentManager, LoadingDialog::class.java.name)
            }
        }
    }

    fun hideLoadingDialog() {
        loadingDialog?.dismiss()
    }

    protected abstract fun init()

    protected abstract fun setEvents()

    protected abstract fun setObservers()

    protected abstract fun getLayoutResId(): Int


}
