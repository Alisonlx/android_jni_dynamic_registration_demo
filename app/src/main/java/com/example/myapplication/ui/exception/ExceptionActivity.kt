package com.example.myapplication.ui.exception

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.myapplication.ui.base.BaseViewBindingActivity
import com.example.myapplication.util.NotFound
import com.example.myapplication.databinding.ActivityExceptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExceptionActivity : BaseViewBindingActivity<ActivityExceptionBinding>() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		_binding = ActivityExceptionBinding.inflate(layoutInflater)

		setContentView(binding.root)

		initUI()

	}

	@SuppressLint("SetTextI18n")
	private fun initUI(){

		binding.emptyView.playAnimation()

		binding.emptyText.text = "Oops! something went Wrong.\n ${NotFound.surpriseMe()}"

	}
}
