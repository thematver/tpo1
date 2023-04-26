package xyz.anomatver.domain;

class Chair {
    private boolean occupied;

    public void sit(Person person) {
        if (!occupied) {
            occupied = true;
            person.sittingOnChair = true;
        }
    }

    public boolean canSit(Person person) {
        return !occupied;
    }
}

