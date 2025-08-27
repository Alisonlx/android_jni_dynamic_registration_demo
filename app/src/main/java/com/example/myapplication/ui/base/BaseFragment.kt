/*
 * Copyright (c) 2022. Anshul Saraf
 */

package com.example.myapplication.ui.base

import androidx.fragment.app.Fragment
import kotlinx.coroutines.Job

abstract class BaseFragment : Fragment() {

    protected val jobs = mutableListOf<Job>()

    override fun onDestroy() {
        jobs.forEach { it.cancel() }
        super.onDestroy()
    }

}
