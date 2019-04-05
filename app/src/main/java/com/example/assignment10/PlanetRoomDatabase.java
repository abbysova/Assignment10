package com.example.assignment10;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

    @Database(entities = {Planet.class}, version = 1, exportSchema = false)
    public abstract class PlanetRoomDatabase extends RoomDatabase {

        public abstract PlanetDAO planetDao();

        private static volatile PlanetRoomDatabase INSTANCE;

        private static RoomDatabase.Callback sRoomDatabaseCallback =
                new RoomDatabase.Callback(){

                    @Override
                    public void onOpen (@NonNull SupportSQLiteDatabase db){
                        super.onOpen(db);
                        new PopulateDbAsync(INSTANCE).execute();
                    }
                };

        private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

            private final PlanetDAO mDao;

            PopulateDbAsync(PlanetRoomDatabase db) {
                mDao = db.planetDao();
            }

            @Override
            protected Void doInBackground(final Void... params) {
                //mDao.deleteAll();
                Planet planet;

                planet = new Planet("Earth",9.807f );
                mDao.insert(planet);
                Planet planet2 = new Planet("Jupiter",24.8f );
                mDao.insert(planet2);
                planet = new Planet("Mars",3.71f );
                mDao.insert(planet);
                planet = new Planet("Mercury",3.7f );
                mDao.insert(planet);
                planet = new Planet("Venus",8.87f );
                mDao.insert(planet);

                return null;
            }
        }

        static PlanetRoomDatabase getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (PlanetRoomDatabase.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                PlanetRoomDatabase.class, "word_database")
                                .addCallback(sRoomDatabaseCallback)
                                .build();
                    }
                }
            }
            return INSTANCE;
        }

    }