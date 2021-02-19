package ch.band.inf2019.uk335.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface SubsciptionDao {

    @Insert
    void insert(Subscription subscription);

    @Update
    void updateSubscriptions(Subscription... subscriptions);

    @Delete
    void deleteSubscriptions(Subscription... subscriptions);

    @Query("SELECT * FROM subscription_table")
    LiveData<List<Subscription>> getAllSubscriptions();

    @Query("SELECT * FROM subscription_table WHERE categorieid=:categorieid")
    LiveData<List<Subscription>> findSubscriptionsForCategorie(final int categorieid);
}
