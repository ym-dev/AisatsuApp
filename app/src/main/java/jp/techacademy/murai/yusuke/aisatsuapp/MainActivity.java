package jp.techacademy.murai.yusuke.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        int hour = hourOfDay;
                        int min = minute;
                        showTextView(hour, min);
                    }
                },
                24, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();

    }

    private void showTextView(int hour, int min) {
        Log.d("UI-PARTS", "showTextView: " + String.valueOf(hour) + ":" + String.valueOf(min));
        if (hour >= 2 && hour < 10){
            Log.d("UI-PARTS","おはよう");
            mTextView.setText("おはよう");
        }else if (hour >= 10 && hour < 18){
            Log.d("UI-PARTS","こんにちは");
            mTextView.setText("こんにちは");
        }else{
            Log.d("UI-PARTS","こんばんは");
            mTextView.setText("こんばんは");
        }




    }
}
