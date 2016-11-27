package util;

import java.util.NoSuchElementException;

public class CountingGraph<V> {

	int[][] adjMatrix;
	BiMap<V, Integer> vertices;
	int maxCapacity;
	int maxIndex;

	public CountingGraph(int maxCapacity) {
		adjMatrix = new int[maxCapacity][maxCapacity];
		maxIndex = -1;
		vertices = new BiMap<V, Integer>();
		this.maxCapacity = maxCapacity;
	}

	public void addVertice(V v) throws MaximumElementsInGraphException {
		if (!vertices.containsKey(v)) {
			if (maxIndex < maxCapacity) {
				vertices.put(v, ++maxIndex);
			} else {
				// TODO: treat exception
				throw new MaximumElementsInGraphException();
			}
		}
	}

	public void addEdge(V src, V dst) throws NoSuchElementException {
		if (!vertices.containsKey(src) || !vertices.containsKey(dst)) {
			throw new NoSuchElementException();
		}
		int srcIndex = vertices.get(src);
		int dstIndex = vertices.get(dst);
		adjMatrix[srcIndex][dstIndex]++;
	}
	
	public void addEdgeSpecial(V src, V dst) throws NoSuchElementException {
		if (!vertices.containsKey(src) || !vertices.containsKey(dst)) {
			throw new NoSuchElementException();
		}
		int srcIndex = vertices.get(src);
		int dstIndex = vertices.get(dst);
		adjMatrix[srcIndex][0]--; //0 means stolen
		adjMatrix[dstIndex][1]++; //1 means taken
		//negative and positive sign for easier recognision
	}
	
	public V getNodeWithHighestDegreeSpecial() {

		int maxDegree = 0;
		int maxDegreeNode = 0;
		for (int i = 0; i < maxIndex; i++) {
			if (adjMatrix[i][1] > maxDegree) {
				maxDegree = adjMatrix[i][1];
				maxDegreeNode = i;
			}
		}

		return vertices.getKey(maxDegreeNode);
	}
	
	public V getNodeWithLowestDegreeSpecial() {

		int minDegree = 0;
		int minDegreeNode = 0;
		for (int i = 0; i < maxIndex; i++) {
			if (adjMatrix[i][0] < minDegree) {
				minDegree = adjMatrix[i][0];
				minDegreeNode = i;
			}
		}

		return vertices.getKey(minDegreeNode);
	}

	public V getNodeWithHighestInDegree() {

		int maxInDegree = 0;
		int maxInDegreeNode = 0;
		for (int dst = 0; dst < maxIndex; dst++) {
			int inDegree = 0;
			for (int src = 0; src < maxIndex; src++) {
				inDegree += adjMatrix[src][dst];
			}
			if (inDegree > maxInDegree) {
				maxInDegree = inDegree;
				maxInDegreeNode = dst;
			}
		}

		return vertices.getKey(maxInDegreeNode);
	}

	public V getNodeWithHighestOutDegree() {

		int maxOutDegree = 0;
		int maxOutDegreeNode = 0;
		for (int src = 0; src < maxIndex; src++) {
			int outDegree = 0;
			for (int dst = 0; dst < maxIndex; dst++) {
				outDegree += adjMatrix[src][dst];
			}
			if (outDegree > maxOutDegree) {
				maxOutDegree = outDegree;
				maxOutDegreeNode = src;
			}
		}

		return vertices.getKey(maxOutDegreeNode);
	}

}
