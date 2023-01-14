package com.example.myvodafone.ui.internet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvodafone.MiBundlesAdapter;
import com.example.myvodafone.NotesAdapter;
import com.example.myvodafone.R;
import com.example.myvodafone.ServicesAdapter;
import com.example.myvodafone.model.BundleMI;
import com.example.myvodafone.model.ServiceModel;

import java.util.ArrayList;

public class InternetFragment extends Fragment {

    private InternetViewModel internetViewModel;
    Spinner sBundles;
    ArrayAdapter serviceArrayAdapter;
    ArrayList<ServiceModel> extremeCodes,spSocialCodes,spStreamingCodes,spCompoCodes,addOnCodes,usbCodes;
    ArrayList<String> miBundleNotes,usbNotes;
    ArrayList<ServiceModel> serviceModelArrayList;
    RecyclerView rCodes,rNotes;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_services, container, false);
        /*internetViewModel = new ViewModelProvider(this).get(InternetViewModel.class);
        final TextView textView = root.findViewById(R.id.text_internet);
        internetViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        sBundles=root.findViewById(R.id.s_services);

        rCodes =root.findViewById(R.id.r_codes);
        rNotes =root.findViewById(R.id.r_notes);



        extremeCodes =new ArrayList<>();
        extremeCodes.add(new ServiceModel("*2000#","free","ussed","manage everything"));
        extremeCodes.add(new ServiceModel("*2000*9#","free","ussed","follow consumption"));
        extremeCodes.add(new ServiceModel("*2000*99#","free","ussed","renew MI bundle"));
        extremeCodes.add(new ServiceModel("*2000*5#","5LE","in","gave CST 150MBs"));
        extremeCodes.add(new ServiceModel("*2000*10#","10LE","in","gave CST 500MBs"));
        extremeCodes.add(new ServiceModel("*2000*20#","20LE","in","gave CST 1100MBs"));
        extremeCodes.add(new ServiceModel("*2000*30#","30LE","in","gave CST 1800MBs"));
        extremeCodes.add(new ServiceModel("*2000*40#","40LE","in","gave CST 2500MBs"));
        extremeCodes.add(new ServiceModel("*2000*60#","60LE","in","gave CST 4000MBs"));
        extremeCodes.add(new ServiceModel("*2000*80#","80LE","in","gave CST 6000MBs"));
        extremeCodes.add(new ServiceModel("*2000*100#","100LE","in","gave CST 8000MBs"));
        extremeCodes.add(new ServiceModel("*2000*150#","150LE","in","gave CST 12000MBs"));
        extremeCodes.add(new ServiceModel("*2000*250#","250LE","in","gave CST 20000MBs"));
        extremeCodes.add(new ServiceModel("*2000*400#","400LE","in","gave CST 40000MBs"));
        extremeCodes.add(new ServiceModel("*888*4#\n*2000*14#","free","in","active MI"));

        extremeCodes.add(new ServiceModel("*888*41#","free","out","cancel MI"));
        extremeCodes.add(new ServiceModel("*2000*0#","free","out","cancel MI bundle"));
        extremeCodes.add(new ServiceModel("*2000*28#","free","out","deactivate rollover and make it 30 days"));

        miBundleNotes=new ArrayList<>();
        miBundleNotes.add("If CST hasn't MI bundle, he will get first 10MBs by 1.25LE then each 1MB by 50PT");
        miBundleNotes.add("If CST hasn't MI bundle and his balance is less than 1.25LE, he will get first 5MBs by 75PT then each 3MB by 75PT");
        miBundleNotes.add("If CST finished his MI bundle he will get 15MBs by 1LE for 30 times then 1MB by 10PT");
        miBundleNotes.add("If CST charge a bundle but he hasn't balance, the bundle will be GRASS for 28 days");
        miBundleNotes.add("The rest of bundle will be rollover if CST renews his bundle on time or change to larger bundle");
        miBundleNotes.add("CST can't subscribe in 2 different bundles at the same time");
        miBundleNotes.add("Extreme and Super Pass bundles working in egypt only not roaming");
        miBundleNotes.add("Super Pass (social) 1MB in (social apps) = 1SMB  but 1MB in (other apps) = 2SMB.\nsocial apps: facebook, whatsapp, twitter, intagram and snapchat");
        miBundleNotes.add("Super Pass (streaming) 1MB in (streaming apps) = 1SMB  but 1MB in (other apps) = 2SMB.\nstreaming apps: youtube, shahid, soundcloud, anghami, nogoum FM and nile FM");














        spSocialCodes =new ArrayList<>();
        spSocialCodes.add(new ServiceModel("*2000#","free","ussed","manage everything"));
        spSocialCodes.add(new ServiceModel("*2000*9#","free","ussed","follow consumption"));
        spSocialCodes.add(new ServiceModel("*2000*99#","free","ussed","renew MI bundle"));
        spSocialCodes.add(new ServiceModel("*2207#","7LE","in","gave CST 500MBs"));
        spSocialCodes.add(new ServiceModel("*2215#","15LE","in","gave CST 1500MBs"));
        spSocialCodes.add(new ServiceModel("*2225#","25LE","in","gave CST 2800MBs"));
        spSocialCodes.add(new ServiceModel("*2235#","35LE","in","gave CST 4500MBs"));
        spSocialCodes.add(new ServiceModel("*2245#","45LE","in","gave CST 6000MBs"));
        spSocialCodes.add(new ServiceModel("*2265#","65LE","in","gave CST 9500MBs"));
        spSocialCodes.add(new ServiceModel("*888*4#\n*2000*14#","free","in","active MI"));
        spSocialCodes.add(new ServiceModel("*888*41#","free","out","cancel MI"));
        spSocialCodes.add(new ServiceModel("*2000*0#","free","out","cancel MI bundle"));
        spSocialCodes.add(new ServiceModel("*2000*28#","free","out","deactivate rollover and make it 30 days"));





        spStreamingCodes =new ArrayList<>();
        spStreamingCodes.add(new ServiceModel("*2000#","free","ussed","manage everything"));
        spStreamingCodes.add(new ServiceModel("*2000*9#","free","ussed","follow consumption"));
        spStreamingCodes.add(new ServiceModel("*2000*99#","free","ussed","renew MI bundle"));
        spStreamingCodes.add(new ServiceModel("*2307#","7LE","in","gave CST 500MBs"));
        spStreamingCodes.add(new ServiceModel("*2315#","15LE","in","gave CST 1500MBs"));
        spStreamingCodes.add(new ServiceModel("*2325#","25LE","in","gave CST 2800MBs"));
        spStreamingCodes.add(new ServiceModel("*2335#","35LE","in","gave CST 4500MBs"));
        spStreamingCodes.add(new ServiceModel("*2345#","45LE","in","gave CST 6000MBs"));
        spStreamingCodes.add(new ServiceModel("*2365#","65LE","in","gave CST 9500MBs"));
        spStreamingCodes.add(new ServiceModel("*888*4#\n*2000*14#","free","in","active MI"));

        spStreamingCodes.add(new ServiceModel("*888*41#","free","out","cancel MI"));
        spStreamingCodes.add(new ServiceModel("*2000*0#","free","out","cancel MI bundle"));
        spStreamingCodes.add(new ServiceModel("*2000*28#","free","out","deactivate rollover and make it 30 days"));



        spCompoCodes =new ArrayList<>();
        spCompoCodes.add(new ServiceModel("*2000#","free","ussed","manage everything"));
        spCompoCodes.add(new ServiceModel("*2000*9#","free","ussed","follow consumption"));
        spCompoCodes.add(new ServiceModel("*2000*99#","free","ussed","renew MI bundle"));
        spCompoCodes.add(new ServiceModel("*2120#","120LE","in","gave CST 20000MBs"));
        spCompoCodes.add(new ServiceModel("*2200#","200LE","in","gave CST 36000MBs"));
        spCompoCodes.add(new ServiceModel("*2300#","300LE","in","gave CST 58000MBs"));
        spCompoCodes.add(new ServiceModel("*888*4#\n*2000*14#","free","in","active MI"));
        spCompoCodes.add(new ServiceModel("*888*41#","free","out","cancel MI"));
        spCompoCodes.add(new ServiceModel("*2000*0#","free","out","cancel MI bundle"));
        spCompoCodes.add(new ServiceModel("*2000*28#","free","out","deactivate rollover and make it 30 days"));




        addOnCodes =new ArrayList<>();
        addOnCodes.add(new ServiceModel("*2000*55#","5LE","in","Renewable: gave CST 150MBs"));
        addOnCodes.add(new ServiceModel("*2000*510#","10LE","in","Renewable: throttling"));
        addOnCodes.add(new ServiceModel("*2000*520#","20LE","in","Renewable: gave CST 1024MBs"));
        addOnCodes.add(new ServiceModel("*2000*155#","5LE","in","On-demand: gave CST 150MBs"));
        addOnCodes.add(new ServiceModel("*2000*1510#","10LE","in","On-demand: throttling"));
        addOnCodes.add(new ServiceModel("*2000*1520#","20LE","in","On-demand: gave CST 1024MBs"));




        usbCodes =new ArrayList<>();
        usbCodes.add(new ServiceModel("*2828#","free","ussed","manage everything"));
        usbNotes=new ArrayList<>();
        usbNotes.add("CST can manage every thing by usb dash board or ana VF app or website");
        usbNotes.add("CST can make his bundle 30 days instead of 28 but without rollover");
        usbNotes.add("if the CST has no MI bundle or didn't renew it then block");
        usbNotes.add("if CST finished his bundle, he will get first 15MBs by 1LE for 30 times per day");
        usbNotes.add("if CST finished his bundle, he can get ADD-ON");
        usbNotes.add("if CST finished his bundle, he can deactivate it");






        serviceModelArrayList=new ArrayList<>();
        serviceModelArrayList.add(new ServiceModel("Extreme",extremeCodes,miBundleNotes));
        serviceModelArrayList.add(new ServiceModel("SuperPass Social",spSocialCodes,miBundleNotes));
        serviceModelArrayList.add(new ServiceModel("SuperPass Streaming",spStreamingCodes,miBundleNotes));
        serviceModelArrayList.add(new ServiceModel("SuperPass Compo",spCompoCodes,miBundleNotes));
        serviceModelArrayList.add(new ServiceModel("Add-On",addOnCodes,miBundleNotes));
        serviceModelArrayList.add(new ServiceModel("USB",usbCodes,usbNotes));

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