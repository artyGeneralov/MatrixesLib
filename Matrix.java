
public class Matrix<T extends Number> {
	private int rows, columns;
	private Number[][] matrix;

	/* Constructors: */
	// zero-matrix constructor
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		setZeroMatrix();
	}

	// Generic array constructor
	public Matrix(T[][] matrix) throws Exception {
		if (!isValidArr(matrix))
			throw new Exception("Exception"); // TODO: exception ??
		this.rows = matrix.length;
		this.columns = matrix[0].length;
		setMatrix(matrix);
	}

	// Copy constructor
	@SuppressWarnings("unchecked")
	public Matrix(Matrix<T> other) {
		int rows = other.rows;
		int columns = other.columns;
		setMatrix((T[][]) other.matrix);
	}

	
	
	// Matrix addition
	@SuppressWarnings("hiding")
	public <E extends Number> Matrix<T> add(Matrix<E> m) throws Exception {
		if (m.rows != this.rows || m.columns != this.columns)
			throw new Exception("Exception"); //TODO: exception ??
		Number[][] resultArr = new Number[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				resultArr[i][j] = matrix[i][j].doubleValue() + m.matrix[i][j].doubleValue();
				if (matrix[i][j].doubleValue() - Math.floor(m.matrix[i][j].doubleValue()) == 0
						&& Math.floor(matrix[i][j].doubleValue()) - m.matrix[i][j].doubleValue() == 0)
					resultArr[i][j] = (Integer) resultArr[i][j].intValue();
			}
		}

		@SuppressWarnings("unchecked")
		Matrix<T> resultMat = new Matrix<T>((T[][]) resultArr);
		return resultMat;
	}

	
	// Matrix multiplication
	
	// Returns element by its index in the matrix
	@SuppressWarnings("unchecked")
	public T getElementAtIndex(int row, int col) {
		final T t = (T) matrix[row][col];
		return t;
	}

	public void setMatrix(T[][] m) {
		if (isValidArr(m)) {
			this.matrix = new Number[m.length][m[0].length];
			for (int i = 0; i < rows; i++)
				for (int k = 0; k < columns; k++)
					matrix[i][k] = m[i][k];
		}
	}

	@SuppressWarnings("unchecked")
	public String toString() {
		String s = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				s += (T) matrix[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}

	/* Private Methods::: */

	// Check if an array is valid (every row has the same amount of columns.
	private boolean isValidArr(T[][] arr) {
		int previous;
		previous = arr[0].length;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].length != previous)
				return false;
			previous = arr[i].length;
		}
		return true;
	}

	private void setZeroMatrix() {
		this.matrix = new Number[rows][columns];
		for (int i = 0; i < rows; i++)
			for (int l = 0; l < columns; l++)
				matrix[i][l] = 0;
	}

}
