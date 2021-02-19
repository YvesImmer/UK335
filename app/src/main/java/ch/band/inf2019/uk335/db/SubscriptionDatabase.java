package ch.band.inf2019.uk335.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Categorie.class, Subscription.class},version = 1)
public abstract class SubscriptionDatabase extends RoomDatabase {
    private static SubscriptionDatabase instance;

    public abstract CategorieDao categorieDao();

    public abstract SubscriptionDao subscriptionDao();

    public static synchronized SubscriptionDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SubscriptionDatabase.class,
                    "subscribtion_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
