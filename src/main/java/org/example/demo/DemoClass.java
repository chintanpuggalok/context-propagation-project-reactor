package org.example.demo;

public class DemoClass {
    String demoAttribute;
    public DemoClass(String demoAttribute)
    {
        this.demoAttribute=demoAttribute;
    }

    @Override
    public String toString() {
        return "DemoClass"+demoAttribute;
    }
}
