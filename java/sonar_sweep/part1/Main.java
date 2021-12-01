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
        int deepest = depths.get(0);
        for (int depth : depths) {
            if (depth > deepest)
                larger++;
            deepest = depth;
        }

        System.out.println(larger);
    }
}
