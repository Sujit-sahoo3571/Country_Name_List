package com.iamwithinyou.reterofitapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iamwithinyou.reterofitapp.R;
import com.iamwithinyou.reterofitapp.model.CountryModel;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    ArrayList<CountryModel> countryList ;

    public CountryAdapter(ArrayList<CountryModel> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                        parent,
                        false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder,
                                 int position) {
        holder.countryName.setText(countryList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return countryList == null ? 0: countryList.size() ;
    }

    public class CountryViewHolder extends  RecyclerView.ViewHolder{
        TextView countryName ;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.tv_countryname);
        }
    }
}
