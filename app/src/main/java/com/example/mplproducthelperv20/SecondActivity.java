package com.example.mplproducthelperv20;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.github.javiersantos.appupdater.AppUpdater;
        import com.github.javiersantos.appupdater.enums.Display;
        import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        AppUpdater appUpdater = new AppUpdater(this);
        appUpdater.setDisplay(Display.DIALOG);
        appUpdater.setUpdateFrom(UpdateFrom.JSON);
        appUpdater.setUpdateJSON("https://raw.githubusercontent.com/LandsKapten/ProductHelper/master/app/update-changelog.json");
        appUpdater.setTitleOnUpdateAvailable("Update available");
        appUpdater.setTitleOnUpdateNotAvailable("Update not available");
        appUpdater.setContentOnUpdateNotAvailable("No update available. Check for updates again later!");
        appUpdater.setButtonUpdate("Update now");
        appUpdater.setButtonDoNotShowAgain(null);
        appUpdater.setCancelable(false);
        appUpdater.start();


        Button coalButton = (Button)findViewById(R.id.coalBtn);
        coalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, coal.class));
            }
        });
    }

}
