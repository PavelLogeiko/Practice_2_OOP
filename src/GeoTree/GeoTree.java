package GeoTree;

import java.util.ArrayList;

public class GeoTree {

    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void append(Person person1, Relationship rs1, Person person2, Relationship rs2) {
        tree.add (new Node(person1, rs1, person2));
        tree.add (new Node(person2, rs2, person1));
    }
}