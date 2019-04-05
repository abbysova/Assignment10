package com.example.assignment10;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class PlanetListAdapter extends RecyclerView.Adapter<PlanetListAdapter.PlanetViewHolder>{

    class PlanetViewHolder extends RecyclerView.ViewHolder {
        private final TextView planetNameView;
        private final TextView planetGravityView;

        private PlanetViewHolder(View itemView) {
            super(itemView);
            planetNameView = itemView.findViewById(R.id.textViewPlanetName);
            planetGravityView = itemView.findViewById(R.id.textViewGravity);
        }
    }

    private final LayoutInflater mInflater;
    private List<Planet> mPlanets; 

    PlanetListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recycle, parent, false);
        return new PlanetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlanetViewHolder holder, int position) {
        if (mPlanets != null) {
            Planet current = mPlanets.get(position);
            holder.planetNameView.setText(current.getName());
            holder.planetGravityView.setText(current.getGravity().toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.planetNameView.setText("No Planets");
            holder.planetGravityView.setText("");
        }
    }

    void setWords(List<Planet> planets){
        mPlanets = planets;
        notifyDataSetChanged();
    }
    
    @Override
    public int getItemCount() {
        if (mPlanets != null)
            return mPlanets.size();
        else return 0;
    }


}