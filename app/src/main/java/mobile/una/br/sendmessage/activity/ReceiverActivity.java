package mobile.una.br.sendmessage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import mobile.una.br.sendmessage.R;

public class ReceiverActivity extends Activity {

    private TextView mensagemRecebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        mensagemRecebida = (TextView) findViewById(R.id.txt_mensagem_recebida);

        if(getIntent().hasExtra(SenderActivity.MENSAGEM_ENVIADA)){
            mensagemRecebida.setText(getIntent().getExtras().getString(SenderActivity.MENSAGEM_ENVIADA));
        }
    }
}
