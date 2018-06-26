package com.example.johnny.pruebart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Asientos extends AppCompatActivity {

    private ListView listView;
    private List<String> result;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asientos);

        listView=(ListView) findViewById(R.id.listAsiento);
        result=new ArrayList<>();
        databaseReference=FirebaseDatabase.getInstance().getReference();
        cargarAsientos();
        final ArrayAdapter<String > adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result);
        listView.setAdapter(adapter);

    }
    private void cargarAsientos(){
        databaseReference.child("Asiento").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator i = (Iterator) dataSnapshot.getChildren().iterator();
                while (i.hasNext()){
                    DataSnapshot instantanea = (DataSnapshot) i.next();
                   // Toast.makeText(Asientos.this,instantanea.getValue().toString(), Toast.LENGTH_SHORT).show();
                    String fecha=instantanea.child("fecha").getValue().toString();
                    String descripcion=instantanea.child("descripcion").getValue().toString();
                    String debe=instantanea.child("debe").getValue().toString();
                    String haber=instantanea.child("haber").getValue().toString();
                    //result.add(instantanea.getValue().toString());
                    result.add(fecha+"   "+descripcion+"   "+debe+"   "+haber);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Asientos.this, "Cancelado", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
