package com.example.transitiondemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Scene mAScene;
    Scene mAnotherScene;

    Transition mFadeTransition;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        mAScene = Scene.getSceneForLayout(mSceneRoot, R.layout.a_scene, this);
        mAnotherScene = Scene.getSceneForLayout(mSceneRoot, R.layout.another_scene, this);

        mFadeTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade_transition);

        Button scene1 = (Button) findViewById(R.id.scene1);
        Button scene2 = (Button) findViewById(R.id.scene2);

        scene1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(mAScene, mFadeTransition);
            }
        });

        scene2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(mAnotherScene, mFadeTransition);
            }
        });
    }
}
