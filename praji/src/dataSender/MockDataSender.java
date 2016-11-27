package dataSender;

import java.util.Collections;
import java.util.List;

public class MockDataSender implements DataSender {

	@Override
	public <T extends Comparable<? super T>> void persist(List<T> data) {
		Collections.sort(data);
		for (Object d : data) {
			System.out.println(d);
		}
		System.out.println();
	}

}
