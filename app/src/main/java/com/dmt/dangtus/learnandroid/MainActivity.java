package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SeekBar skPlayer1, skPlayer2, skPlayer3;
    RadioButton rbPlayer1Chose, rbPlayer2Chose, rbPlayer3Chose;
    ImageButton btnPlayButton;
    TextView txtThongBao, txtPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        //onload
        skPlayer1.setEnabled(false);
        skPlayer2.setEnabled(false);
        skPlayer3.setEnabled(false);
        txtThongBao.setText("");

        //Day la ham de chay
        CountDownTimer countDownTimer = new CountDownTimer(50000, 100) {
            @Override
            public void onTick(long l) {
                Random random = new Random();
                skPlayer1.setProgress(skPlayer1.getProgress() + random.nextInt(5)+1);
                skPlayer2.setProgress(skPlayer2.getProgress() + random.nextInt(5)+1);
                skPlayer3.setProgress(skPlayer3.getProgress() + random.nextInt(5)+1);

                //kiem tra player nao dang dan dau
                int[] currentPoint = {skPlayer1.getProgress(), skPlayer2.getProgress(), skPlayer3.getProgress()};
                int max = 0;
                for (int i = 1; i <= 2; i++) {
                    if (currentPoint[i] > currentPoint[max]) {
                        max = i;
                    }
                }
                if (max == 0) {
                    txtThongBao.setText("\"" + rbPlayer1Chose.getText() + "\"" + " đang dẫn đầu");
                } else if (max == 1) {
                    txtThongBao.setText("\"" + rbPlayer2Chose.getText() + "\"" + " đang dẫn đầu");
                } else {
                    txtThongBao.setText("\"" + rbPlayer3Chose.getText() + "\"" + " đang dẫn đầu");
                }


                //su kien khi mot trong 3 ve dich
                if(skPlayer1.getProgress() == skPlayer1.getMax() || skPlayer2.getProgress() == skPlayer2.getMax() || skPlayer3.getProgress() == skPlayer3.getMax()) {
                    this.cancel();
                    btnPlayButton.setVisibility(View.VISIBLE);

                    //kiem tra xem player nao ve dich
                    String thongBao = "";
                    if(skPlayer1.getProgress() == skPlayer1.getMax()) {
                        thongBao += "\"" + rbPlayer1Chose.getText() + "\" đã về đích đầu tiên";
                        thongBao += kiemTraChose(rbPlayer1Chose);
                    } else if(skPlayer2.getProgress() == skPlayer2.getMax()) {
                        thongBao += "\"" + rbPlayer2Chose.getText() + "\" đã về đích đầu tiên";
                        thongBao += kiemTraChose(rbPlayer2Chose);
                    } else {
                        thongBao += "\"" + rbPlayer3Chose.getText() + "\" đã về đích đầu tiên";
                        thongBao += kiemTraChose(rbPlayer3Chose);
                    }

                    //thong bao
                    txtThongBao.setText(thongBao);

                    enableRadioButton();
                }
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };

        //su kien click vao nut play
        btnPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kiem tra xem da chon player nao WIN hay chua
                if(rbPlayer1Chose.isChecked() || rbPlayer2Chose.isChecked() || rbPlayer3Chose.isChecked()) {
                    skPlayer1.setProgress(0);
                    skPlayer2.setProgress(0);
                    skPlayer3.setProgress(0);

                    countDownTimer.start();
                    btnPlayButton.setVisibility(View.INVISIBLE);

                    txtThongBao.setText("");

                    disableRadioButton();
                } else {
                    txtThongBao.setText("Chọn ai WIN trước đi đã");
                }
            }
        });
    }

    private String kiemTraChose(RadioButton rbPlayerChose) {

        //new chon dung thi point +10, sai thi point -5
        int point = Integer.parseInt(txtPoint.getText().toString());
        if(rbPlayerChose.isChecked()) {
            point += 10;
            txtPoint.setText(point+"");
            return ", Bạn đoán giỏi quá nè è è è è è";
        } else {
            point -= 5;
            txtPoint.setText(point+"");
            return ", Bạn đoán sai rồi nhé é é é é é";
        }
    }

    private void anhXa() {
        skPlayer1 = (SeekBar) findViewById(R.id.player1);
        skPlayer2 = (SeekBar) findViewById(R.id.player2);
        skPlayer3 = (SeekBar) findViewById(R.id.player3);

        rbPlayer1Chose = (RadioButton) findViewById(R.id.player1Chose);
        rbPlayer2Chose = (RadioButton) findViewById(R.id.player2Chose);
        rbPlayer3Chose = (RadioButton) findViewById(R.id.player3Chose);

        btnPlayButton = (ImageButton) findViewById(R.id.playButton);
        txtThongBao = (TextView) findViewById(R.id.thongBao);
        txtPoint = (TextView) findViewById(R.id.point);
    }

    private void disableRadioButton() {
        rbPlayer1Chose.setEnabled(false);
        rbPlayer2Chose.setEnabled(false);
        rbPlayer3Chose.setEnabled(false);
    }

    private void enableRadioButton() {
        rbPlayer1Chose.setEnabled(true);
        rbPlayer2Chose.setEnabled(true);
        rbPlayer3Chose.setEnabled(true);
    }
}