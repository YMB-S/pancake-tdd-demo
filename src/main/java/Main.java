import Chefs.BurntPancakeChef;
import Chefs.IChef;
import Chefs.PancakeChef;
import Chefs.PizzaChef;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        while(true){
            Random random = new Random();

            IChef chef = null;

            int chefNumber = random.nextInt(0, 3);

            switch(chefNumber){
                case 0:
                    chef = new PancakeChef();
                    break;
                case 1:
                    chef = new BurntPancakeChef();
                    break;
                case 2:
                    chef = new PizzaChef();
                    break;

                default:
                    chef = new PancakeChef();
            }

            try{
                System.out.println("\n\n\n\n");
                System.out.println("-----------");
                System.out.println("-CHEF DEMO-");
                System.out.println("-----------");
                System.out.println("Using Chef: " + chef.getClass());
                Thread.sleep(1000);
                chef.prepare();

                System.out.println("\nPlate before sorting: " + chef.getPlate());
                Thread.sleep(4000);
                System.out.println("\n---\nPlate after sorting: " + chef.serveSorted());
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}