package com.example.sowmya.smarthomeairmonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdminMain extends AppCompatActivity {
    private static Button btnTemp, btnHum, btnGas;
   // private EditText et;
    RadioGroup rg;
    String url="";
    RadioButton loc,loc1;

    RadioButton selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        OnClickButtonListenerTemp();
        OnClickButtonListenerHum();
        OnClickButtonListenerGas();
        url=getIntent().getExtras().getString("ip");
        loc=(RadioButton)findViewById(R.id.loc);
        loc1=(RadioButton)findViewById(R.id.loc1);
    }

    public void OnClickButtonListenerTemp()
    {
        btnTemp= (Button)findViewById(R.id.button5);
        btnTemp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdminMain.this,TempForAdmin.class);


                        intent.putExtra("ip",url);
                        intent.putExtra("type","");
                        intent.putExtra("moni","temp");
                        //intent.putExtra("loc","");
                        //selected=(RadioButton)findViewById(rg.getCheckedRadioButtonId());

                     if(loc.isChecked()){
                         intent.putExtra("loc","klef");
                         startActivity(intent);
                     }else if(loc1.isChecked()){
                         intent.putExtra("loc","klu");
                         startActivity(intent);
                     }else{
                         Toast.makeText(AdminMain.this,"select one",Toast.LENGTH_LONG).show();
                     }

                    }
                }
        );
    }

    public void OnClickButtonListenerHum()
    {
        btnHum= (Button)findViewById(R.id.button6);
        btnHum.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdminMain.this,TempForAdmin.class);
                        intent.putExtra("ip",url);
                        intent.putExtra("type","");
                        intent.putExtra("moni","temp");
                        //intent.putExtra("loc","");
                     if(rg.getCheckedRadioButtonId()==R.id.loc){
                         intent.putExtra("loc","klef");
                     }else {
                         intent.putExtra("loc","klu");
                     }
                        startActivity(intent);
                    }
                }
        );
    }

    public void OnClickButtonListenerGas()
    {
        btnGas= (Button)findViewById(R.id.button7);
        btnGas.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent("com.example.sowmya.smarthomeairmonitor.TempForAdmin");
                        intent.putExtra("ip",url);
                        intent.putExtra("type","");
                        intent.putExtra("moni","temp");
                        //intent.putExtra("loc","");
                     if(rg.getCheckedRadioButtonId()==R.id.loc){
                         intent.putExtra("loc","klef");
                     }else {
                         intent.putExtra("loc","klu");
                     }
                        startActivity(intent);
                    }
                }
        );
    }
}
