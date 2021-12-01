import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static ArrayList<Integer> getDepthMeasurements() {
        Path path = Paths.get("../../../assets/depths.txt");
        try {
            String str = new String(Files.readAllBytes(path));
            String[] split = str.split("\n");
            return (ArrayList<Integer>) Arrays.stream(split).sequential().map(Integer::parseInt).collect(Collectors.toList());
        } catch (IOException ignored) {

        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ArrayList<Integer> depths = getDepthMeasurements();

        long larger = 0;
        int deepest = depths.get(0) + depths.get(1) + depths.get(2);
        for (int i = 3; i < depths.size(); i++) {
            int sum = depths.get(i - 2) + depths.get(i - 1) + depths.get(i);
            if (sum > deepest)
                larger++;
            deepest = sum;
        }

        System.out.println(larger);
    }
}
