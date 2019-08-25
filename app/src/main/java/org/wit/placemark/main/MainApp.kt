package org.wit.placemark.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.placemark.models.PlacemarkMemStore
import org.wit.placemark.models.PlacemarkStore
import org.wit.placemark.models.PlacemarkModel

class MainApp: Application(), AnkoLogger {

    //val placemarks = ArrayList<PlacemarkModel>()
    //val placemarks = PlacemarkMemStore()
    lateinit var placemarks: PlacemarkStore

    override fun onCreate() {
        super.onCreate()
        placemarks = PlacemarkMemStore()
        info("To Do List Started")
        //placemarks.add(PlacemarkModel("One", "About one..."))
        //placemarks.add(PlacemarkModel("Two", "About two..."))
        //placemarks.add(PlacemarkModel("Three", "About three..."))
    }
}