package com.example.tp1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import static fr.uavignon.ceri.tp1.data.Country.countries;

public class DetailFragment extends Fragment {

    TextView pays, capitale, langue, monnaie, population, superficie;
    ImageView drapeau;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pays = view.findViewById(R.id.nomPays);
        drapeau = view.findViewById(R.id.drapeauPays);
        Context ctxt = drapeau.getContext();
        capitale = view.findViewById(R.id.capitalePays);
        langue = view.findViewById(R.id.languePays);
        monnaie = view.findViewById(R.id.monnaiePays);
        population = view.findViewById(R.id.popPays);
        superficie = view.findViewById(R.id.superfPays);

        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());

        int paysID = args.getCountryId();
        pays.setText(countries[paysID].getName());
        drapeau.setImageDrawable(ctxt.getResources().getDrawable(ctxt.getResources().getIdentifier (countries[paysID].getImgUri(), null , ctxt.getPackageName())));
        capitale.setText(countries[paysID].getCapital());
        langue.setText(countries[paysID].getLanguage());
        monnaie.setText(countries[paysID].getCurrency());
        population.setText(String.valueOf(countries[paysID].getPopulation()));
        superficie.setText(String.valueOf(countries[paysID].getArea())+" km2");

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetailFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}