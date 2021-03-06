package Chapter17.Example;

import net.mindview.util.CountingGenerator;
import net.mindview.util.RandomGenerator;

import static net.mindview.util.Print.print;

/**
 * @author:YiMing
 * @create:2020/9/1,18:28
 * @version:1.0
 */
public class MapDataTest {
    public static void main(String[] args) {
        // Pair Generator:
        print(MapData.map(new Letters(), 11));
        // Two separate generators:
        print(MapData.map(new CountingGenerator.Character(),
                new RandomGenerator.String(3), 8));
        // A key Generator and a single value:
        print(MapData.map(new CountingGenerator.Character(),
                "Value", 6));
        // An Iterable and a value Generator:
        print(MapData.map(new Letters(),
                new RandomGenerator.String(3)));
        // An Iterable and a single value:
        print(MapData.map(new Letters(), "Pop"));
    }
}
