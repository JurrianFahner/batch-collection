package nl.ensignprojects.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionUtils {

    /**
     * Splits the collection into lists with given batch size
     * @param collection to split in to batches
     * @param batchsize size of the batch
     * @param <T> it maintains the input type to output type
     * @return nested list
     */
    public static <T> List<List<T>> makeBatch(Collection<T> collection, int batchsize) {

        List<List<T>> totalArrayList = new ArrayList<>();
        List<T> tempItems = new ArrayList<>();

        Iterator<T> iterator = collection.iterator();

        for (int i = 0; i < collection.size(); i++) {
            tempItems.add(iterator.next());
            if ((i+1) % batchsize == 0) {
                totalArrayList.add(tempItems);
                tempItems = new ArrayList<>();
            }
        }

        if (tempItems.size() > 0) {
            totalArrayList.add(tempItems);
        }

        return totalArrayList;
    }

}
