package com.example.mplproducthelperv20;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.github.javiersantos.appupdater.AppUpdater;
        import com.github.javiersantos.appupdater.enums.Display;
        import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button coalButton = (Button)findViewById(R.id.coalBtn);
        coalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, coal.class));
            }
        });
    }

}
