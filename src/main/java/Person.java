import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private String nickName;
    private final String gender;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();
    private Person partner;


    public Person(String firstName, String middleName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Person(String firstName, String lastName, int age, String gender) {
        this(firstName, "", lastName, age, gender);
    }

    public Person(String firstName, String middleName, String lastName, String nickName, String gender, int age, Person mother, Person father,
                  List<Person> siblings, List<Person> children, List<Pet> pets, Person partner) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.gender = gender;
        this.age = age;
        this.mother = mother;
        this.father = father;
        this.siblings = siblings;
        this.children = children;
        this.pets = pets;
        this.partner = partner;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public Person getPartner() {
        return partner;
    }


    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }


    public void addParents(Person father, Person mother) {
        this.mother = mother;
        this.father = father;
    }

    public void addChild(Person child) {
        if(!getChildren().contains(child)) {
            this.children.add(child);
        }

        if(this.gender.equalsIgnoreCase("male")) {
            child.setFather(this);
        }

        if(this.gender.equalsIgnoreCase("female")) {
            child.setMother(this);
        }
    }

    public void addSibling(Person sibling) {
        if(!getSiblings().contains(sibling)) {
            this.siblings.add(sibling);
        }
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        for(Person child : getChildren()) {
            grandChildren.addAll(child.getChildren());
        }
        return grandChildren;
    }

    public List<Person> getNieces() {
        List<Person> nieces = new ArrayList<>();
        for(Person sibling : getSiblings()) {
            for(Person child : sibling.getChildren()) {
                if(child.getGender().equalsIgnoreCase("female")) {
                    nieces.add(child);
                }
            }
        }
        return nieces;
    }

    public List<Pet> getPetsOfGrandChildren() {
        List<Pet> petsOfGrandChildren = new ArrayList<>();
        List<Person> grandChildren = getGrandChildren();
        for(Person child : grandChildren) {
            petsOfGrandChildren.addAll(child.getPets());
        }
        return petsOfGrandChildren;
    }

    public void increaseAge() {
        age++;
    }

    public List<Person> getInvatationList() {
        List<Person> familyInvatationList = new ArrayList<>();

        if (this.mother != null) {
            familyInvatationList.add(this.mother);
        }

        if (this.father != null) {
            familyInvatationList.add(this.father);
        }

        if (this.siblings != null) {
            familyInvatationList.addAll(this.siblings);
        }

        if (this.children != null) {
            familyInvatationList.addAll(this.children);
            List<Person> grandchildren = getGrandChildren();
            if(grandchildren != null) {
                familyInvatationList.addAll(grandchildren);
            }
        }

        if (this.partner != null) {
            familyInvatationList.add(this.partner);
        }

        return familyInvatationList;
    }





}
