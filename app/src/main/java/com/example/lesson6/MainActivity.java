package com.example.lesson6;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View draggableView;
    private final String DEBUG_TAG = "DragDrop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        draggableView = findViewById(R.id.draggableView);

        draggableView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                return handleTouch(view, event);
            }
        });
    }

    private boolean handleTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(DEBUG_TAG, "Action was DOWN");
                return true;

            case MotionEvent.ACTION_MOVE:
                Log.d(DEBUG_TAG, "Action was MOVE");

                // Actualiza la posición del view
                view.setX(event.getRawX() - view.getWidth() / 2);
                view.setY(event.getRawY() - view.getHeight() / 2);
                return true;
                
            default:
                return false;
        }
    }
}
