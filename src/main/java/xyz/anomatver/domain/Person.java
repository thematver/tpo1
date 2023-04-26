package xyz.anomatver.domain;

class Person {
    private boolean astonished;
    private boolean smiling;
    private int numberOfHeads;
    ControlPanel controlPanelWithFeetOn;
    private int astonishingThings;
    boolean sittingOnChair;

    public void setAstonished(boolean astonished) {
        this.astonished = astonished;
    }

    public void setSmiling(boolean smiling) {
        this.smiling = smiling;
    }

    public void setNumberOfHeads(int numberOfHeads) {
        if (numberOfHeads < 0 || numberOfHeads > 2) {
            throw new IllegalArgumentException("Number of heads cannot be less than 0 or more than 2");
        }
        this.numberOfHeads = numberOfHeads;
    }

    public void putFeetOnControlPanel(ControlPanel controlPanel) {
        if (!controlPanel.isFeetOnIt()) {
            controlPanel.setFeetOnIt(true);
            this.controlPanelWithFeetOn = controlPanel;
        }
    }

    public boolean canUseControlPanel(ControlPanel controlPanel) {
        return !controlPanel.isFeetOnIt();
    }

    public void addAstonishingThing() {
        astonishingThings++;
        if (astonishingThings > 3) {
            setAstonished(true);
        }
    }

    public boolean isJawDropped() {
        return astonished;
    }

    public int getNumberOfHeads() {
        return numberOfHeads;
    }


    public boolean canSmile() {
        return !astonished;
    }

    public boolean canBeAstonished() {
        return !smiling;
    }
}