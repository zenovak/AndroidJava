package com.zenovak.fragment;

import com.zenovak.fragment.model.FragmentUsageExample;

public class DataRegistry {

    public static final FragmentUsageExample[] FRAGMENT_USAGE_EXAMPLES = new FragmentUsageExample[] {
            new FragmentUsageExample(
                    "Static Fragment",
                    "A static fragment directly attached to an activity",
                    StaticFragmentActivity.class
            ),
            new FragmentUsageExample(
                    "View Pager Fragment",
                    "An activity with multiple swippable pages",
                    ViewPagerFragmentActivity.class
            ),
    };
}
