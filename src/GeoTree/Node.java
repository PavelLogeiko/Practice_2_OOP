package GeoTree;

public class Node {

    public Node (Person p1, Relationship rs, Person p2) {
        this.p1 = p1;
        this.rs = rs;
        this.p2 = p2;
    }

    Person p1;
    Relationship rs;
    Person p2;

    @Override
    public String toString(){
        return String.format("<%s %s %s>", p1, rs, p2);
    }
}