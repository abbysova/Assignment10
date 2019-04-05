package com.example.assignment10;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

public class PlanetVIewModel {

    public class PlanetViewModel extends AndroidViewModel {

        private PlanetRepository mRepository;
        private LiveData<Planet> mAllPlanets;

        public PlanetViewModel (Application application) {
            super(application);
            mRepository = new PlanetRepository(application);
            mAllPlanets = mRepository.getAllPlanets();
        }

        LiveData<Planet> getAllPlanets() {
            return mAllPlanets; }

        public void insert(Planet planet) {
            mRepository.insert(planet);
        }

    }
}
