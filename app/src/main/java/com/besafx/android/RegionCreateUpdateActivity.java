package com.besafx.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.besafx.android.adapter.PersonSpinnerAdapter;
import com.besafx.android.entity.Person;
import com.besafx.android.entity.Region;
import com.besafx.android.task.GetPersonsUnderMe;
import com.besafx.android.task.PostRegion;
import com.google.common.collect.Lists;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegionCreateUpdateActivity extends AppCompatActivity {

    private static final String TAG = RegionCreateUpdateActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.input_name)
    TextView input_name;

    @BindView(R.id.input_address)
    TextView input_address;

    @BindView(R.id.spinner_manager)
    Spinner spinner_manager;

    @BindView(R.id.selected_manager)
    TextView selected_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_create_update);

        ButterKnife.bind(this);

        toolbar.setTitle(getString(R.string.txt_add_region));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initManagerSpinner();
    }

    protected void initManagerSpinner() {
        new GetPersonsUnderMe(this, new GetPersonsUnderMe.OnAction() {
            @Override
            public void onGetSuccess(final Person[] persons) {
                PersonSpinnerAdapter personGridAdapter = new PersonSpinnerAdapter(getApplicationContext(), R.layout.spinner_person_item, Lists.newArrayList(persons));
                spinner_manager.setAdapter(personGridAdapter);
                spinner_manager.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onGetFailed() {

            }
        }).execute();
    }

    @OnClick(R.id.btn_save_region)
    public void saveRegion() {
        Person manager = (Person) spinner_manager.getSelectedItem();
        Region region = new Region();
        region.setName(input_name.getText().toString());
        region.setAddress(input_address.getText().toString());
        region.setManager(manager);
        region.setCompany(LoginActivity.company);
        new PostRegion(this, region, new PostRegion.OnAction() {
            @Override
            public void onGetSuccess(final Region region) {
                Log.d(TAG, "Region Id: " + region.getId());
                input_name.setText("");
                input_address.setText("");
                spinner_manager.setSelection(0);
                Toast.makeText(getApplicationContext(), "تم إنشاء المنطقة الجديدة بنجاح", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onGetFailed() {

            }
        }).execute();
    }
}
