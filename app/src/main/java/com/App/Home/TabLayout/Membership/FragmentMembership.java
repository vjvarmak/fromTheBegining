package com.App.Home.TabLayout.Membership;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.App.Network.API.MembershipAPI;
import com.App.test.databinding.FragmantMembershipBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentMembership extends Fragment {
    public static FragmentMembership newInstance(){return new FragmentMembership();}

    private FragmantMembershipBinding fragmantMembershipBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmantMembershipBinding fragmantMembershipBinding = FragmantMembershipBinding.inflate(getLayoutInflater());
        View view = fragmantMembershipBinding.getRoot();

        fragmantMembershipBinding.recViewMembership.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MembershipAPI membership = retrofit.create(MembershipAPI.class);
        Call<List<MembershipData>> call= membership.getMembershipAPI();

        call.enqueue(new Callback<List<MembershipData>>() {
            @Override
            public void onResponse(Call<List<MembershipData>> call, Response<List<MembershipData>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                }

                List<MembershipData> membershipDataList = response.body();
                MembershipAdapter membershipAdapter = new MembershipAdapter(getContext(),membershipDataList);
                fragmantMembershipBinding.recViewMembership.setAdapter(membershipAdapter);
            }

            @Override
            public void onFailure(Call<List<MembershipData>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}

