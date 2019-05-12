package nl.ensignprojects.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CollectionUtils {

    /**
     * Splits the collection into lists with given batch size
     * @param collection to split in to batches
     * @param batchsize size of the batch
     * @param <T> it maintains the input type to output type
     * @return nested list
     */
    public static <T> List<List<T>> makeBatch(Collection<T> collection, int batchSize) {
        return makeBatch(collection.stream(), batchSize);
    }

    public static <T> List<List<T>> makeBatch(Stream<T> stream, int batchSize) {

        Supplier<List<List<T>>> supplier = () -> {
            List<List<T>> lists = new ArrayList<>();
            lists.add(new ArrayList<>());
            return lists;
        };

        BiConsumer<List<List<T>>, T> accumulator = (List<List<T>> a, T b) -> {
            if (a.get(a.size() - 1).size() < batchSize) {
                a.get(a.size() - 1).add(b);
            } else {
                ArrayList<T> ts = new ArrayList<>();
                ts.add(b);
                a.add(ts);
            }
        };


        return stream.collect(supplier, accumulator, List::addAll);

    }

}
