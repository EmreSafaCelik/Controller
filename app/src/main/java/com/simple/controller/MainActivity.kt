package com.simple.controller

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Camera
import android.hardware.camera2.CameraDevice
import android.media.VolumeShaper
import android.os.Bundle
import android.util.Log
import android.view.Surface
import android.view.SurfaceView
import android.view.TextureView
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.opencv.android.OpenCVLoader
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    private lateinit var camera: Camera
    private lateinit var surfaceView: SurfaceView
    private lateinit var showCamera: ShowCamera

    private val CAMERA_PERMISSION_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        surfaceView = SurfaceView(this)
        setContentView(surfaceView)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=  PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
        } else {
            startCamera()
        }
    }

    fun startCamera() {
        var cam_obj = android.hardware.Camera.open()
        val parameters = cam_obj.parameters

        if (this.resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            parameters.set("orientation", "portrait")
            cam_obj.setDisplayOrientation(90)
            parameters.setRotation(90)
        } else {
            parameters.set("orientation", "landscape")
            cam_obj.setDisplayOrientation(0)
            parameters.setRotation(0)
        }
    }

}