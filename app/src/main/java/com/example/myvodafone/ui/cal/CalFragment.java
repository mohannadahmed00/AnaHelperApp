package com.example.myvodafone.ui.cal;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myvodafone.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalFragment extends Fragment implements View.OnClickListener {

    TextView tvFlex,tvMb;
    EditText etFlex,etMb,etMoney,etBalance;
    Button btnDone,btnReset;

    String bmFlag="";

    private CalViewModel calViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);
        tvFlex = root.findViewById(R.id.tv_flex_calculator);
        tvMb = root.findViewById(R.id.tv_mb_calculator);
        etFlex=root.findViewById(R.id.et_flex_calculator);
        etMb=root.findViewById(R.id.et_mb_calculator);
        etMoney=root.findViewById(R.id.et_money_calculator);
        etBalance=root.findViewById(R.id.et_balance_calculator);
        btnDone=root.findViewById(R.id.btn_done_calculator);
        btnReset=root.findViewById(R.id.btn_reset_calculator);
        btnDone.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        /*calViewModel = new ViewModelProvider(this).get(CalViewModel.class);
        calViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        etMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bmFlag="money";
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etBalance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bmFlag="balance";
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return root;
    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_done_calculator:
                if (!etFlex.getText().toString().equals("")) {
                    tvFlex.setText(String.valueOf(Integer.parseInt(etFlex.getText().toString()) * 5)+" Flex");
                }
                if (!etMb.getText().toString().equals("")) {
                    long a=Long.parseLong(etMb.getText().toString())/1048576;
                    //String a=etMb.getText().toString();1048576
                    tvMb.setText(a +" MB");
                }
                if (!etBalance.getText().toString().equals("")||!etMoney.getText().toString().equals("")) {
                    if (bmFlag.equals("money") && !etMoney.getText().toString().equals("")){
                        etBalance.setText(String.format("%.2f",Double.parseDouble(etMoney.getText().toString()) * 0.7));
                    }else if (bmFlag.equals("balance") && !etBalance.getText().toString().equals("")){
                        etMoney.setText(String.format("%.2f",Double.parseDouble(etBalance.getText().toString()) / 0.7));
                    }else if (!etMoney.getText().toString().equals("")){
                        etBalance.setText(String.format("%.2f",Double.parseDouble(etMoney.getText().toString()) * 0.7));
                    }else if (!etBalance.getText().toString().equals("")){
                        etMoney.setText(String.format("%.2f",Double.parseDouble(etBalance.getText().toString()) / 0.7));
                    }
                }
                break;
            case R.id.btn_reset_calculator:
                etFlex.setText("");
                tvFlex.setText("");

                etMb.setText("");
                tvMb.setText("");

                etMoney.setText("");
                etBalance.setText("");

                break;
        }
    }
}