package com.example.johnny.pruebart;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.Calendar;

public class PuntoVenta extends AppCompatActivity {

    public static final String TAG="MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private ImageView addProducto;
    private LinearLayout layoutPrincipal;
    /////VARIABLES
    private Conexion conexion;
    private EditText id;
    private EditText tipo_cambio;
    private EditText fecha;
    private EditText nombre_cliente;
    private ImageView addVenta;
    private RadioButton con_iva;
    private RadioButton sin_iva;
    Producto producto = new Producto();

    private EditText sub_total_f;
    private EditText total_iva_f;
    private EditText total_f;
    double iva=0;
    double total_totales=0;
    int int_id=2;
    int int_id_trasn=11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto_venta);
       /* String url="file:///android_asset/formPtv.html";
        view=(WebView)findViewById(R.id.vistaPtc);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);*/
        cargarCalender();
        cargarDetalle();


        producto.setId("11");
        producto.setNombre("lapiz"); //nomp
        producto.setCosto("2"); //precio
        producto.setCantidad("5"); //myLayout.addView(cantidad);

        conexion=new Conexion();
        id=(EditText)findViewById(R.id.id_venta);
        tipo_cambio=(EditText)findViewById(R.id.tipo_cambio);
        fecha=(EditText)findViewById(R.id.fecha);
        nombre_cliente=(EditText)findViewById(R.id.nombre_cliente);
        addVenta=(ImageView)findViewById(R.id.addVenta);
        con_iva=(RadioButton)findViewById(R.id.con_iva);
        sin_iva=(RadioButton)findViewById(R.id.sin_iva);
        sub_total_f = (EditText) findViewById(R.id.sub_total);
        total_iva_f = (EditText) findViewById(R.id.total_iva);
        total_f = (EditText)findViewById(R.id.total);


        addVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference x=conexion.getInstance();

                Trans2 trans2 = new Trans2();
                trans2.setId(id.getText().toString());
                trans2.setTc(tipo_cambio.getText().toString());
                trans2.setFecha(fecha.getText().toString());
                trans2.setNombre_cli(nombre_cliente.getText().toString());
                trans2.setTotal(total_f.getText().toString()); //toma el costo del producto; ya no es hardcoded
                trans2.setProducto(producto);

                try {
                    //x.child("Persona").child(tipo_cambio.getText().toString()).setValue(nombre_cliente.getText().toString());
                    //en Transactions crea el nodo user5
                    x.child("/Transactions/user6/").setValue(trans2);

                    //aumentar el int_id y el int_id_trasn
                    AsientoItem asientoItem = new AsientoItem();
                    asientoItem.setId(String.valueOf(int_id));
                    asientoItem.setDebe("0");
                    asientoItem.setDescripcion("venta lapiz");
                    asientoItem.setEstado("activo");
                    asientoItem.setFecha(fecha.getText().toString());
                    asientoItem.setHaber(total_f.getText().toString());
                    asientoItem.setTransacion_id(String.valueOf(int_id_trasn));
                    asientoItem.setUser_id("100");
                    x.child("/Asiento/asiento5/").setValue(asientoItem);
                    Toast.makeText(PuntoVenta.this, "Insertado Correctamente", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(PuntoVenta.this, "Error insercion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cargarCalender(){
        mDisplayDate=(EditText)findViewById(R.id.fecha);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(
                        PuntoVenta.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                mDisplayDate.setText(date);
            }
        };
    }
    private void cargarDetalle(){
        layoutPrincipal=(LinearLayout)findViewById(R.id.relative);
        addProducto=(ImageView)findViewById(R.id.addProducto);

        addProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nomp=new EditText(PuntoVenta.this);
                EditText precio=new EditText(PuntoVenta.this);
                EditText cantidad=new EditText(PuntoVenta.this);
                EditText total=new EditText(PuntoVenta.this);
                LinearLayout myLayout=new LinearLayout(PuntoVenta.this);
                myLayout.setOrientation(LinearLayout.HORIZONTAL);

                nomp.setLayoutParams(new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                ));
                //nomp.setWidth(530);
                nomp.setWidth(360);
                nomp.setText(producto.getNombre());


                precio.setLayoutParams(new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                ));
                //precio.setWidth(180);
                precio.setWidth(110);
                precio.setText(producto.getCosto());


                cantidad.setLayoutParams(new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                ));
                //cantidad.setWidth(180);
                cantidad.setWidth(110);
                cantidad.setText(producto.getCantidad());

                total.setLayoutParams(new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                ));
                //total.setWidth(200);
                total.setWidth(110);
                double total_prod= Double.parseDouble(producto.getCosto()) * Double.parseDouble(producto.getCantidad());
                total.setText(String.valueOf(total_prod));


                myLayout.addView(nomp);
                myLayout.addView(precio);
                myLayout.addView(cantidad);
                myLayout.addView(total);
                layoutPrincipal.addView(myLayout);

                //Funcion que calcule e inserte los datos del pie de formulario
                //1. sumar  y 2. escribir el setText
                sub_total_f.setText(String.valueOf(total_prod));
                calcular_iva();
                total_iva_f.setText(String.valueOf(iva));
                total_totales=total_prod + iva;
                total_f.setText(String.valueOf(total_totales));
            }
        });
    }

    private void calcular_iva(){
        if (con_iva.isChecked()){
            iva= Double.parseDouble(producto.getCosto()) *0.13;
            //double new_costo= iva+ Double.parseDouble(producto.getCosto());
            //producto.setCosto(String.valueOf(new_costo));
            //aqui el producto ya tiene el costo con el iva sumado
        } else {
            // el iva se mantine en cero... al inicio esta inicializado en 0 (cero)
        }
    }

}
