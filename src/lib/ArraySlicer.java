package lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArraySlicer {

    public Collection<Collection<?>> partition(Collection<?> collection, int sectionSize) {

        if (collection == null) return null;
        if (collection.isEmpty() || sectionSize <= 0) return Collections.emptyList();

        return compute(sectionSize, collectionToList(collection));
    }

    private Collection<Collection<?>> compute(int sectionSize, List<?> list) {
        List<Collection<?>> result = new ArrayList<>();
        int numberOfPeaces = list.size() / sectionSize + (list.size() % sectionSize == 0 ? 0 : 1);

        int begin, end;

        for (int index = 0; index < numberOfPeaces; index++) {
            begin = index * sectionSize;
            end = (index + 1) * sectionSize;
            result.add(list.subList(begin, Math.min(end, list.size())));
        }

        return result;
    }


    private List<?> collectionToList(Collection<?> collection) {
        if (collection instanceof List) return (List<?>) collection;
        return new ArrayList<>(collection);
    }

}
