import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private String nickName;
    private final String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();


    public Person(String firstName, String middleName, String lastName, int age, String sex) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String firstName, String lastName, int age, String sex) {
        this(firstName, "", lastName, age, sex);
    }

    public Person(String firstName, String middleName, String lastName, String nickName, String sex, int age, Person mother, Person father,
                  List<Person> siblings, List<Person> children, List<Pet> pets) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.sex = sex;
        this.age = age;
        this.mother = mother;
        this.father = father;
        this.siblings = siblings;
        this.children = children;
        this.pets = pets;
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

    public String getSex() {
        return sex;
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


    public void addParents(Person father, Person mother) {
        this.mother = mother;
        this.father = father;
    }

    public void addChild(Person child) {
        if(!getChildren().contains(child)) {
            this.children.add(child);
        }

        if(this.sex.equalsIgnoreCase("male")) {
            child.setFather(this);
        }

        if(this.sex.equalsIgnoreCase("female")) {
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

    public void increaseAge() {
        age++;
    }
}
