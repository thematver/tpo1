package xyz.anomatver.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testPersonJawDropsWhenAstonishedByMoreThanThreeThings() {
        Person person = new Person();
        person.addAstonishingThing();
        person.addAstonishingThing();
        person.addAstonishingThing();
        person.addAstonishingThing();

        assertTrue(person.isJawDropped());
    }


    @Test
    public void testPersonCanUseUnoccupiedControlPanel() {
        Person person = new Person();
        ControlPanel controlPanel = new ControlPanel();

        assertTrue(person.canUseControlPanel(controlPanel));
    }

    @Test
    public void testPersonCannotPutFeetOnOccupiedControlPanel() {
        Person person1 = new Person();
        Person person2 = new Person();
        ControlPanel controlPanel = new ControlPanel();

        person1.putFeetOnControlPanel(controlPanel);
        person2.putFeetOnControlPanel(controlPanel);

        assertEquals(controlPanel, person1.controlPanelWithFeetOn);
        assertNull(person2.controlPanelWithFeetOn);
    }

    @Test
    public void testPersonCannotUseControlPanelWithFeetOnIt() {
        Person person = new Person();
        ControlPanel controlPanel = new ControlPanel();

        person.putFeetOnControlPanel(controlPanel);

        assertFalse(person.canUseControlPanel(controlPanel));
    }




    @Test
    public void testHeadCannotSmileIfPickingTeeth() {
        Head head = new Head();
        head.startPickingTeeth();

        assertFalse(head.canSmile());
    }

    @Test
    public void testSettingNumberOfHeads() {
        Person person = new Person();
        person.setNumberOfHeads(1);
        assertEquals(1, person.getNumberOfHeads());

        person.setNumberOfHeads(2);
        assertEquals(2, person.getNumberOfHeads());
    }

    @Test
    public void testAddingAstonishingThings() {
        Person person = new Person();
        person.addAstonishingThing();
        person.addAstonishingThing();
        person.addAstonishingThing();

        assertFalse(person.isJawDropped());
    }

    @Test
    public void testJawDroppedSmileAndAstonishedStates() {
        Person person = new Person();
        assertFalse(person.isJawDropped());
        assertTrue(person.canSmile());
        assertTrue(person.canBeAstonished());

        person.setAstonished(true);
        assertTrue(person.isJawDropped());
        assertFalse(person.canSmile());
    }

    @Test
    public void testCanSmile() {
        Person person = new Person();

        // Initially, a person should be able to smile
        assertTrue(person.canSmile());

        // Person cannot smile when astonished
        person.setAstonished(true);
        assertFalse(person.canSmile());

        // Person can smile when not astonished
        person.setAstonished(false);
        assertTrue(person.canSmile());
    }

    
    @Test
    public void testCanSmileAndCanBeAstonishedWithDifferentStates() {
        Person person = new Person();

        // Initially, a person should be able to smile and be astonished
        assertTrue(person.canSmile());
        assertTrue(person.canBeAstonished());

        // Person cannot smile and can be astonished when astonished
        person.setAstonished(true);
        assertFalse(person.canSmile());
        assertTrue(person.canBeAstonished());

        // Person can smile and cannot be astonished when not astonished
        person.setAstonished(false);
        person.setSmiling(true);
        assertTrue(person.canSmile());
        assertFalse(person.canBeAstonished());

        // Person can be astonished and can smile when not smiling and not astonished
        person.setSmiling(false);
        assertTrue(person.canBeAstonished());
        assertTrue(person.canSmile());
    }


    @Test
    public void testHeadCannotPickTeethIfSmiling() {
        Head head = new Head();
        head.startSmiling();

        assertFalse(head.canPickTeeth());
    }

    @Test
    public void testAstonishedPersonCannotSmile() {
        Person person = new Person();
        person.setAstonished(true);

        assertFalse(person.canSmile());
    }

    @Test
    public void testSmilingPersonCannotBeAstonished() {
        Person person = new Person();
        person.setSmiling(true);

        assertFalse(person.canBeAstonished());
    }

    @Test
    public void testNumberOfHeadsCannotBeLessThanZeroOrMoreThanTwo() {
        Person person = new Person();

        assertThrows(IllegalArgumentException.class, () -> person.setNumberOfHeads(-1));
        assertThrows(IllegalArgumentException.class, () -> person.setNumberOfHeads(3));
    }

    @Test
    public void testCannotSitOnOccupiedChair() {
        Person person1 = new Person();
        Person person2 = new Person();
        Chair chair = new Chair();

        chair.sit(person1);

        assertFalse(chair.canSit(person2));
    }
}
