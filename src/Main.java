// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Lottery lottery = new Lottery();

        // Добавление игрушек
        lottery.addToy(new Toy(1, "Doll", 10, 20));
        lottery.addToy(new Toy(2, "Car", 5, 30));
        lottery.addToy(new Toy(3, "Puzzle", 8, 15));

        // Изменение веса игрушки
        lottery.updateToyWeight(3, 60);

        // Запуск розыгрыша
        lottery.startLottery();

        // Получение призовой игрушки
        lottery.getPrizeToy();

        lottery.toString();
    }
}