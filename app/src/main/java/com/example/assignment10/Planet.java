package com.example.assignment10;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.arch.persistence.room.Entity;

@Entity(tableName = "planet_table")

public class Planet {

    @PrimaryKey(autoGenerate = true)
        @NonNull
        @ColumnInfo(name = "planet_id")
        public Long _id;

        @ColumnInfo(name = "planet_name")
        public String name;

        public Float gravity;
    public Planet(String name, Float gravity) {
        this._id = null;
        this.name = name;
        this.gravity = gravity;
    }

    public Long get_id() {
        return _id;
    }

    public Float getGravity() {
        return gravity;
    }

    public void setGravity(Float gravity) {
        this.gravity = gravity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", gravity=" + gravity +
                '}';
    }

}

