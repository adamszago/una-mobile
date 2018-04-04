package mobile.una.br.sendmessage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import mobile.una.br.sendmessage.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicial, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_explic:
                startActivity(new Intent(this, SenderActivity.class));
                return true;
            case R.id.menu_implic:
                startActivity(new Intent(this, SendImplicityActivity.class));
                return true;
            case R.id.menu_lifecycle:
                startActivity(new Intent(this, LifecycleActivity.class));
                return true;
            case R.id.menu_sair:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
