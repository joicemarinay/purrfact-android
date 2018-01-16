package io.rcm.purrfact.common.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by joicemarinay on 29/12/2017.
 */

fun ViewGroup.inflate(layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)