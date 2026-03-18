package com.bluetoothtestapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.GridLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GridLayout layout = new GridLayout(this);
        layout.setColumnCount(3);
        layout.setRowCount(3);
        layout.setPadding(50, 50, 50, 50);

        TextView title = new TextView(this);
        title.setText("蓝牙测试工具");
        title.setTextSize(24);
        title.setPadding(0, 0, 0, 30);
        GridLayout.LayoutParams titleParams = new GridLayout.LayoutParams();
        titleParams.columnSpec = GridLayout.spec(0, 3);
        titleParams.setGravity(android.view.Gravity.CENTER);
        title.setLayoutParams(titleParams);
        layout.addView(title);

        String[] buttonLabels = {"上", "左", "右", "下", "返回", "确认"};
        int[] positions = {0, 3, 5, 6, 8, 7};

        for (int i = 0; i < buttonLabels.length; i++) {
            Button button = new Button(this);
            button.setText(buttonLabels[i]);
            button.setTextSize(18);
            button.setPadding(20, 20, 20, 20);

            final int index = i;
            button.setOnClickListener(v -> {
                String[] chars = {"w", "a", "d", "s", "q", "f"};
                sendBluetoothData(chars[index]);
            });

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.columnSpec = GridLayout.spec(positions[i] % 3);
            params.rowSpec = GridLayout.spec(positions[i] / 3 + 1);
            params.setGravity(android.view.Gravity.FILL);
            params.width = 0;
            button.setLayoutParams(params);
            layout.addView(button);
        }

        setContentView(layout);
    }

    private void sendBluetoothData(String data) {
        // TODO: Implement Bluetooth LE functionality
        android.util.Log.d("Bluetooth", "Sending data: " + data);
    }
}
