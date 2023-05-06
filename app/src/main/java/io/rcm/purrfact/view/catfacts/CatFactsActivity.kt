package io.rcm.purrfact.view.catfacts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import io.rcm.purrfact.R
import kotlinx.android.synthetic.main.catfacts_activity.*

internal class CatFactsActivity : AppCompatActivity() {

    companion object {
        private val TAG = CatFactsActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catfacts_activity)
        initViews()
    }

    private fun initMaxLengthSeekbar() {
        seekbarMaxLength.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textviewMaxLengthProgress.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) { /**Not handled**/ }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d(TAG, "onStopTrackingTouch() seekbarMaxLength is at ${seekBar?.progress}")
                //TODO Notify Presenter that a maxLength is set
            }
        })
    }

    private fun initViews() {
        initMaxLengthSeekbar()
        appbarLayout.addOnOffsetChangedListener { _, verticalOffset ->
            cardviewMaxLengthContainer.translationY = verticalOffset.toFloat()
        }
        textviewMaxLengthProgress.text = seekbarMaxLength.progress.toString()
    }
}