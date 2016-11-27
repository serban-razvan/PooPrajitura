package dataSender;

import java.util.List;

public interface DataSender {

	<T extends Comparable<? super T>> void persist(List<T> data);

}
