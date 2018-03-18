package mobile.una.br.sendmessage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

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
