package my.com.itrain.lcalculator;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.id.progress;

public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final EditText property = (EditText) findViewById(R.id.property);
    final EditText payment = (EditText) findViewById(R.id.payment);
    final EditText interest = (EditText) findViewById(R.id.interest);
    final EditText year = (EditText) findViewById(R.id.year);
    final TextView total = (TextView) findViewById(R.id.cal);

    final Button calculate = (Button) findViewById(R.id.calculate);
    calculate.setOnClickListener(new View.OnClickListener() {
      @RequiresApi(api = Build.VERSION_CODES.N)
      @Override
      public void onClick(View view) {
        double Property = Float.parseFloat(property.getText().toString());
        double Down = Float.parseFloat(payment.getText().toString());
        double Interest = Float.parseFloat(interest.getText().toString());
        double Year = Integer.parseInt(year.getText().toString());
        double annualInterest = Interest / 12;
        double Months = Year * 12;
        double balance = Property - Down;
        double leftoperation = Math.pow((1 + annualInterest), Months);
        double rightoperation = annualInterest * leftoperation;
        double loanTotal = leftoperation / rightoperation;
        double Monthly = balance / loanTotal;
        total.setText(new DecimalFormat("##.##").format(leftoperation));
      }
    });
  }
}
