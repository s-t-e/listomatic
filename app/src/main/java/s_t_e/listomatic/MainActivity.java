package s_t_e.listomatic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import s_t_e.listomatic.fragments.BaseFragment;

public class MainActivity extends AppCompatActivity {

    @BindView
    (R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView
    (R.id.left_drawer) ListView drawerList;

    private String[] menuOptions = {"Home", "Browse", "Search", "Favourites"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        drawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item,
                menuOptions));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            selectItem(position);
        }

        private void selectItem(int position) {
            Fragment fragment = new BaseFragment();
            Bundle args = new Bundle();
            args.putString(BaseFragment.ARG_FRAGMENT_NAME, menuOptions[position]);
            fragment.setArguments(args);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            drawerList.setItemChecked(position, true);
            setTitle(menuOptions[position]);
            drawerLayout.closeDrawer(drawerList);
        }
    }


}
