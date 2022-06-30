package com.App.Home.TabLayout.Home;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.App.Home.TabLayout.Account.FragmentAccount;
import com.App.Home.TabLayout.Membership.FragmentMembership;
import com.App.Home.TabLayout.Trips.FragmentTrips;
import com.App.Home.TabLayout.Points.FragmentPoints;
import com.App.test.databinding.FragmentHomeBinding;

public class FragmentHome extends Fragment {
    private FragmentHomeBinding fragmentHomeBinding;

    public static FragmentHome newInstance() {
        return new FragmentHome();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater ,container ,false);
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerAdapter.addFragment(FragmentTrips.newInstance(),"Trips");
        viewPagerAdapter.addFragment(FragmentPoints.newInstance(),"Points");
        viewPagerAdapter.addFragment(FragmentAccount.newInstance(),"Account");
        viewPagerAdapter.addFragment(FragmentMembership.newInstance(),"Membership");
        fragmentHomeBinding.viewPager.setAdapter(viewPagerAdapter);
        fragmentHomeBinding.tabLayout.setupWithViewPager(fragmentHomeBinding.viewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentHomeBinding = null;
    }
}
