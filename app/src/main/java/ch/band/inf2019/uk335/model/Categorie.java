package ch.band.inf2019.uk335.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "categorie_table")
public class Categorie {
    @PrimaryKey(autoGenerate = true) public long id;

    public String title;

    public Categorie(String title) {
        this.title = title;
    }
}
