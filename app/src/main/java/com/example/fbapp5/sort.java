package com.example.fbapp5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.fbapp5.FBref.refGrades;
import static com.example.fbapp5.FBref.refStudents;
public class sort extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv,lv2;
    ArrayList<String> stuList = new ArrayList<String>();
    ArrayList<Student> stuValues = new ArrayList<Student>();
    ArrayList<String> GList = new ArrayList<String>();
    ArrayList<Grade> GValues = new ArrayList<Grade>();
    ArrayAdapter adp,adp2;
    AlertDialog.Builder adb;
    String strtmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        lv = (ListView) findViewById(R.id.lvT);
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lv2 = (ListView) findViewById(R.id.lvR);
        lv2.setOnItemClickListener(this);
        lv2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    /**
     * These methods sort the data with different parameters that you choose
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    public void byid1(View view) {
        Query query = refStudents.orderByChild("id");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
//
       @Override
       public void onDataChange(DataSnapshot dS) {
           stuList.clear();
           stuValues.clear();
           for(DataSnapshot data : dS.getChildren()) {
               String str1 = (String) data.getKey();
               Student stuTmp = data.getValue(Student.class);
               stuValues.add(stuTmp);
               String str2 = stuTmp.getName();
               stuList.add(str1+" "+str2);
           }
           adp = new ArrayAdapter<String>(sort.this,R.layout.support_simple_spinner_dropdown_item, stuList);
           lv.setAdapter(adp);
             }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
           });





    }



    public void byname(View view) {

        Query query = refStudents.orderByChild("name");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            //
            @Override
            public void onDataChange(DataSnapshot dS) {
                stuList.clear();
                stuValues.clear();
                for(DataSnapshot data : dS.getChildren()) {
                    String str1 = (String) data.getKey();
                    Student stuTmp = data.getValue(Student.class);
                    stuValues.add(stuTmp);
                    String str2 = stuTmp.getName();
                    stuList.add(str1+" "+str2);
                }
                adp = new ArrayAdapter<String>(sort.this,R.layout.support_simple_spinner_dropdown_item, stuList);
                lv.setAdapter(adp);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

    }








    public void byid2(View view) {
        Query query = refGrades.orderByChild("stuid");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            //
            @Override
            public void onDataChange(DataSnapshot dS) {
                GList.clear();
                GValues.clear();
                for(DataSnapshot data : dS.getChildren()) {
                    String str1 = (String) data.getKey();
                    Grade GTmp = data.getValue(Grade.class);
                    GValues.add(GTmp);
                    String str2 = GTmp.getGname();
                    GList.add(str1+" "+str2);
                }
                adp2 = new ArrayAdapter<String>(sort.this,R.layout.support_simple_spinner_dropdown_item,GList);
                lv2.setAdapter(adp2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }

    public void bygrade(View view) {
        Query query = refGrades.orderByChild("grade");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            //
            @Override
            public void onDataChange(DataSnapshot dS) {
                GList.clear();
                GValues.clear();
                for(DataSnapshot data : dS.getChildren()) {
                    String str1 = (String) data.getKey();
                    Grade GTmp = data.getValue(Grade.class);
                    GValues.add(GTmp);
                    String str2 = GTmp.getGname();
                    GList.add(str1+" "+str2);
                }
                adp2 = new ArrayAdapter<String>(sort.this,R.layout.support_simple_spinner_dropdown_item,GList);
                lv2.setAdapter(adp2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        if(adapterView==lv){
            adb = new AlertDialog.Builder(this);
            adb.setTitle(stuValues.get(pos).getName());
            final String strstuID=stuValues.get(pos).getId();
            strtmp="Name: "+stuValues.get(pos).getName()+"\n";
            strtmp+="ID: "+stuValues.get(pos).getId()+"\n";
            strtmp+="Adress: "+String.valueOf(stuValues.get(pos).getAdress())+" ";
            strtmp+="Phone: "+String.valueOf(stuValues.get(pos).getPhone())+" ";
            strtmp+="FName: "+String.valueOf(stuValues.get(pos).getFname())+" ";
            strtmp+="FPhone: "+String.valueOf(stuValues.get(pos).getFphone())+" ";
            strtmp+="Mname: "+String.valueOf(stuValues.get(pos).getMname())+" ";
            strtmp+="MPhone: "+String.valueOf(stuValues.get(pos).getMphone())+" ";
            strtmp+="Hphone: "+String.valueOf(stuValues.get(pos).getHphone())+" ";
            adb.setMessage(strtmp);
            adb.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    refStudents.child(strstuID).removeValue();
                }
            });

            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog ad = adb.create();
            ad.show();
        }
        else{
            adb = new AlertDialog.Builder(this);
            adb.setTitle(GValues.get(pos).getGname());
            final String strgID=GValues.get(pos).getStuid();
            strtmp="Name: "+GValues.get(pos).getGname()+"\n";
            strtmp+="ID: "+GValues.get(pos).getStuid()+"\n";
            strtmp+="Grade: "+String.valueOf(GValues.get(pos).getGrade())+" ";
            strtmp+="Quarter: "+String.valueOf(GValues.get(pos).getQuarter())+" ";
            strtmp+="Subject: "+String.valueOf(GValues.get(pos).getSubject())+" ";
            adb.setMessage(strtmp);
            adb.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    refGrades.child(strgID).removeValue();
                }
            });

            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog ad = adb.create();
            ad.show();


        }

    }

    /**
     * creates options menu
     * @return
     */



    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("main")) {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        if (st.equals("info")){
            Intent si = new Intent(this, info.class);
            startActivity(si);
        }

        if (st.equals("creds")){
            Intent si = new Intent(this, credits.class);
            startActivity(si);
        }
        return true;
    }


}
