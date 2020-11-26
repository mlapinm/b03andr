package com.example.b0218flash;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AccessibilityService context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CameraManager cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            assert  cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];

            cameraManager.setTorchMode(cameraId, true);
        }catch (CameraAccessException e){
            e.printStackTrace();
        }
    }

    public void onClickFlash(View view){
        onDestroy();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CameraManager cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            assert  cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
        }catch (CameraAccessException e){
            e.printStackTrace();
        }
    }
}