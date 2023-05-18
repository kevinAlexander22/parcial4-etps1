package sv.edu.usam.crudapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import sv.edu.usam.crudapp.datos.Provedores;


public class MensajesFragment extends Fragment {

    Button btnGuardar;
    Context context;
    EditText txtNomprov,txtTelProv,txtCorrProv,tvMensaje;
    public MensajesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*    AppCompatActivity appCompatActivity = new AppCompatActivity();
        txtNomprov=appCompatActivity.findViewById(R.id.edtNOMPROV);
        txtTelProv=appCompatActivity.findViewById(R.id.edtTELPROV);
        txtCorrProv=appCompatActivity.findViewById(R.id.edtCORPROV);
        btnGuardar=appCompatActivity.findViewById(R.id.btnGuardar);
        tvMensaje=

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Provedores baseProv = (Provedores) new BaseHelper(MensajesFragment.this);
              long codigoSave=  baseProv.insertProvedor(txtNomprov.getText().toString(),txtTelProv.getText().toString(),txtCorrProv.getText().toString());
                if(codigoSave>0){
                    Toast.makeText(context, "Registro insertado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Error al insertar", Toast.LENGTH_SHORT).show();
                }


            }
        });
            txtNomprov.setText("Prueba");
            return view;*/
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_mensajes,container,false);

        View view=inflater.inflate(R.layout.fragment_mensajes,container,false);
        txtNomprov=view.findViewById(R.id.edtIdCli);
        txtTelProv=view.findViewById(R.id.edtIdVechiculo);
        txtCorrProv=view.findViewById(R.id.edtmatricula);
        btnGuardar=view.findViewById(R.id.btnGuardar);
        tvMensaje=view.findViewById(R.id.tvmensajes);

                btnGuardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Provedores baseProv =  new Provedores(context);
                        long codigoSave=  baseProv.insertProvedor(txtNomprov.getText().toString(),txtTelProv.getText().toString(),txtCorrProv.getText().toString());
                        if(codigoSave>0){
                            tvMensaje.append("Registro insertado");
                        }else{
                            tvMensaje.append("Error al insertar");
                        }


                    }
                });
        txtNomprov.setText("Prueba");
        return view;

        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_mensajes, container, false);
    }
}