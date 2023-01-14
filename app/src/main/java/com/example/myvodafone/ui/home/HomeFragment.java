package com.example.myvodafone.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvodafone.MiBundlesAdapter;
import com.example.myvodafone.NotesAdapter;
import com.example.myvodafone.R;
import com.example.myvodafone.ServicesAdapter;
import com.example.myvodafone.model.ServiceModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel interNETViewModel;
    Spinner sBundles;
    ArrayAdapter  serviceArrayAdapter;
    ArrayList<ServiceModel> fourteenPtNewCodes, fourteenPtRayahCodes, belthanyaCodes, hakawyNaharCodes, hakawyYoumCodes, hakawyFourteenCodes, flexDailyCodes, flexWeeklyCodes, flex2017Codes, flex2019Codes, flexFamilyCodes, flexAddOnCodes, harakatDailyCodes, harakatMonthlyCodes, inDailyCodes, inMonthlyCodes;
    ArrayList<String> fourteenPtNewNotes, fourteenPtRayahNotes, belthanyaNotes, hakawyNaharNotes, hakawyYoumNotes, hakawyFourteenNotes, flexNotes, flexFamilyNotes, flexAddOnNotes, harakatDailyNotes, harakatMonthlyNotes, flexWDNotes, flex2017Notes, inDailyNotes, inMonthlyNotes;
    ArrayList<ServiceModel> serviceModelArrayList;
    LinearLayout llCodes;
    RecyclerView rCodes, rNotes;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_services, container, false);
        /*interNETViewModel = new ViewModelProvider(this).get(InterNETViewModel.class);
        final TextView textView = root.findViewById(R.id.text_interNET);
        interNETViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/


        sBundles = root.findViewById(R.id.s_services);

        llCodes=root.findViewById(R.id.ll_codes);
        rCodes = root.findViewById(R.id.r_codes);
        rNotes = root.findViewById(R.id.r_notes);



        fourteenPtNewCodes = new ArrayList<>();
        fourteenPtNewCodes.add(new ServiceModel("858\n*858*num#", "free", "ussed", "recharge normal card"));
        fourteenPtNewCodes.add(new ServiceModel("*60#", "19PT", "ussed", "follow consumption"));
        fourteenPtNewCodes.add(new ServiceModel("*880#", "1LE : 10LE", "ussed", "choose plan"));
        fourteenPtNewCodes.add(new ServiceModel("868", "20PT", "ussed", "know or transfer balance"));




        fourteenPtNewNotes = new ArrayList<>();
        fourteenPtNewNotes.add("MINs for any NET = 14PT ");
        fourteenPtNewNotes.add("SMS for ant NET = 30PT");
        //after mi payment way
        fourteenPtNewNotes.add("If CST hasn't MI bundle, he will get first 10MBs by 1.25LE then each 1MB by 50PT");
        fourteenPtNewNotes.add("If CST hasn't MI bundle and his balance is less than 1.25LE, he will get first 5MBs by 75PT then each 3MB by 75PT");
        fourteenPtNewNotes.add("If CST finished his MI bundle he will get 15MBs by 1LE for 30 times then 1MB by 10PT");


        fourteenPtRayahCodes = new ArrayList<>();
        fourteenPtRayahNotes = new ArrayList<>();
        fourteenPtRayahNotes.add("Default plan for all CST");
        fourteenPtRayahNotes.add("Everything = 14PT");


        belthanyaCodes = new ArrayList<>();
        belthanyaNotes = new ArrayList<>();
        belthanyaNotes.add("SEC for any NET (12am to 6pm) = 3 Milim");
        belthanyaNotes.add("SEC for any NET (6pm to 12am) = 4 Milim");
        belthanyaNotes.add("SEC for International = 30PT (i won't recommend him world in your hands)");
        belthanyaNotes.add("SMS for any NET = 30PT");


        hakawyNaharCodes = new ArrayList<>();
        hakawyNaharCodes.add(new ServiceModel("GF", "1.5LE", "ussed", "gave 130 on NET MINs from 12am to 6pm"));
        hakawyNaharNotes = new ArrayList<>();
        hakawyNaharNotes.add("FUR = 11PT to open call + 19PT for each MIN");


        hakawyYoumCodes = new ArrayList<>();
        hakawyYoumCodes.add(new ServiceModel("GF", "2.5LE", "ussed", "gave 180 on NET MINs from 12am to 12am"));
        hakawyYoumNotes = new ArrayList<>();
        hakawyYoumNotes.add("FUR = 11PT to open call + 19PT for each MIN");


        hakawyFourteenCodes = new ArrayList<>();
        hakawyFourteenCodes.add(new ServiceModel("GF", "1LE", "ussed", "gave 100 on NET MINs from 9am to 3pm or 3pm to 9pm or 9pm to 9am"));
        hakawyFourteenNotes = new ArrayList<>();
        hakawyFourteenNotes.add("FUR = 16PT to open call + 14PT for each MIN");


        flexNotes = new ArrayList<>();
        flexNotes.add("FUR = 19PT for MIN and 30PT for SMS");
        flexNotes.add("On-NET MIN or 2MB social or 1MB others or SMS = 1 flex");
        flexNotes.add("Any service or X-NET MIN = 5 flex");
        flexNotes.add("After the whatsapp bundle is finished its speed decreases to 64KB ");
        flexNotes.add("If CST had balance the bundle will renew in 28th day");
        flexNotes.add("Cost of choosing flex plans is from 1LE to 10LE");
        flexNotes.add("CST can receive only 250 flex per month");
        flexNotes.add("CST can use APC but must be there is no sallefny balance");
        flexNotes.add("CST must pay ACP in 7 days and otherwise Flexs will be freezed till CST pay ACP");


        flex2017Notes = new ArrayList<>();
        flex2017Notes.add("FUR = 19PT for MIN and 30PT for SMS");
        flex2017Notes.add("On-NET MIN or 1MB or On-NET SMS = 1 flex");
        flex2017Notes.add("Any service or X-NET MIN or X-NET SMS = 5 flex");
        flex2017Notes.add("After the whatsapp bundle is finished its speed decreases to 64KB ");
        flex2017Notes.add("If CST had balance the bundle will renew in 28th day");
        flex2017Notes.add("Cost of choosing flex plans is from 1LE to 10LE");
        flex2017Notes.add("CST can receive only 250 flex per month");
        flex2017Notes.add("CST can use APC but must be there is no salefny balance");
        flex2017Notes.add("CST must pay ACP in 7 days and otherwise flexs will be freezed till CST pay ACP");

        flexWDNotes = new ArrayList<>();
        flexWDNotes.add("FUR = 19PT for MIN and 30PT for SMS");
        flexWDNotes.add("On-NET MIN or 1MB or On-NET SMS = 1 flex");
        flexWDNotes.add("Any service or X-NET MIN or X-NET SMS = 5 flex");
        flexWDNotes.add("After the whatsapp bundle is finished its speed decreases to 64KB");
        flexWDNotes.add("Cost of choosing flex plans is from 1LE to 10LE");
        flexWDNotes.add("CST can receive only 250 flex per month");


        flexDailyCodes = new ArrayList<>();
        flexDailyCodes.add(new ServiceModel("GF", "1.5LE", "ussed", "gave CST 30 flex for 1 day"));
        flexDailyCodes.add(new ServiceModel("GF", "3LE", "ussed", "gave CST 100 flex for 1 day"));
        flexDailyCodes.add(new ServiceModel("*60#", "free first 3 times then 19PT", "ussed", "follow consumption of flex"));
        flexDailyCodes.add(new ServiceModel("*225#", "free", "ussed", "renew the bundle"));
        flexDailyCodes.add(new ServiceModel("*880*num*flex#", "50PT for each 50 flex", "ussed", "transfer flexs (50 flex and its multiples with maximum 250 flex per month are valid for 7 days or main bundle expire date)"));
        flexDailyCodes.add(new ServiceModel("*5#", "free", "ussed", "know coins (can use coins in offers with KFC - Hardees - Pizza hut - etc.)"));


        flexDailyCodes.add(new ServiceModel("*880*33#", "free", "in", "active auto renewable"));
        flexDailyCodes.add(new ServiceModel("*880*23#", "free", "in", "active MI limit (5 and its multiples)"));
        flexDailyCodes.add(new ServiceModel("*880*28#", "free", "in", "active X-NET limit (5 and its multiples)"));
        flexDailyCodes.add(new ServiceModel("*5000#", "5 flex per SEC", "in", "active international flexs"));

        flexDailyCodes.add(new ServiceModel("*880*34#", "free", "out", "deactivate auto renewable"));
        flexDailyCodes.add(new ServiceModel("*880*24#", "free", "out", "deactivate MI limit (5 and its multiples)"));
        flexDailyCodes.add(new ServiceModel("*880*29#", "free", "out", "deactivate X-NET limit (5 and its multiples)"));


        flexWeeklyCodes = new ArrayList<>();
        flexWeeklyCodes.add(new ServiceModel("GF", "2.5LE", "ussed", "gave CST 45 flex for 1 day"));
        flexWeeklyCodes.add(new ServiceModel("GF", "5LE", "ussed", "gave CST 100 flex for 3 days"));
        flexWeeklyCodes.add(new ServiceModel("GF", "10LE", "ussed", "gave CST 300 flex for 7 days"));
        flexWeeklyCodes.add(new ServiceModel("*60#", "free first 3 times then 19PT", "ussed", "follow consumption of flex"));
        flexWeeklyCodes.add(new ServiceModel("*225#", "free", "ussed", "renew the bundle"));
        flexWeeklyCodes.add(new ServiceModel("*880*num*flex#", "50PT for each 50 flex", "ussed", "transfer flexs (50 flex and its multiples with maximum 250 flex per month are valid for 7 days or main bundle expire date)"));
        flexWeeklyCodes.add(new ServiceModel("*5#", "free", "ussed", "know coins (can use coins in offers with KFC - Hardees - Pizza hut - etc.)"));


        flexWeeklyCodes.add(new ServiceModel("*880*33#", "free", "in", "active auto renewable"));
        flexWeeklyCodes.add(new ServiceModel("*880*23#", "free", "in", "active MI limit (5 and its multiples)"));
        flexWeeklyCodes.add(new ServiceModel("*880*28#", "free", "in", "active X-NET limit (5 and its multiples)"));
        flexWeeklyCodes.add(new ServiceModel("*5000#", "5 flex per SEC", "in", "active international flexs"));

        flexWeeklyCodes.add(new ServiceModel("*880*34#", "free", "out", "deactivate auto renewable"));
        flexWeeklyCodes.add(new ServiceModel("*880*24#", "free", "out", "deactivate MI limit (5 and its multiples)"));
        flexWeeklyCodes.add(new ServiceModel("*880*29#", "free", "out", "deactivate X-NET limit (5 and its multiples)"));


        flex2017Codes = new ArrayList<>();
        flex2017Codes.add(new ServiceModel("GF", "15LE", "ussed", "gave 400 flex + 200MB for whatsapp"));
        flex2017Codes.add(new ServiceModel("GF", "20LE", "ussed", "gave 550 flex + 200MB for whatsapp"));
        flex2017Codes.add(new ServiceModel("GF", "30LE", "ussed", "gave 1100 flex + 200MB for whatsapp"));
        flex2017Codes.add(new ServiceModel("GF", "35LE", "ussed", "gave 1300 flex + 200MB for whatsapp"));
        flex2017Codes.add(new ServiceModel("GF", "50LE", "ussed", "gave 2200 flex + 200MB for whatsapp"));
        flex2017Codes.add(new ServiceModel("GF", "55LE", "ussed", "gave 2400 flex + 200MB for whatsapp"));
        flex2017Codes.add(new ServiceModel("GF", "70LE", "ussed", "gave 3300 flex + 200MB for whatsapp"));
        flex2017Codes.add(new ServiceModel("GF", "90LE", "ussed", "gave 4400 flex + 200MB for whatsapp"));
        flex2017Codes.add(new ServiceModel("*225#", "free", "ussed", "renew the bundle (or ACP if CST doesn't have balance)"));
        flex2017Codes.add(new ServiceModel("*5#", "free", "ussed", "know coins (can use coins in offers with KFC - Hardees - Pizza hut - etc.)"));
        flex2017Codes.add(new ServiceModel("*60*10#", "free", "ussed", "know ACP"));
        flex2017Codes.add(new ServiceModel("*60#", "free first 3 times then 19PT", "ussed", "follow consumption of flex"));
        flex2017Codes.add(new ServiceModel("*880*num*flex#", "50PT for each 50 flex", "ussed", "transfer flexs (50 flex and its multiples with maximum 250 flex per month are valid for 7 days or main bundle expire date)"));


        flex2017Codes.add(new ServiceModel("*880*33#", "free", "in", "active auto renewable"));
        flex2017Codes.add(new ServiceModel("*880*130#", "free", "in", "active rollover and make it 28 day (flexs will be rolled over if CST renew on the time)"));
        flex2017Codes.add(new ServiceModel("*880*23#", "free", "in", "active MI limit (5 and its multiples)"));
        flex2017Codes.add(new ServiceModel("*880*28#", "free", "in", "active X-NET limit (5 and its multiples)"));
        flex2017Codes.add(new ServiceModel("*5000#", "5 flex per SEC", "in", "active international flexs"));


        flex2017Codes.add(new ServiceModel("*880*34#", "free", "out", "deactivate auto renewable"));
        flex2017Codes.add(new ServiceModel("*880*133#", "free", "out", "deactivate rollover and make it 30 day (but it is submitted in the next month)"));
        flex2017Codes.add(new ServiceModel("*880*24#", "free", "out", "deactivate MI limit (5 and its multiples)"));
        flex2017Codes.add(new ServiceModel("*880*29#", "free", "out", "deactivate X-NET limit (5 and its multiples)"));


        flex2019Codes = new ArrayList<>();
        flex2019Codes.add(new ServiceModel("GF", "80LE", "ussed", "gave 3800 flex + 200MB for whatsapp"));
        flex2019Codes.add(new ServiceModel("GF", "100LE", "ussed", "gave 5100 flex + 200MB for whatsapp"));
        flex2019Codes.add(new ServiceModel("*60#", "free first 3 times then 19PT", "ussed", "follow consumption of flex"));
        flex2019Codes.add(new ServiceModel("*225#", "free", "ussed", "renew the bundle (or ACP if CST doesn't have balance)"));
        flex2019Codes.add(new ServiceModel("*880*num*flex#", "50PT for each 50 flex", "ussed", "transfer flexs (50 flex and its multiples with maximum 250 flex per month are valid for 7 days or main bundle expire date)"));
        flex2019Codes.add(new ServiceModel("*60*10#", "free", "ussed", "know ACP"));
        flex2019Codes.add(new ServiceModel("*5#", "free", "ussed", "know coins (can use coins in offers with KFC - Hardees - Pizza hut - etc.)"));


        flex2019Codes.add(new ServiceModel("*025#", "25LE", "in", "gave 600 flex + 200MB for whatsapp"));
        flex2019Codes.add(new ServiceModel("*035#", "35LE", "in", "gave 1400 flex + 200MB for whatsapp"));
        flex2019Codes.add(new ServiceModel("*060#", "60LE", "in", "gave 2700 flex + 200MB for whatsapp"));
        flex2019Codes.add(new ServiceModel("*880*52#", "free", "in", "active free whatsapp"));
        flex2019Codes.add(new ServiceModel("*880*33#", "free", "in", "active auto renewable"));
        flex2019Codes.add(new ServiceModel("*880*130#", "free", "in", "active rollover and make it 28 day (flexs will be rolled over if CST renew on the time)"));
        flex2019Codes.add(new ServiceModel("*880*23#", "free", "in", "active MI limit (5 and its multiples)"));
        flex2019Codes.add(new ServiceModel("*880*28#", "free", "in", "active X-NET limit (5 and its multiples)"));
        flex2019Codes.add(new ServiceModel("*5000#", "5 flex per SEC", "in", "active international flexs"));


        flex2019Codes.add(new ServiceModel("*880*34#", "free", "out", "deactivate auto renewable"));
        flex2019Codes.add(new ServiceModel("*880*133#", "free", "out", "deactivate rollover and make it 30 day (but it is submitted in the next month)"));
        flex2019Codes.add(new ServiceModel("*880*24#", "free", "out", "deactivate MI limit (5 and its multiples)"));
        flex2019Codes.add(new ServiceModel("*880*29#", "free", "out", "deactivate X-NET limit (5 and its multiples)"));
        flex2019Codes.add(new ServiceModel("*880*51#", "free", "out", "deactivate free whatsapp"));


        flexFamilyCodes = new ArrayList<>();

        flexFamilyCodes.add(new ServiceModel("*909#", "free", "ussed", "manage the members"));
        flexFamilyCodes.add(new ServiceModel("*60#", "free first 3 times then 19PT", "ussed", "follow consumption of flex"));
        flexFamilyCodes.add(new ServiceModel("*080#", "80LE", "in", "gave 3800 flex to owner + 1 member"));
        flexFamilyCodes.add(new ServiceModel("*0100#", "100LE", "in", "gave 5100 flex to owner + 1 member"));
        flexFamilyCodes.add(new ServiceModel("*0150#", "150LE", "in", "gave 8000 flex to owner + 2 member"));
        flexFamilyCodes.add(new ServiceModel("*02000#", "200LE", "in", "gave 12000 flex to owner + 2 member"));

        flexFamilyNotes = new ArrayList<>();
        flexFamilyNotes.add("FUR = 19PT for MIN and 30PT for SMS");
        flexFamilyNotes.add("Owner can add prepaid members and share his bundle with them 10% or 20% or 40%");
        flexFamilyNotes.add("Owner and members get 250 MINs valid for month to contact between them");
        flexFamilyNotes.add("If owner change his plan each member will get message with *880# to choose plan");
        flexFamilyNotes.add("ACP isn't available to flex family");


        flexAddOnCodes = new ArrayList<>();
        flexAddOnCodes.add(new ServiceModel("*880*03#", "3LE", "in", "gave 60 flex"));
        flexAddOnCodes.add(new ServiceModel("*880*05#", "5LE", "in", "gave 120 flex"));
        flexAddOnCodes.add(new ServiceModel("*880*010#", "10LE", "in", "gave 300 flex"));
        flexAddOnNotes = new ArrayList<>();
        flexAddOnNotes.add("Add-on 10LE is not available to CST of flex 15");
        flexAddOnNotes.add("CST can buy unlimited add-ons but they will not be rolled over");


        harakatDailyCodes = new ArrayList<>();
        harakatDailyCodes.add(new ServiceModel("*888#", "free", "ussed", "renew the bundle"));
        harakatDailyCodes.add(new ServiceModel("*888*1#", "1LE", "in", "gave 30 MINs + 55 MINs first 3 months"));
        harakatDailyCodes.add(new ServiceModel("*888*2#", "2LE", "in", "gave 60 MINs + 90 MINs + 25 MB first 3 months and 10 MB"));
        harakatDailyCodes.add(new ServiceModel("*888*0#", "14PT", "in", "active X-NET"));
        harakatDailyNotes = new ArrayList<>();
        harakatDailyNotes.add("FUR = 14PT for everything");
        harakatDailyNotes.add("X-NET MINs = 5 MINs On-NET");
        harakatDailyNotes.add("Validity of bundle is 24 hours");

        harakatMonthlyCodes = new ArrayList<>();
        harakatMonthlyCodes.add(new ServiceModel("GF", "15LE", "ussed", "gave 500 MINs"));
        harakatMonthlyCodes.add(new ServiceModel("GF", "25LE", "ussed", "gave 600 MINs + 300 MB"));
        harakatMonthlyCodes.add(new ServiceModel("*888*0#", "2.5LE for 15LE bundle\n14PT for 25LE bundle", "in", "active X-NET"));
        harakatMonthlyNotes = new ArrayList<>();
        harakatMonthlyNotes.add("FUR = 14PT for everything");
        harakatMonthlyNotes.add("X-NET MINs = 5 MINs On-NET");


        inDailyCodes = new ArrayList<>();
        inDailyCodes.add(new ServiceModel("*20#", "free", "ussed", "manage his IN bundle"));
        inDailyCodes.add(new ServiceModel("*53#", "1LE", "in", "gave 40 MINs any NET + 20 MBs"));
        inDailyCodes.add(new ServiceModel("*56#", "1.5LE", "in", "gave 60 MINs any NET + 20 MBs"));
        inDailyCodes.add(new ServiceModel("*0#", "5LE", "in", "Joker: gave 125 MINs any NET + 250 MBs + 500 MBs (social & Mazika)"));
        inDailyNotes = new ArrayList<>();
        inDailyNotes.add("FUR = 14PT for everything");
        inDailyNotes.add("Validity of bundle is 24 hours");

        inMonthlyCodes = new ArrayList<>();
        inMonthlyCodes.add(new ServiceModel("*20#", "free", "ussed", "manage his IN bundle"));
        inMonthlyCodes.add(new ServiceModel("GF", "25LE", "in", "gave 50 MINs any NET + 500 MBs + 2 free jokers"));
        inMonthlyCodes.add(new ServiceModel("GF", "40LE", "in", "gave 150 MINs any NET + 1000 MBs + 4 free jokers"));
        inMonthlyCodes.add(new ServiceModel("GF", "65LE", "in", "gave 350 MINs any NET + 2500 MBs + 4 free jokers"));
        inMonthlyCodes.add(new ServiceModel("GF", "85LE", "in", "gave 450 MINs any NET + 4000 MBs + 6 free jokers"));
        inMonthlyCodes.add(new ServiceModel("*0#", "5LE", "in", "Joker: gave 125 MINs any NET + 250 MBs + 500 MBs (social & Mazika)"));
        inMonthlyNotes = new ArrayList<>();
        inMonthlyNotes.add("FUR = 14PT for everything");


        serviceModelArrayList = new ArrayList<>();
        serviceModelArrayList.add(new ServiceModel("Flex 2019", flex2019Codes, flexNotes));
        serviceModelArrayList.add(new ServiceModel("Flex Family", flexFamilyCodes, flexFamilyNotes));
        serviceModelArrayList.add(new ServiceModel("Flex Add-On", flexAddOnCodes, flexAddOnNotes));
        serviceModelArrayList.add(new ServiceModel("14PT New (GF)", fourteenPtNewCodes, fourteenPtNewNotes));
        serviceModelArrayList.add(new ServiceModel("14PT Raya7 Balak", fourteenPtNewCodes, fourteenPtRayahNotes));
        serviceModelArrayList.add(new ServiceModel("Belthanya", fourteenPtNewCodes, belthanyaNotes));
        serviceModelArrayList.add(new ServiceModel("Hakawy Tool Elnahar (GF)", hakawyNaharCodes, hakawyNaharNotes));
        serviceModelArrayList.add(new ServiceModel("Hakawy Tool Elyoum (GF)", hakawyYoumCodes, hakawyYoumNotes));
        serviceModelArrayList.add(new ServiceModel("Hakawy 14PT (GF)", hakawyFourteenCodes, hakawyFourteenNotes));
        serviceModelArrayList.add(new ServiceModel("Flex Daily (GF)", flexDailyCodes, flexWDNotes));
        serviceModelArrayList.add(new ServiceModel("Flex Weekly (GF)", flexWeeklyCodes, flexWDNotes));
        serviceModelArrayList.add(new ServiceModel("Flex 2017 (GF)", flex2017Codes, flex2017Notes));
        serviceModelArrayList.add(new ServiceModel("Harakat Daily", harakatDailyCodes, harakatDailyNotes));
        serviceModelArrayList.add(new ServiceModel("Harakat Monthly (GF)", harakatMonthlyCodes, harakatMonthlyNotes));
        serviceModelArrayList.add(new ServiceModel("IN Daily", inDailyCodes, inDailyNotes));
        serviceModelArrayList.add(new ServiceModel("IN Monthly (GF)", inMonthlyCodes, inMonthlyNotes));


        ArrayList<String> serviceName = new ArrayList<>();
        for (ServiceModel s : serviceModelArrayList) {
            serviceName.add(s.name);
        }


        serviceArrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, serviceName);
        serviceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBundles.setAdapter(serviceArrayAdapter);
        sBundles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ServiceModel service = serviceModelArrayList.get(position);

                if (service.codes.size() == 0) {
                    llCodes.setVisibility(View.GONE);
                    rCodes.setVisibility(View.GONE);
                } else {
                    llCodes.setVisibility(View.VISIBLE);
                    rCodes.setVisibility(View.VISIBLE);
                    ServicesAdapter servicesAdapter = new ServicesAdapter();
                    servicesAdapter.setList(service.codes);
                    rCodes.setAdapter(servicesAdapter);
                    rCodes.setLayoutManager(new LinearLayoutManager(getActivity()));
                }


                NotesAdapter notesAdapter = new NotesAdapter();
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