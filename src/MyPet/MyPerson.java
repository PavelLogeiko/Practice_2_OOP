package MyPet;

public class MyPerson {
    private String name;
    private MyHouse room;

    public MyPerson(String name){
        this.name = name;
        this.room = MyHouse.livingroom;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void goRoom(MyHouse room) {
        System.out.println(this.name + " ушел в " + room);
        this.room = room;
    }

    public String getRoom() {
        return room.toString();
    }

    @Override
    public String toString(){
        return this.name + " находится в " + this.room;
    }

    public void call(MyDog dog){
        System.out.print(this.name + " зовет собаку -> ");
        if (dog.tryCall(this) != null) System.out.println(dog.tryCall(this));
        else System.out.printf("%s не слышит, так как находится в другой комнате \n", dog.getName());
    }

    public void feed(MyDog dog){
        System.out.print(this.name + " пытается покормить " + dog.getName() + " -> ");
        System.out.println(dog.eat(this));
    }
}