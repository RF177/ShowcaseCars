package net.unibave.showcasecars.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.unibave.showcasecars.fragment.ListaCarroFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(createFragment(1L));
        fragments.add(createFragment(2L));
        fragments.add(createFragment(3L));
    }

    private Fragment createFragment(Long idCategoria) {
        ListaCarroFragment listaCarroFragment = new ListaCarroFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("idCategoria", idCategoria);
        listaCarroFragment.setArguments(bundle);
        return listaCarroFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Clássicos";
            case 1:
                return "Esportivos";
            case 2:
                return "Luxo";

        }


        return super.getPageTitle(position);
    }
}
