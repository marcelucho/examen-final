package com.marcelo.club_marcelo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FragmentoRegistro extends Fragment {

    Button botonRegistroGuardar;
    EditText nombreEditText, telefonoEditText, documentoEditText;

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.fragment_registro, container, false);

        nombreEditText = (EditText) view.findViewById(R.id.txtNombre);
        telefonoEditText = (EditText) view.findViewById(R.id.txtTelefono);
        documentoEditText = (EditText) view.findViewById(R.id.txtDocumento);
        botonRegistroGuardar = (Button) view.findViewById(R.id.btnEnviar);

        botonRegistroGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nombreEditText.getText().toString();
                String phone = telefonoEditText.getText().toString();
                String document = documentoEditText.getText().toString();



                String url = "https://my-club-marcelo.onrender.com/api/saveMember";

                RequestQueue queue = Volley.newRequestQueue(getActivity());

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getActivity(), "Datos guardados exitosamente", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Error al guardar los datos " + error, Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("name", name);
                        params.put("phone", phone);
                        params.put("document", document);
                        return params;
                    }

                    @Override
                    public byte[] getBody() {
                        return new JSONObject(getParams()).toString().getBytes();
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }
                };
                queue.add(request);
            }
        });
        return view;
    }
}
