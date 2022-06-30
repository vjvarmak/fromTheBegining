package com.App.Home.TabLayout.Account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.App.Network.API.AccountAPI;
import com.App.test.databinding.FragmentAccountBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentAccount extends Fragment {
    private FragmentAccountBinding fragmentAccountBinding;

    public static FragmentAccount newInstance() {
        return new FragmentAccount();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater, container, false);
        View view = fragmentAccountBinding.getRoot();

        fragmentAccountBinding.recviewAccount.setLayoutManager(new LinearLayoutManager(getContext()));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        AccountAPI accountAPI = retrofit.create(AccountAPI.class);
        Call<List<AccountData>> call = accountAPI.getAccountAPI();


        call.enqueue(new Callback<List<AccountData>>() {
            @Override
            public void onResponse(Call<List<AccountData>> call, Response<List<AccountData>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<AccountData> accountList = response.body();
                AccountListAdapter accountListAdapter = new AccountListAdapter(getContext(), accountList);
                fragmentAccountBinding.recviewAccount.setAdapter(accountListAdapter);
            }

            @Override
            public void onFailure(Call<List<AccountData>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentAccountBinding = null;
    }
}
