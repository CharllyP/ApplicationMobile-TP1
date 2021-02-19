package com.example.tp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] nomPays = {"France",
            "Allemagne",
            "Japon",
            "Afrique du Sud",
            "Espagne",
            "États-unis d'Amérique"};

    private String[] nomCapitale = {"Paris",
            "Dublin",
            "Tokyo",
            "Pretoria",
            "Madrid",
            "Washington DC"};

    private int[] images = { R.drawable.ic_flag_of_france_320px,
            R.drawable.ic_flag_of_germany_320px,
            R.drawable.ic_flag_of_japan_320px,
            R.drawable.ic_flag_of_south_africa_320px,
            R.drawable.ic_flag_of_spain_320px,
            R.drawable.ic_flag_of_the_united_states_320px};

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(nomPays[i]);
        viewHolder.itemDetail.setText(nomCapitale[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return nomPays.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            int position = getAdapterPosition();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    int position = getAdapterPosition();
                    /* Snackbar.make(v, "Click detected on chapter " + (position+1),
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                     */
                    //// Implementation with bundle
                    // Bundle bundle = new Bundle();
                    // bundle.putInt("numChapter", position);
                    // Navigation.findNavController(v).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
                    ListFragmentDirections.ActionFirstFragmentToSecondFragment action = ListFragmentDirections.actionFirstFragmentToSecondFragment(position);
                    action.setCountryId(position);
                    Navigation.findNavController(v).navigate(action);
                }
            });

        }
    }
}
