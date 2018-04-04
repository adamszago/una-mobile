package mobile.una.br.sendmessage.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import mobile.una.br.sendmessage.R;

public class NewUserActivity extends Activity {

    private FirebaseAuth firebaseAuth;
    private EditText emailNewUser;
    private EditText senhaNewUser;
    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        firebaseAuth = FirebaseAuth.getInstance();
        emailNewUser = (EditText) findViewById(R.id.txt_email_new_user);
        senhaNewUser = (EditText) findViewById(R.id.txt_senha_new_user);
        salvar = (Button) findViewById(R.id.btn_cadastrar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.createUserWithEmailAndPassword(emailNewUser.getText().toString()
                        , senhaNewUser.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(NewUserActivity.this, "Usuário cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(NewUserActivity.this, LoginActivity.class));
                                } else {
                                    Toast.makeText(NewUserActivity.this, "Falha ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}
