package com.example.myvodafone.ui.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvodafone.ServicesAdapter;
import com.example.myvodafone.NotesAdapter;
import com.example.myvodafone.R;
import com.example.myvodafone.model.ServiceModel;

import java.util.ArrayList;

public class ServicesFragment extends Fragment {

    Spinner sServices;
    RecyclerView rCodes,rNotes;
    LinearLayout llCodes;
    ArrayList<ServiceModel> divertCodes,blackCodes,whiteCodes,mckCodes,eosCodes,conferenceCodes,callToneCodes,shokranCodes,sallefnyCodes,balanceTransferCodes,internationalCodes,roamingCodes;
    ArrayList<String> divertNotes,blackNotes,whiteNotes,mckNotes,eosNotes,conferenceNotes,callToneNotes,shokranNotes,sallefnyNotes,balanceTransferNotes,internationalNotes,roamingNotes;
    ArrayList<ServiceModel> serviceModelArrayList;
    ArrayAdapter serviceArrayAdapter;
    //private CodesViewModel codesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_services, container, false);
        /*codesViewModel = new ViewModelProvider(this).get(CodesViewModel.class);
        final TextView textView = root.findViewById(R.id.text_codes);
        codesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        sServices=root.findViewById(R.id.s_services);
        llCodes=root.findViewById(R.id.ll_codes);
        rCodes =root.findViewById(R.id.r_codes);
        rNotes =root.findViewById(R.id.r_notes);



        divertCodes =new ArrayList<>();
        divertCodes.add(new ServiceModel("777","free","IVR","manage everything"));
        divertCodes.add(new ServiceModel("*150#","2PT","ussed","know the last number called him"));
        divertCodes.add(new ServiceModel("*67*num#","free","in","busy"));
        divertCodes.add(new ServiceModel("*61*num#","free","in","no replay"));
        divertCodes.add(new ServiceModel("*62*num#","free","in","not reached"));
        divertCodes.add(new ServiceModel("*21*num#","free","in","unconditional"));
        divertCodes.add(new ServiceModel("##002#\n##004#","free","out","cancel"));

        divertNotes=new ArrayList<>();
        divertNotes.add("If A called B that divert to C then A will buy for calling B and B for calling C");
        divertNotes.add("It cost 5 flex/day flex CST");
        divertNotes.add("To cancel it, customer must use the cancellation code");



        blackCodes =new ArrayList<>();
        blackCodes.add(new ServiceModel("*7#","30PT","ussed","manage black list"));
        blackCodes.add(new ServiceModel("*7*2#","30PT","in","daily"));
        blackCodes.add(new ServiceModel("*7*1#","3LE","in","monthly"));
        blackCodes.add(new ServiceModel("*7*31#","free","out","cancel"));
        blackNotes=new ArrayList<>();
        blackNotes.add("CST can add till 200 numbers to list");
        blackNotes.add("CST can add or remove numbers from list or block messages");
        blackNotes.add("It cost 5 flex/day flex CST");
        blackNotes.add("To cancel it, customer must use the cancellation code");

        whiteCodes =new ArrayList<>();
        whiteCodes.add(new ServiceModel("*7#","30PT","ussed","manage white list"));
        whiteCodes.add(new ServiceModel("*45*2#","30PT","in","daily"));
        whiteCodes.add(new ServiceModel("*45*1#","5LE","in","monthly"));
        whiteCodes.add(new ServiceModel("*45*31#","free","out","cancel"));
        whiteNotes=new ArrayList<>();
        whiteNotes.add("CST can add till 200 numbers to list");
        whiteNotes.add("CST can add or remove numbers from list or block messages");
        whiteNotes.add("It cost 5 flex/day flex CST");
        whiteNotes.add("To cancel it, customer must use the cancellation code");

        mckCodes =new ArrayList<>();
        mckCodes.add(new ServiceModel("GF","20PT","ussed","daily"));
        mckCodes.add(new ServiceModel("*888*3#\n*010*3#","5LE","in","monthly"));

        mckCodes.add(new ServiceModel("*888*31#","free","out","cancel"));
        mckNotes=new ArrayList<>();
        mckNotes.add("CST can manage this service by ana VF app");
        mckNotes.add("It cost 14PT raya7 balak CST");
        mckNotes.add("It cost 5 flex/day flex CST");
        mckNotes.add("To cancel it, customer must use the cancellation code");



        eosCodes =new ArrayList<>();
        eosCodes.add(new ServiceModel("*9001#","1PT","in","per call"));
        eosCodes.add(new ServiceModel("*9009#","1LE for all\n2LE for flex CST","in","monthly"));
        eosCodes.add(new ServiceModel("*9009*0#","free","out","cancel monthly"));
        eosCodes.add(new ServiceModel("*9000#","free","out","cancel per call"));
        eosNotes=new ArrayList<>();
        eosNotes.add("It send message to CST after calls with current balance");
        eosNotes.add("To cancel it, customer must use the cancellation code");





        callToneCodes =new ArrayList<>();
        callToneCodes.add(new ServiceModel("5555","50PT","IVR","manage everything"));
        callToneCodes.add(new ServiceModel("*055*song#","20PT","in","daily"));
        callToneCodes.add(new ServiceModel("*055*song#","3LE","in","monthly"));
        callToneCodes.add(new ServiceModel("*055*0#","1PT","out","cancel"));
        callToneNotes=new ArrayList<>();
        callToneNotes.add("CST can subscribe in 5 songs at the same time");
        callToneNotes.add("CST can manage this service and get it as gift by ana VF app");
        callToneNotes.add("It cost 5 flex/day flex CST");
        callToneNotes.add("To cancel it, customer must use the cancellation code");




        shokranCodes =new ArrayList<>();
        shokranCodes.add(new ServiceModel("*505*num#","free first 2 times for On-NET\n10PT for all NETs","ussed","kalemny shokran"));
        shokranCodes.add(new ServiceModel("#num\nwhile calling","10PT","ussed","edfa3ly shokran"));
        shokranCodes.add(new ServiceModel("while calling","10PT","ussed","renaly shokran"));
        shokranCodes.add(new ServiceModel("while calling","60PT","ussed","3la elnota gave CST 3 MINs"));
        shokranCodes.add(new ServiceModel("*60*0#","free","ussed","know amounts due for shokran"));
        shokranNotes=new ArrayList<>();
        shokranNotes.add("It cost 5 flex/day flex CST");



        sallefnyCodes =new ArrayList<>();
        sallefnyCodes.add(new ServiceModel("*3#\n*868*3#","1LE","ussed","get 4LE as balance"));
        sallefnyCodes.add(new ServiceModel("*3*5#","free","ussed","manage sallefny"));
        sallefnyNotes=new ArrayList<>();
        sallefnyNotes.add("CST must has in his balance less than 5LE");
        sallefnyNotes.add("High CST can borrow till 32LE");
        sallefnyNotes.add("CST can do anything by sallefny balance except buying validation");
        sallefnyNotes.add("CST can not use ACP if he had borrowed balance");
        sallefnyNotes.add("It cost 5 flex/day flex CST");


        balanceTransferCodes =new ArrayList<>();
        balanceTransferCodes.add(new ServiceModel("868","20PT","IVR","manage everything"));
        balanceTransferCodes.add(new ServiceModel("*868*2*num*amount#","19PT","ussed","transfer balance"));
        balanceTransferNotes=new ArrayList<>();
        balanceTransferNotes.add("CST can transfer from 1LE to 50LE by time and max balance transfer is 80LE per month");
        balanceTransferNotes.add("If it less than 10LE it take 2% else it cost from 20PT to 29PT");
        balanceTransferNotes.add("It cost prepaid CST 18%");
        balanceTransferNotes.add("If CST want to unbarring this service must cal us 888");
        balanceTransferNotes.add("CST can use balance transfer by ana VF app for free");
        balanceTransferNotes.add("It cost 5 flex/day flex CST");


        conferenceCodes =new ArrayList<>();
        conferenceNotes=new ArrayList<>();
        conferenceNotes.add("It allow CST to add 5 people in the same call");
        conferenceNotes.add("It opened for postpaid and corporate only");
        conferenceNotes.add("It cost 5 flex/day flex CST");

        internationalCodes =new ArrayList<>();
        internationalCodes.add(new ServiceModel("5055","30PT","IVR","manage everything"));
        internationalCodes.add(new ServiceModel("*5055#","19PT","in","active"));
        internationalCodes.add(new ServiceModel("*101#","19PT","in","active for (red or yellow) postpaid CST by card"));
        internationalNotes=new ArrayList<>();
        internationalNotes.add("Tell customer the call cost in peak time(6AM to 12AM) and without peak time(12AM to 6AM)");
        internationalNotes.add("Recommend him world in your hands:\n  10LE per month.\n  1.5PT call opening fee");
        internationalNotes.add("I can't active it for (red or yellow) postpaid customer he can use it by only 2 ways He must pay 250LE as security deposit or by cards");

        roamingCodes =new ArrayList<>();
        roamingCodes.add(new ServiceModel("*236#","free","ussed","know if it active or not"));
        roamingCodes.add(new ServiceModel("*888*5#","free","in","active"));
        roamingCodes.add(new ServiceModel("*102#","19PT","in","active for (red or yellow) postpaid CST by card"));
        roamingCodes.add(new ServiceModel("*888*51#\n*202#","free","out","deactivate"));
        roamingNotes=new ArrayList<>();
        roamingNotes.add("Tell customer the preferred NET there");
        roamingNotes.add("The cost of everything like (MINs , SMS and MBs)");
        roamingNotes.add("Recommend weekly or monthly roaming bundles and MI bundles");
        roamingNotes.add("Ask him if there is transit to tell him everything about this country");
        roamingNotes.add("CST can only recharge his balance by cards or balance transfer");
        roamingNotes.add("I can't active it for (red or yellow) postpaid customer he can use it by only 2 ways He must pay 500LE as security deposit or by cards");






        serviceModelArrayList=new ArrayList<>();
        serviceModelArrayList.add(new ServiceModel("Call Divert",divertCodes,divertNotes));
        serviceModelArrayList.add(new ServiceModel("Black List",blackCodes,blackNotes));
        serviceModelArrayList.add(new ServiceModel("White List",whiteCodes,whiteNotes));
        serviceModelArrayList.add(new ServiceModel("MCK",mckCodes,mckNotes));
        serviceModelArrayList.add(new ServiceModel("EOS",eosCodes,eosNotes));
        serviceModelArrayList.add(new ServiceModel("Call Tone",callToneCodes,callToneNotes));
        serviceModelArrayList.add(new ServiceModel("International",internationalCodes,internationalNotes));
        serviceModelArrayList.add(new ServiceModel("Roaming",roamingCodes,roamingNotes));
        serviceModelArrayList.add(new ServiceModel("Shokran",shokranCodes,shokranNotes));
        serviceModelArrayList.add(new ServiceModel("Sallefny",sallefnyCodes,shokranNotes));
        serviceModelArrayList.add(new ServiceModel("Balance Transfer",balanceTransferCodes,balanceTransferNotes));
        serviceModelArrayList.add(new ServiceModel("Conference Call",conferenceCodes,conferenceNotes));




        ArrayList<String> serviceName =new ArrayList<>();
        for (ServiceModel s : serviceModelArrayList) {
            serviceName.add(s.name);
        }



        serviceArrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, serviceName);
        serviceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sServices.setAdapter(serviceArrayAdapter);
        sServices.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ServiceModel service=serviceModelArrayList.get(position);

                if (service.codes.size() == 0) {
                    llCodes.setVisibility(View.GONE);
                    rCodes.setVisibility(View.GONE);
                } else {
                    llCodes.setVisibility(View.VISIBLE);
                    rCodes.setVisibility(View.VISIBLE);
                    ServicesAdapter servicesAdapter =new ServicesAdapter();
                    servicesAdapter.setList(service.codes);
                    rCodes.setAdapter(servicesAdapter);
                    rCodes.setLayoutManager(new LinearLayoutManager(getActivity()));
                }








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