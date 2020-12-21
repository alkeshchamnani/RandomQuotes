package com.alkesh.randomquote.presentation.general.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.alkesh.randomquote.R


class LoadingDialog() : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(this.requireContext())
        dialog.window?.apply {
            this.requestFeature(Window.FEATURE_NO_TITLE);
        }
        dialog.setContentView(R.layout.dialog_loading)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            dialog.window?.apply {
                this.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }
    }

}