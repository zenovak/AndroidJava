package com.zenovak.fragment;

import com.zenovak.fragment.model.FragmentUsageExample;

public class DataRegistry {

    public static final FragmentUsageExample[] FRAGMENT_USAGE_EXAMPLES = new FragmentUsageExample[] {
      new FragmentUsageExample(
              "Static Fragment",
              "This example shows a static fragment", StaticFragmentActivity.class)
    };
}
