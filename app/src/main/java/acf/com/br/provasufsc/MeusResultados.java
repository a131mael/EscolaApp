package acf.com.br.provasufsc;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class MeusResultados extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_resultados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createGroupList();

        createCollection();
        expListView = (ExpandableListView) findViewById(R.id.expandableListView);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, laptopCollection);
        expListView.setAdapter(expListAdapter);

        //setGroupIndicatorToRight();

        expListView.setOnChildClickListener(new OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();

                return true;
            }
        });
    }

    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("1º Bimestre");
        groupList.add("2º Bimestre");
        groupList.add("3º Bimestre");
        groupList.add("4º Bimestre");
        groupList.add("Média Final");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] hpModels = { "Português", "Inglês", "História", "Geografia",  "Ciências", "Artes", "Educação Religiosa", "Educação Física" };

        /*String[] hclModels = { "HCL S2101", "HCL L2102", "HCL V2002" };
        String[] lenovoModels = { "IdeaPad Z Series", "Essential G Series",
                "ThinkPad X Series", "Ideapad Z Series" };
        String[] sonyModels = { "VAIO E Series", "VAIO Z Series",
                "VAIO S Series", "VAIO YB Series" };
        String[] dellModels = { "Inspiron", "Vostro", "XPS" };
        String[] samsungModels = { "NP Series", "Series 5", "SF Series" };
*/
        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("1º Bimestre")) {
                loadChild(hpModels);
            } else if (laptop.equals("2º Bimestre"))
                loadChild(hpModels);
            else if (laptop.equals("3º Bimestre"))
                loadChild(hpModels);
            else if (laptop.equals("4º Bimestre"))
                loadChild(hpModels);
            else if (laptop.equals("Média Final"))
                loadChild(hpModels);

            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }


}
