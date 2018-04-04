package mobile.una.br.sendmessage.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import mobile.una.br.sendmessage.R;

public class LoginActivity extends Activity {

    private FirebaseAuth firebaseAuth;
    private EditText email;
    private EditText senha;
    private Button logar;
    private TextView novoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.txt_login);
        senha = (EditText) findViewById(R.id.txt_senha);
        novoUsuario = (TextView) findViewById(R.id.txt_novo_usuario);
        logar = (Button)findViewById(R.id.btn_login) ;

        novoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, NewUserActivity.class));
            }
        });

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString()
                        , senha.getText().toString())
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Login com sucesso!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                } else {
                                    Log.e("Erro Login", task.getException().getMessage());
                                    Toast.makeText(LoginActivity.this, "Falha ao Efetuar Login", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });



    }
}
