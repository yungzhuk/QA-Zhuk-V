package lesson3;

public class Park {

    public class Attractions {
        private String name;
        private String workTime;
        private int price;

        public Attractions(String name, String workTime, int price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Attractions{" +
                    "name='" + name + '\'' +
                    ", workTime='" + workTime + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    Attractions[] attractionsArray = new Attractions[4];

    {
        attractionsArray[0] = this.new Attractions("ferrisWheel", "10:00-23:00", 50);
        attractionsArray[1] = this.new Attractions("rollerCoaster", "10:00-22:00", 60);
        attractionsArray[2] = this.new Attractions("hauntedHouse", "11:00-21:00", 40);
        attractionsArray[3] = this.new Attractions("waterRide", "10:00-20:00", 45);
    }

    //метод для вывода аттракционов
    public void showAttractions() {
        for (Attractions a : attractionsArray) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        park.showAttractions();
    }
}



