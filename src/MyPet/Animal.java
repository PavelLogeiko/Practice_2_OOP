// добавлен абстрактный класс Animal для наследования некоторых параметров в MyDog

package MyPet;

public abstract class Animal { // абстрактный класс создается с помощью ключевого слова abstract
    public String name;

    public int satiety;

    public Animal(String name, int satiety) {
        this.name = name;
        this.satiety = 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}