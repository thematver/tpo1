package xyz.anomatver.domain;

class Head {
    private boolean pickingTeeth;
    private boolean smiling;

    public void startPickingTeeth() {
        pickingTeeth = true;
    }

    public void startSmiling() {
        smiling = true;
    }

    public boolean canSmile() {
        return !pickingTeeth;
    }

    public boolean canPickTeeth() {
        return !smiling;
    }
}