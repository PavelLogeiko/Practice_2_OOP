package MyPet;

public class MyDog extends Animal implements Winner {

    private MyHouse room;

    public MyDog(String name, int satiety){
        super (name, satiety);
        this.room = MyHouse.livingroom;
    }
    public void goRoom(MyHouse room) {
        System.out.println(this.name + " ушел в " + room);
        if (this.satiety > 0) this.satiety--;
        this.room = room;
    }

    public String getRoom() {
        return room.toString();
    }

    public String getSatiety(){
        if (this.satiety == 2) return "сыт";
        else if (this.satiety == 1) return "немного голоден";
        else return "сильно голоден";
    }

    @Override
    public String toString(){
        return this.name + " находится в " + this.room + " и " + getSatiety();
    }

    public String tryCall(MyPerson person){
        if (person.getRoom() == this.getRoom()) return this.name + " лает";
        return null;
    }

    public String eat(MyPerson person){
        if (person.getRoom() == this.getRoom()){
            if (this.satiety < 2) {
                this.satiety = 2;
                return this.name + " поел и теперь сыт";
            }
            else return this.name + " уже сыт";
        }
        else return this.name + " находится в другой комнате";
    }
    // имплементация интерфейса Winner
    @Override
    public void win() {
        System.out.println("побеждал на собачьих выставках, дважды получал медали за 1-е место !!!");
    }
}