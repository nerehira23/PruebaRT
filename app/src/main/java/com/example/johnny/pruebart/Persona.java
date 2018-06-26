package com.example.johnny.pruebart;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Persona {
    private String id;
    private String nombre;
    private Map<String,Boolean> stars=new HashMap<>();

    public Persona(String id,String nombre){
        this.id=id;
        this.nombre=nombre;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("nombre", nombre);
        return result;
    }
}
