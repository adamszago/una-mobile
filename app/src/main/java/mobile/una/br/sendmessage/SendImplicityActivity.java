package mobile.una.br.sendmessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendImplicityActivity extends Activity {

    private EditText assunto;
    private EditText mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_implicity);

        assunto = findViewById(R.id.txt_assunto);
        mensagem = findViewById(R.id.txt_mensagem);

    }

    public void enviarMensagemImplicita(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto.getText());
        intent.putExtra(Intent.EXTRA_TEXT, mensagem.getText());
        intent.setType("text/plain");
        startActivity(intent);
        //startActivity(Intent.createChooser(intent, "Escolha a opção:"));



    }
}
