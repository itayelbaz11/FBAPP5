package com.example.fbapp5;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static com.example.fbapp5.FBref.refGrades;
import static com.example.fbapp5.FBref.refStudents;


public class MainActivity extends AppCompatActivity {

    EditText etNAME, etADD, etNUM, etHNUM, etMNAME, etMNUM, etDNAME, etDNUM, ETgname, ETgquarter, ETgrade, ETgsub, ETID, ETGID;
    String name, Mname, Dname, num, Mnum, Dnum, Hnum, address, Gname, Subject, ID, GID,grade, quarter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNAME = findViewById(R.id.name);
        etADD = findViewById(R.id.adress);
        etNUM = findViewById(R.id.phone);
        etHNUM = findViewById(R.id.homenum);
        etMNAME = findViewById(R.id.mother);
        etMNUM = findViewById(R.id.mothernum);
        etDNAME = findViewById(R.id.father);
        etDNUM = findViewById(R.id.fathernum);
        ETgname = findViewById(R.id.name1);
        ETgquarter = findViewById(R.id.reva);
        ETgrade = findViewById(R.id.grade);
        ETgsub = findViewById(R.id.subject);
        ETGID = findViewById(R.id.GID);
        ETID = findViewById(R.id.ID);
    }

    public void fstsub(View view) {
        name = etNAME.getText().toString();
        Mname = etMNAME.getText().toString();
        Dname = etDNAME.getText().toString();
        num = etNUM.getText().toString();
        Mnum = etMNUM.getText().toString();
        Dnum = etDNUM.getText().toString();
        Hnum = etHNUM.getText().toString();
        address = etADD.getText().toString();
        ID = ETID.getText().toString();
        Student S = new Student(name, address, num, ID, Hnum, Dnum, Dname, Mnum, Mname);
        refStudents.child(ID).setValue(S);
    }

    public void sndsub(View view) {


        Gname = ETgname.getText().toString();
        Subject = ETgsub.getText().toString();
        grade = ETgrade.getText().toString();
        quarter = ETgquarter.getText().toString();
        GID = ETGID.getText().toString();
        Grade G = new Grade(GID, Gname, Subject, grade, quarter);
        refGrades.child(GID).setValue(G);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("info")){
            Intent si = new Intent(this, info.class);
            startActivity(si);
        }
        if(st.equals("sort")){
            Intent si = new Intent(this,sort.class);
            startActivity(si);
        }
        if (st.equals("creds")){
            Intent si = new Intent(this,credits.class);
            startActivity(si);
        }
        return true;
    }

}