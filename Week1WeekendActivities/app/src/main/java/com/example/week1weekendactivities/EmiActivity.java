package com.example.week1weekendactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class EmiActivity extends AppCompatActivity {
    TextView tvEmiValue, tvTotalPaidValue, tvInterestPaidValue, tvPrincipal, tvInterest, tvDuration;
    SeekBar principalBar, interestBar, durationBar;

    final static double principalMin = 100000;
    final static double principalMax = 1000000 - principalMin;
    final static int durationMin = 60;

    double principal, interest, emi, totalPayment, totalInterest;
    int duration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);

        //Bind TextViews
        tvEmiValue = findViewById(R.id.emiValue);
        tvTotalPaidValue = findViewById(R.id.totalPaidValue);
        tvInterestPaidValue = findViewById(R.id.interestPaidValue);
        tvPrincipal = findViewById(R.id.principal);
        tvInterest = findViewById(R.id.interest);
        tvDuration = findViewById(R.id.duration);

        //Bind SeekBars
        principalBar = findViewById(R.id.principalBar);
        interestBar = findViewById(R.id.interestBar);
        durationBar = findViewById(R.id.durationBar);

        //calculate values from default SeekBar progress
        principal = getPrincipal(principalBar.getProgress());
        interest = getInterest(interestBar.getProgress());
        duration = getDuration(durationBar.getProgress());
        emi = getEMI(principal,interest, duration);
        totalPayment = getTotalPayment(emi,duration);
        totalInterest = getTotalInterest(totalPayment,principal);

        //Display default values for SeekBars in corresponding TextViews
        tvPrincipal.setText(String.format("Principal Amount: $%.2f", principal));
        tvInterest.setText(String.format("Interest: %.1f%%", interest*100));
        tvDuration.setText(String.format("Duration: %d months",duration));
        tvEmiValue.setText(String.format("$%.2f", emi));
        tvTotalPaidValue.setText(String.format("$%.2f", totalPayment));
        tvInterestPaidValue.setText(String.format("$%.2f", totalInterest));

        //make SeekBarListener
        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                switch(seekBar.getId()){
                    case R.id.principalBar:
                        principal = getPrincipal(progress);
                        tvPrincipal.setText(String.format("Principal Amount: $%.2f", principal));
                        break;
                    case R.id.interestBar:
                        interest = getInterest(progress);
                        tvInterest.setText(String.format("Interest: %.1f%%", interest*100));
                        break;
                    case R.id.durationBar:
                        duration = getDuration(progress);
                        tvDuration.setText(String.format("Duration: %d months",duration));
                        break;
                }
                emi = getEMI(principal, interest, duration);
                totalPayment = getTotalPayment(emi,duration);
                totalInterest = getTotalInterest(totalPayment,principal);
                tvEmiValue.setText(String.format("$%.2f", emi));
                tvTotalPaidValue.setText(String.format("$%.2f", totalPayment));
                tvInterestPaidValue.setText(String.format("$%.2f", totalInterest));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        //attach SeekBarListener to SeekBars
        principalBar.setOnSeekBarChangeListener(seekBarChangeListener);
        interestBar.setOnSeekBarChangeListener(seekBarChangeListener);
        durationBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }


    public double getPrincipal(int progress){
        return (principalMin + ( ((double)progress / (double)principalBar.getMax()) * principalMax));
    }

    public double getInterest(int progress){
        return (double)progress / 1000;
    }

    public int getDuration(int progress){
        return durationMin + progress;
    }

    public double getEMI(double principal, double interest, int duration){
        double monthlyInterest = interest / 12;
        return principal * (monthlyInterest * Math.pow(1+monthlyInterest,duration)) / ((Math.pow(1+monthlyInterest,duration)-1));
    }

    public double getTotalPayment(double EMI, int duration){return EMI * (double)duration;}

    public double getTotalInterest(double totalPayment, double principal){return totalPayment - principal;}

}
