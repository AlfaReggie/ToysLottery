import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public Lottery() {
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toy_Id, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toy_Id) {
                toy.setWeight(weight);
                return;
            }
        }
    }

    public void startLottery() {
        Random random = new Random();

        while (!toys.isEmpty()) {
            int totalWeight = 0;

            for (Toy toy : toys) {
                totalWeight += toy.getWeight();
            }

            int randomNumber = random.nextInt(totalWeight);
            int currentWeight = 0;

            for (int i = 0; i < toys.size(); i++) {
                currentWeight += toys.get(i).getWeight();

                if (randomNumber < currentWeight) {
                    Toy prizeToy = toys.remove(i);
                    prizeToys.add(prizeToy);
                    break;
                }
            }
        }
    }

    public void getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);

            try (FileWriter writer = new FileWriter("output_toy.txt", true)) {
                writer.write(prizeToy.toString() + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }

            prizeToy.decreaseQuantity();
        }
    }
}
