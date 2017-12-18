package io.rcm.purrfact

import android.app.Application
import io.rcm.purrfact.di.DaggerPurrfactComponent
import io.rcm.purrfact.di.PurrfactComponent
import io.rcm.purrfact.di.RemoteModule

/**
 * Created by joicemarinay on 18/12/2017.
 */
internal class PurrfactApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
    }

    private fun initDagger(): PurrfactComponent =
            DaggerPurrfactComponent.builder()
                    .remoteModule(RemoteModule())
                    .build()

    companion object {
        lateinit var appComponent: PurrfactComponent
    }


}