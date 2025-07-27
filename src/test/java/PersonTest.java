import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person bob;
    private Person father;
    private Person mother;
    private Person sibling;
    private Person niece;
    private Person child;
    private Person partner;
    private Pet dog;

    @BeforeEach
    void setUp() {
        bob = new Person("Bob", "de Bouwer", 42, "male");
        father = new Person("Jack", "de Bouwer", 68, "male");
        mother = new Person("Maria", "van der Lienden", 65, "female");
        sibling = new Person("Anna", "Sofia", "de Bouwer", 35, "female");
        niece = new Person("Lisa", "de Jong", 11, "female");
        child = new Person("Job", "de Bouwer", 8, "male");
        partner = new Person("Eva", "de Bouwer", 39, "female");
        dog = new Pet("Buddy", 3, "dog", "male");
    }

    @Test
    void canAddParents() {
        //act
        bob.addParents(father, mother);
        //assert
        assertEquals(father, bob.getFather());
        assertEquals(mother, bob.getMother());
    }

    @Test
    void canAddChildMale() {
        //act
        bob.addChild(child);
        //assert
        assertTrue(bob.getChildren().contains(child));
        assertEquals(bob, child.getFather());
    }

    @Test
    void canAddChildFemale() {
        //act
        mother.addChild(bob);
        //assert
        assertTrue(mother.getChildren().contains(bob));
        assertEquals(mother, bob.getMother());
    }

    @Test
    void cannotAddConsistingChild() {
        //act
        bob.addChild(child);
        bob.addChild(child);

        //assert
        assertTrue(bob.getChildren().contains(child));
        assertEquals(1, bob.getChildren().size());
    }

    @Test
    void canAddSibling() {
        //act
        bob.addSibling(sibling);
        //assert
        assertTrue(bob.getSiblings().contains(sibling));
    }

    @Test
    void canAddPet() {
        //act
        bob.addPet(dog);
        //assert
        assertTrue(bob.getPets().contains(dog));
    }

    @Test
    void canGetGrandChildren() {
        //arrange
        bob.addChild(child);
        father.addChild(bob);
        //act
        List<Person> grandchildren = father.getGrandChildren();
        //assert
        assertTrue(grandchildren.contains(child));
        assertEquals(1, grandchildren.size());
    }

    @Test
    void canGetNieces() {
        //arrange
        sibling.addChild(niece);
        bob.addSibling(sibling);
        //act
        List<Person> nieces = bob.getNieces();
        //assert
        assertTrue(nieces.contains(niece));
        assertEquals(1, nieces.size());
    }

    @Test
    void canGetPetsOfGrandChildren() {
        //arrange
        father.addChild(bob);
        bob.addChild(child);
        child.addPet(dog);
        //act
        List<Pet> petsOfGrandChildren = father.getPetsOfGrandChildren();
        //assert
        assertTrue(petsOfGrandChildren.contains(dog));
        assertEquals(1, petsOfGrandChildren.size());
    }

    @Test
    void increaseAge() {
        //act
        bob.increaseAge();
        //assert
        assertEquals(43, bob.getAge());
    }

    @Test
    void getFamilyReunionList() {
        //arrange
        bob.addParents(father, mother);
        bob.addSibling(sibling);
        bob.addChild(child);
        bob.setPartner(partner);
        //act
        List<Person> familyReunionList = bob.getInvatationList();
        //assert
        assertTrue(familyReunionList.contains(bob.getMother()));
        assertTrue(familyReunionList.contains(bob.getFather()));
        assertTrue(familyReunionList.containsAll(bob.getSiblings()));
        assertTrue(familyReunionList.containsAll(bob.getChildren()));
        assertTrue(familyReunionList.contains(bob.getPartner()));
    }
}