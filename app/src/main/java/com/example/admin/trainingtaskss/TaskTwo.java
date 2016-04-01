package com.example.admin.trainingtaskss;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TaskTwo extends AppCompatActivity implements View.OnClickListener {

    Button satu,dua,tiga,empat,lima,enam,tujuh,delapan,sembilan,bal,nol,clea,del;
    EditText inC,outC;
    TextView hasi;
    String tempIncome,tempOutcome;
    int nilaiIn=0,nilaiOut=0,hasil=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inC = (EditText)findViewById(R.id.editText);
        outC = (EditText)findViewById(R.id.editText2);
        satu = (Button)findViewById(R.id.btn1);
        dua = (Button)findViewById(R.id.btn2);
        tiga = (Button)findViewById(R.id.btn3);
        empat = (Button)findViewById(R.id.btn4);
        lima = (Button)findViewById(R.id.btn5);
        enam = (Button)findViewById(R.id.btn6);
        tujuh = (Button)findViewById(R.id.btn7);
        delapan = (Button)findViewById(R.id.btn8);
        sembilan = (Button)findViewById(R.id.btn9);
        nol = (Button)findViewById(R.id.btn0);
        bal = (Button)findViewById(R.id.btnSD);
        clea = (Button)findViewById(R.id.btnC);
        hasi = (TextView)findViewById(R.id.txtBal);
        del = (Button)findViewById(R.id.btnDel);

        satu.setOnClickListener(this);
        dua.setOnClickListener(this);
        tiga.setOnClickListener(this);
        empat.setOnClickListener(this);
        lima.setOnClickListener(this);
        enam.setOnClickListener(this);
        tujuh.setOnClickListener(this);
        delapan.setOnClickListener(this);
        sembilan.setOnClickListener(this);
        nol.setOnClickListener(this);
        bal.setOnClickListener(this);
        clea.setOnClickListener(this);
        del.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1:
                handleNomor("1");
                break;
            case R.id.btn2:
                handleNomor("2");
                break;
            case R.id.btn3:
                handleNomor("3");
                break;
            case R.id.btn4:
                handleNomor("4");
                break;
            case R.id.btn5:
                handleNomor("5");
                break;
            case R.id.btn6:
                handleNomor("6");
                break;
            case R.id.btn7:
                handleNomor("7");
                break;
            case R.id.btn8:
                handleNomor("8");
                break;
            case R.id.btn9:
                handleNomor("9");
                break;
            case R.id.btn0:
                handleNomor("0");
                break;
            case R.id.btnSD:
                nilaiIn=Integer.parseInt(inC.getText().toString());
                nilaiOut=Integer.parseInt(outC.getText().toString());
                hasil=nilaiIn-nilaiOut;
                hasi.setText(String.valueOf(hasil));
                break;
            case R.id.btnC:
                clear();
                break;
                default:
                break;
            case R.id.btnDel:
                deletee();
                break;
        }
    }

    private void handleNomor(String nomor) {
        tempIncome = inC.getText().toString();
        tempOutcome = outC.getText().toString();
        if(inC.isFocused()){
            if(inC.getText().toString().equals("")){
                inC.setText(nomor);
            }else{
                int position = inC.getSelectionEnd();
                if(position != tempIncome.length()){
                    inC.getText().insert(position, nomor);
                }else{
                    inC.setText(String.valueOf(tempIncome + nomor));
                }
                inC.setSelection(inC.getText().length());
            }
        } else if (outC.isFocused()){
                if(outC.getText().toString().equals("")){
                    outC.setText(nomor);
                }else{
                    int position = outC.getSelectionEnd();
                    if(position != tempOutcome.length()){
                        outC.getText().insert(position, nomor);
                    }else{
                        outC.setText(String.valueOf(tempOutcome + nomor));
                    }
                    outC.setSelection(outC.getText().length());
                }
        }
    }
    private void deletee(){
        int positionIn = inC.getSelectionEnd();
        int positionOut = outC.getSelectionEnd();

        if(inC.isFocused()){
            if (inC==null){
                Toast.makeText(TaskTwo.this, "No number inputed", Toast.LENGTH_SHORT).show();
            }else{
                int position = inC.getSelectionEnd();
                inC.getText().delete(position - 1, positionIn);
            }
        } else if (outC.isFocused()){
            if (outC==null){
                Toast.makeText(TaskTwo.this, "No number inputed", Toast.LENGTH_SHORT).show();
            }else{
                int position = outC.getSelectionEnd();
                outC.getText().delete(position - 1, positionOut);
            }
        }

    }

    private void clear(){
        inC.setText("");
        outC.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_task_two, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
