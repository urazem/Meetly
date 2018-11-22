package com.nomercy.meetly;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter <PlaceAdapter.PlaceViewHolder>{
    private List<Place> placesList;

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        public TextView placeName;
        public TextView placeDescription;
        public ImageView placeImage;

        public PlaceViewHolder(View view) {
            super(view);
            placeName = (TextView) view.findViewById(R.id.placeName);
            placeDescription = (TextView) view.findViewById(R.id.placeDescription);
            placeImage = (ImageView) view.findViewById(R.id.placeImage);
        }
    }


    public PlaceAdapter(List<Place> placesList) {
        this.placesList = placesList;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_item, parent, false);

        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        Place place = placesList.get(position);
        holder.placeName.setText(place.getPlaceName());
        holder.placeDescription.setText(place.getPlaceDescription());
       // holder.placeImage.setText(place.getPlaceImage());
    }


    @Override
    public int getItemCount() {
        return placesList.size();
    }
}

