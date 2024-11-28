package PlayerTypes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SmallForwards {
	
	String name;
	int age;
	static long power;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public static long getPower() {
		return power;
	}


	public void setPower(long power) {
		this.power = power;
	}


	public SmallForwards(String name, int age, long power) {
		this.name = name;
		this.age = age;
		this.power = power; 
		// TODO Auto-generated constructor stub
	}
	
	
	
    public static void main(String[] args) {
        String path = "playerpositionSF.txt";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             BufferedWriter powers = new BufferedWriter(new FileWriter("powersOfSF.txt"))) {

            Random random = new Random();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                double pts = Double.parseDouble(values[29]);
                double ast = Double.parseDouble(values[24]);
                double trb = Double.parseDouble(values[23]);
                double blk = Double.parseDouble(values[26]);
                double stl = Double.parseDouble(values[25]);

                double ptsRandom = pts + random.nextInt(11) - 5; // Random number in [pts-5, pts+5]
                double astRandom = ast + random.nextInt(11) - 5;
                double trbRandom = trb + random.nextInt(11) - 5;
                double blkRandom = blk + random.nextInt(11) - 5;
                double stlRandom = stl + random.nextInt(11) - 5;

                power = Math.round(ptsRandom * (2.5 / 10) + astRandom * (2.0 / 10) + trbRandom * (1.0 / 10) + blkRandom * (2.5 / 10) + stlRandom * (2.0 / 10));
                
                if (power<0) {
					power = 0;
				}

                powers.write(values[1] + ", " + power);
                powers.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
