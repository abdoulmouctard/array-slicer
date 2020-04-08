package lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author DIALLO Abdoul Mouctar <https://github.com/abdoulmouctard>
 * MIT LICENCE
 */
public class ArraySlicer {

    public Collection<Collection<?>> partition(Collection<?> collection, int sectionSize) {

        if (collection == null) return null;
        if (collection.isEmpty() || sectionSize <= 0) return Collections.emptyList();

        if (sectionSize >= collection.size()) {
            List<Collection<?>> result = new ArrayList<>();
            result.add(new ArrayList<>(collection));
            return result;
        }

        return compute(collectionToList(collection), sectionSize);
    }

    private Collection<Collection<?>> compute(List<?> list, int sectionSize) {
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
