package com.zenovak.fragment.model;


public class FragmentUsageExample {
    private String name;
    private String description;
    private Class<?> hostActivity;


    public FragmentUsageExample(String name, String description, Class<?> hostActivity) {
        this.name = name;
        this.description = description;
        this.hostActivity = hostActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Class<?> getHostActivity() {
        return hostActivity;
    }

    public void setHostActivity(Class<?> hostActivity) {
        this.hostActivity = hostActivity;
    }
}
