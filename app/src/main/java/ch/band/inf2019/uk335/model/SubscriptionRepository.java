package ch.band.inf2019.uk335.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;

import ch.band.inf2019.uk335.db.Categorie;
import ch.band.inf2019.uk335.db.CategorieDao;
import ch.band.inf2019.uk335.db.Subscription;
import ch.band.inf2019.uk335.db.SubscriptionDao;
import ch.band.inf2019.uk335.db.SubscriptionDatabase;

public class SubscriptionRepository {
    private final Executor executor;
    private CategorieDao categorieDao;
    private SubscriptionDao subscriptionDao;
    private LiveData<List<Categorie>> allCategories;
    private LiveData<List<Subscription>> allSubscriptions;

    public SubscriptionRepository(Application application, Executor executor){
        this.executor = executor;
        SubscriptionDatabase database = SubscriptionDatabase.getInstance(application);
        categorieDao = database.categorieDao();
        subscriptionDao = database.subscriptionDao();
        allCategories = categorieDao.getAllCategories();
        allSubscriptions = subscriptionDao.getAllSubscriptions();

    }

    /**
     * Inserts a Subscription in to the Database
     * @param subscriptions Subscriptions to be inserted in to the Database
     */
    public void insert(Subscription... subscriptions){
        executor.execute(() -> subscriptionDao.insert(subscriptions));
    }

    /**
     * Inserts a Categorie in to the Database
     * @param categories Categories to to be inserted in to the Database
     */
    public void insert(Categorie... categories){
        executor.execute(() -> categorieDao.insert(categories));
    }
    public void update(Subscription... subscription){
        executor.execute(() -> subscriptionDao.updateSubscriptions(subscription));
    }
    public void update(Categorie... categories){
        executor.execute(() -> categorieDao.updateCategories(categories));
    }
    public void delete(Subscription... subscriptions){
        executor.execute(() -> subscriptionDao.deleteSubscriptions(subscriptions));
    }
    public void delete(Categorie... categories){
        executor.execute(() -> categorieDao.deleteCategories(categories));
    }

    public LiveData<List<Categorie>> getAllCategories() {
        return allCategories;
    }

    public LiveData<List<Subscription>> getAllSubscriptions() {
        return allSubscriptions;
    }
}
