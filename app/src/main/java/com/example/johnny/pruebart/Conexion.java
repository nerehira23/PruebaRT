package com.example.johnny.pruebart;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Conexion {

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    public Conexion(){
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference();
    }
    public DatabaseReference getInstance(){
        return this.myRef;
    }

}
