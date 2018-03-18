package mobile.una.br.sendmessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SenderActivity extends Activity {

    private EditText mensagem;
    private Button enviarMensagem;
    public static final String MENSAGEM_ENVIADA = "SenderActivity.MENSAGEM_ENVIADA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        mensagem = (EditText) findViewById(R.id.txt_mensagem);
        enviarMensagem = (Button) findViewById(R.id.btn_enviar);

        enviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenderActivity.this, ReceiverActivity.class);
                intent.putExtra(SenderActivity.MENSAGEM_ENVIADA, mensagem.getText().toString());
                startActivity(intent);

            }
        });


    }


}
