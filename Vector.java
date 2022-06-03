import java.io.Serializable;

public class Vector<T extends Number> implements Serializable {
	protected int dimension;
	Number[] vecArr;

	public Vector(T[] arr) {
		dimension = arr.length;
		setVector(arr);
	}

	public void setVector(T[] arr) {
		vecArr = new Number[arr.length];
		for (int i = 0; i < arr.length; i++)
			vecArr[i] = arr[i];
	}

	@SuppressWarnings("unchecked")
	public <E extends Number> Vector<Number> add(Vector<E> v) {
		if (!dimensionsEqual(v)) {
			System.out.println("Wrong dimension");
			return (Vector<Number>) this;
		} else {
			Number[] arr = new Number[dimension];
			for (int i = 0; i < dimension; i++) {
				arr[i] = vecArr[i].doubleValue() + v.vecArr[i].doubleValue();
				if (isInt((T) arr[i]))
					arr[i] = arr[i].intValue();
			}
			return new Vector<Number>(arr);
		}
	}

	@SuppressWarnings("unchecked")
	public <E extends Number> void multByScalar(E scalar) {
		for (int i = 0; i < vecArr.length; i++) {
			vecArr[i] = vecArr[i].doubleValue() * scalar.doubleValue();
			if (isInt((T) vecArr[i]))
				vecArr[i] = (Integer) vecArr[i];
		}
	}

	public <E extends Number> Number dotProd(Vector<E> v) {
		if (!dimensionsEqual(v)) {
			System.out.println("Wrong dimension");
			return null;
			// TODO: handle exception, can't return null ,lol..
		}
		Number result = 0.0D;
		for (int i = 0; i < dimension; i++)
			result = result.doubleValue() + vecArr[i].doubleValue() * v.vecArr[i].doubleValue();
		if (isInt(result))
			result = result.intValue();
		return result;
	}

	private <E extends Number> boolean dimensionsEqual(Vector<E> v) {
		if (dimension == v.dimension)
			return true;
		return false;
	}

	private boolean isInt(Number n) {
		if (n.doubleValue() == Math.floor(n.doubleValue()))
			return true;
		return false;
	}

	public String toString() {
		final var st = new StringBuffer();
		st.append("[");
		for (final var e : vecArr) {
			st.append(e);
			st.append(", ");
		}
		st.delete(st.length() - 2, st.length()); // delete the last ", "
		st.append("]");
		return st.toString();
	}
}
