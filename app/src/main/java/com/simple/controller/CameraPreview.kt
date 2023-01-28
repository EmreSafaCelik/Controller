package com.simple.controller

import android.content.Context
import android.graphics.Camera
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CaptureRequest
import android.view.SurfaceHolder
import android.view.SurfaceView

class CameraPreview(context: Context, private val camera: CameraDevice) :
    SurfaceView(context), SurfaceHolder.Callback {

    private val surfaceHolder = holder.apply {
        addCallback(this@CameraPreview)
    }
    private var previewRequest: CaptureRequest? = null

    override fun surfaceCreated(holder: SurfaceHolder) {
        val surface = holder.surface
        val request = camera.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
        request.addTarget(surface)
        previewRequest = request.build()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        camera.createCaptureSession(listOf(holder.surface), object : CameraCaptureSession.StateCallback() {
            override fun onConfigured(session: CameraCaptureSession) {
                session.setRepeatingRequest(previewRequest?: return, null, null)
            }

            override fun onConfigureFailed(session: CameraCaptureSession) {
                // Handle Error
            }
        }, null)
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        camera.close()
    }

}