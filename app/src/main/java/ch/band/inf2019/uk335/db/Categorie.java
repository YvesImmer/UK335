package ch.band.inf2019.uk335.db;


import androidx.room.Entity;

import androidx.room.PrimaryKey;

@Entity(tableName = "categorie_table")
public class Categorie {
    @PrimaryKey(autoGenerate = true) public int id;

    public String title;

    public int color;

    public Categorie(String title,int color) {
        this.title = title;
        this.color = color;
    }


    //overridden so it is displayed in the category select spinner

    @Override
    public String toString(){
        return title;
    }
}
