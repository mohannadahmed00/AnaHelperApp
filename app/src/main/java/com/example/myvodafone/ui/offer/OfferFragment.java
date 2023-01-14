package com.example.myvodafone.ui.offer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvodafone.NotesAdapter;
import com.example.myvodafone.R;
import com.example.myvodafone.ServicesAdapter;
import com.example.myvodafone.model.ServiceModel;

import java.util.ArrayList;

public class OfferFragment extends Fragment{

    Spinner sBundles;
    RecyclerView rCodes,rNotes;
    ArrayList<ServiceModel> of221Codes,of365Codes,cashBackCodes,maredCodes;
    ArrayList<String> of221Notes,of365Notes,cashBackNotes,maredNotes;
    ArrayList<ServiceModel> serviceModelArrayList;
    ArrayAdapter serviceArrayAdapter;


    private OfferViewModel offerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_services, container, false);
        /*codesViewModel = new ViewModelProvider(this).get(CodesViewModel.class);
        final TextView textView = root.findViewById(R.id.text_codes);
        codesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });giraffe*/



        sBundles=root.findViewById(R.id.s_services);
        rCodes =root.findViewById(R.id.r_codes);
        rNotes =root.findViewById(R.id.r_notes);



        of221Codes =new ArrayList<>();
        of221Codes.add(new ServiceModel("*200#","free","ussed","know MI offers (change every day after 12 midnight)"));
        of221Notes=new ArrayList<>();
        of221Notes.add("It is double the bundle for 1 month or a discount on the bundle for 2 months");
        of221Notes.add("The customer cannot do two offers together");
        of221Notes.add("If the customer requests the offer code twice, he will lose the offer");
        of221Notes.add("If the customer requests Offer-X Code and he is already on Offer-Y, he will lose Offer-Y and activate Offer-X");
        of221Notes.add("The offers come to the CST according to his consumption");



        of365Codes =new ArrayList<>();
        of365Codes.add(new ServiceModel("*365#","free","ussed","know the 365 offers"));
        of365Codes.add(new ServiceModel("*365*num#","free","ussed","send 365 offer to another\n(The cost will be deducted from the sender)"));
        of365Codes.add(new ServiceModel("*365*0#","free","ussed","follow 365 offer consumption"));

        of365Notes=new ArrayList<>();
        of365Notes.add("They are daily or weekly offers sent to the customer through SMS");
        of365Notes.add("There are 5 offers that can be MINs, SMS or MBs, and for Flex CST 10 different offers are available (the cost is from flexs)");
        of365Notes.add("The offer can't be canceled and will continue until the end of the offer");
        of365Notes.add("The remaining offers may be rolled over if the offer is renewed before the offer ends");




        cashBackCodes =new ArrayList<>();
        cashBackCodes.add(new ServiceModel("*201#","free","ussed","get the offer"));

        cashBackNotes=new ArrayList<>();
        cashBackNotes.add("The SIM must be at SIM1");
        cashBackNotes.add("Any CST who buys Samsung phone, his money will be returned to him as units that he can use for MINs, SMS or MBs");
        cashBackNotes.add("Starting from the second month, it is necessary to have MI or Flex bundle, according to the type and price of each device (Es2alny)");
        cashBackNotes.add("The offer is valid for 12 months");
        cashBackNotes.add("The CST can't send units from the offer to another person and can't be rolled over");



        maredCodes =new ArrayList<>();
        maredCodes.add(new ServiceModel("*858*1*num#","free","ussed","recharge Mared card as Flexs"));
        maredCodes.add(new ServiceModel("*858*2*num#","free","ussed","recharge Mared card as MINs"));
        maredCodes.add(new ServiceModel("*858*3*num#","free","ussed","recharge Mared card as MBs"));
        maredCodes.add(new ServiceModel("*858*1#","free","ussed","use normal card as mared"));
        maredCodes.add(new ServiceModel("*858*2#","free","ussed","use Mared card"));
        maredCodes.add(new ServiceModel("*85#","free","ussed","turn balance into mared"));
        maredCodes.add(new ServiceModel("*87#","free","ussed","turn Flexs into MINs\nto turn MINs into Flexs"));

        maredNotes=new ArrayList<>();
        maredNotes.add("5LE(3.5 balance) Mared gave CST 160 units");
        maredNotes.add("7LE(5 balance) Mared gave CST 300 units");
        maredNotes.add("10LE(7 balance) Mared gave CST 450 units");

        maredNotes.add("If the customer recharges two cards, the remainder of Card-X card will be rolled over to Card-Y, and if he recharged the Card-Z, he will lose the first two cards and starts over");
        maredNotes.add("If the customer recharges two cards, the smaller card will be consumed first");
        maredNotes.add("The balance from the Mared card can be paid stamp tax or Sallefny");


        serviceModelArrayList=new ArrayList<>();
        serviceModelArrayList.add(new ServiceModel("Mared Card",maredCodes,maredNotes));
        serviceModelArrayList.add(new ServiceModel("MI Offer",of221Codes,of221Notes));
        serviceModelArrayList.add(new ServiceModel("365 Offer",of365Codes,of365Notes));
        serviceModelArrayList.add(new ServiceModel("Cash Back",cashBackCodes,cashBackNotes));

        ArrayList<String> serviceName =new ArrayList<>();
        for (ServiceModel s : serviceModelArrayList) {
            serviceName.add(s.name);
        }



        serviceArrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, serviceName);
        serviceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBundles.setAdapter(serviceArrayAdapter);
        sBundles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ServiceModel service=serviceModelArrayList.get(position);



                ServicesAdapter servicesAdapter =new ServicesAdapter();
                servicesAdapter.setList(service.codes);
                rCodes.setAdapter(servicesAdapter);
                rCodes.setLayoutManager(new LinearLayoutManager(getActivity()));




                NotesAdapter notesAdapter=new NotesAdapter();
                notesAdapter.setList(service.notes);
                rNotes.setAdapter(notesAdapter);
                rNotes.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return root;
    }



}