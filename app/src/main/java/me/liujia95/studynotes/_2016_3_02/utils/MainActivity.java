package me.liujia95.studynotes._2016_3_02.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import me.liujia95.studynotes.R;
import me.liujia95.studynotes._2016_3_02.ChattingActivity;
import me.liujia95.studynotes._2016_3_02.JChattingActivity;

/**
 * Created by Jacksgong on 15/7/1.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_panel_switch);

        setTitle(R.string.activity_main_title);

    }

    public void onClickResolved(final View view) {
        startActivity(new Intent(this, JChattingActivity.class));
    }

    public void onClickUnResolved(final View view) {
        // 使用差别只是未使用CustomContentRootLayout与PanelRotLayout 并且在切换的时候未使用PanelRootLayout#setIsHide
        startActivity(new Intent(this, ChattingActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_keyboard_panel_switch, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_github:
                openGitHub();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openGitHub() {
        Uri uri = Uri.parse(getString(R.string.app_github_url));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}
