package org.wit.placemark.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.placemark.models.TaskJSONStore
import org.wit.placemark.models.TaskStore

class MainApp: Application(), AnkoLogger {

    //val placemarks = ArrayList<PlacemarkModel>()
    //val placemarks = TaskMemStore()
    lateinit var placemarks: TaskStore

    override fun onCreate() {
        super.onCreate()
        placemarks = TaskJSONStore(applicationContext)
        info("To Do List Started")
        //placemarks.add(PlacemarkModel("One", "About one..."))
        //placemarks.add(PlacemarkModel("Two", "About two..."))
        //placemarks.add(PlacemarkModel("Three", "About three..."))
    }
}