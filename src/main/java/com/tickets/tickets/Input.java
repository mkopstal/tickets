package com.tickets.tickets;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Input {
    private boolean isAdult;
    private int bags;

    public Input(boolean isAdult, int bags) {
        this.isAdult = isAdult;
        this.bags = bags;
    }

    // Getter for isAdult
    @JsonProperty("isAdult")
    public boolean getIsAdult() {
        return this.isAdult;
    }

    // Setter for isAdult
    public void setAdult(boolean adult) {
        this.isAdult = adult;
    }

    // Getter for bags
    public int getBags() {
        return bags;
    }

}

