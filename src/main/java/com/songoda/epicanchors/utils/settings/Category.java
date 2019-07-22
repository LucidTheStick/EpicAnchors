package com.songoda.epicanchors.utils.settings;

public enum Category {

    MAIN("General settings and options."),
    ECONOMY("Settings regarding economy.",
            "Only one economy option can be used at a time. If you enable more than",
            "one of these the first one will be used."),
    INTERFACES("These settings allow you to alter the way interfaces look.",
            "They are used in GUI's to make patterns, change them up then open up a",
            "GUI to see how it works."),
    SYSTEM("System related settings.");

    private String[] comments;


    Category(String... comments) {
        this.comments = comments;
    }

    public String[] getComments() {
        return comments;
    }
}