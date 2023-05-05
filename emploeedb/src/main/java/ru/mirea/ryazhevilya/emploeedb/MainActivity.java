package ru.mirea.ryazhevilya.emploeedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        HeroDao heroDao = db.heroDao();
        Hero heroOne = new Hero();
        heroOne.id = 1;
        heroOne.name = "Твердыня";
        heroOne.description = "Очень сильный, летает и стреляет лазерами из глаз";

        Hero heroTwo = new Hero();
        heroTwo.id = 2;
        heroTwo.name = "Билли Бутчер";
        heroTwo.description = "Вообще-то не имеет сил, но просто слишком злой, чтобы умереть";

        heroDao.insert(heroOne);
        heroDao.insert(heroTwo);


    }
}