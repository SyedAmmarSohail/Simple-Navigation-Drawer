package com.example.ammar.navigationdrawer.datasource;

import android.content.Context;

import com.example.ammar.navigationdrawer.R;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by msahakyan on 22/10/15.
 */
public class ExpandableListDataSource {

    /**
     * Returns fake data of films
     *
     * @param context
     * @return
     */
    public static Map<String, List<String>> getData(Context context) {
        Map<String, List<String>> expandableListData = new TreeMap<>();

        List<String> versions = Arrays.asList(context.getResources().getStringArray(R.array.versions));

        List<String> nougat = Arrays.asList(context.getResources().getStringArray(R.array.nougat));
        List<String> Marshmallow = Arrays.asList(context.getResources().getStringArray(R.array.marshmallow));
        List<String> lollipop = Arrays.asList(context.getResources().getStringArray(R.array.lollipop));
        List<String> thrillerFilms = Arrays.asList(context.getResources().getStringArray(R.array.kitKat));
        List<String> jelly_bean = Arrays.asList(context.getResources().getStringArray(R.array.jelly_bean));

        expandableListData.put(versions.get(0), nougat);
        expandableListData.put(versions.get(1), Marshmallow);
        expandableListData.put(versions.get(2), lollipop);
        expandableListData.put(versions.get(3), thrillerFilms);
        expandableListData.put(versions.get(4), jelly_bean);

        return expandableListData;
    }
}
