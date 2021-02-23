package com.xantrikoding.myflexiblefragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.widget.*
import androidx.fragment.app.DialogFragment

class OptionDialogFragment : DialogFragment() {

    private lateinit var rgOptions: RadioGroup
    private lateinit var rbSaf: RadioButton
    private lateinit var rbMou: RadioButton
    private lateinit var rbLvg: RadioButton
    private lateinit var rbMoyes: RadioButton
    private lateinit var btnClose: Button
    private lateinit var btnChoose: Button
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rgOptions = view.findViewById(R.id.rg_options)
        rbSaf  = view.findViewById(R.id.rb_saf)
        rbMou = view.findViewById(R.id.rb_mou)
        rbLvg  = view.findViewById(R.id.rb_lvg)
        rbMoyes = view.findViewById(R.id.rb_moyes)
        btnClose = view.findViewById(R.id.btn_close)

        btnChoose = view.findViewById(R.id.btn_choose)
        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var coach: String? = null
                when (checkedRadioButtonId) {
                    R.id.rb_saf -> coach = rbSaf.text.toString().trim()

                    R.id.rb_mou -> coach = rbMou.text.toString().trim()

                    R.id.rb_lvg -> coach = rbLvg.text.toString().trim()

                    R.id.rb_moyes -> coach = rbMoyes.text.toString().trim()
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }

        btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }


}