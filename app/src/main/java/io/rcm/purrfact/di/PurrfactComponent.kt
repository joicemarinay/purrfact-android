package io.rcm.purrfact.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by joicemarinay on 18/12/2017.
 */
@Component(modules = arrayOf(
        RemoteModule::class
))
@Singleton
internal interface PurrfactComponent