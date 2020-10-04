package com.dygames.cia;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SignUpFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);

        final EditText name = rootView.findViewById(R.id.signup_name_editText);
        final EditText email = rootView.findViewById(R.id.signup_email_editText);
        final EditText pw = rootView.findViewById(R.id.signup_pw_editText);
        final EditText pwCheck = rootView.findViewById(R.id.signup_pw_check_editText);
        final EditText phone = rootView.findViewById(R.id.signup_phone_editText);


        Button signUp = rootView.findViewById(R.id.signup_button);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name", name.getText().toString().trim());
                values.put("password", pw.getText().toString().trim());
                values.put("email", email.getText().toString().trim());
                values.put("phonenm", phone.getText().toString().trim().replace("-", ""));
                HttpURLConnection urlConn = null;
                try {
                    URL url = new URL("http://cia777.cafe24.com/api/users/signup");
                    urlConn = (HttpURLConnection) url.openConnection();

                    urlConn.setReadTimeout(10000);
                    urlConn.setConnectTimeout(15000);
                    urlConn.setRequestMethod("POST");
                    urlConn.setDoOutput(true);
                    urlConn.setDoInput(true);
                    urlConn.setRequestProperty("Accept-Charset", "utf-8");
                    urlConn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded");

                    PrintWriter ppw = new PrintWriter(new OutputStreamWriter(urlConn.getOutputStream()));
                    ppw.write(String.format("name=%s&password=%s&email=%s&phonenm=%s", name.getText().toString().trim(), pw.getText().toString().trim(),
                            email.getText().toString().trim(), phone.getText().toString().trim().replace("-", "")));
                    ppw.flush();
                    ppw.close();

                    if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                        Toast.makeText(getContext(), "회원 가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "회원 가입에 성공했습니다.", Toast.LENGTH_SHORT).show();
                        getActivity().getFragmentManager().popBackStack();
                    }
                    return;
/*
                    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));

                    String line;
                    String page = "";

                    while ((line = reader.readLine()) != null) {
                        page += line;
                    }
*/
                } catch (MalformedURLException e) {
                    Log.d("EERRR", e.getMessage());
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("EERRR", e.getMessage());

                } finally {
                    if (urlConn != null)
                        urlConn.disconnect();
                }

            }
        });
        return rootView;
    }
}
