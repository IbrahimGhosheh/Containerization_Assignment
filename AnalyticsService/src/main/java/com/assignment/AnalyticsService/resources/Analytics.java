package com.assignment.AnalyticsService.resources;

import java.util.ArrayList;
import java.util.Collections;

public class Analytics {

    public static ArrayList<Integer> analyze(ArrayList<Integer> ages){
        ArrayList<Integer> analyticsResult = new ArrayList<>();
        analyticsResult.add(Collections.max(ages));
        analyticsResult.add(Collections.min(ages));
        int sum =0;
        for(int x:ages){
            sum+=x;
        }
        analyticsResult.add(sum/ages.size());
        return analyticsResult;

    }
}
