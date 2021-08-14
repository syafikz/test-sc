package com.example.wallpaper;

        import androidx.appcompat.app.AppCompatActivity;
        import android.app. WallpaperManager;
        import android.graphics.BitmapFactory;
        import android.os. Bundle;
        import android.view.View;
        import android.widget.Button;
        import java.util. Timer;
        import java.util. TimerTask;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btnChangeWallpaper;
    boolean running;
    int[] imagesArray = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3,
            R.drawable.a4};
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeWallpaper = (Button) findViewById(R.id.rview);
        btnChangeWallpaper.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (!running) {
            new Timer().schedule(new MyTimer(), 0, 2000);
            running = true;
        }
    }

    class MyTimer extends TimerTask {
        public void run() {
            try {
                WallpaperManager wallpaperManager=
                        WallpaperManager.getInstance(getBaseContext());
                if (i == 4)
                    i = 0;
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources()
                        , imagesArray[i]));
                i++;
            } catch (Exception e) {
            }
        }
    }
}