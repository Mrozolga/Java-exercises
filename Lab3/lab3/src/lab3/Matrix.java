package lab3;


public class Matrix {


    double[] data;
    int rows;
    int cols;

    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows * cols];
    }

    Matrix(double[][] d) {

        rows = d.length;
        int max = 0;
        for (int i = 0; i < rows; i++)
            if (d[i].length > max) max = d[i].length;
        cols = max;
        this.data = new double[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < d[i].length) {
                    this.data[i * cols + j] = d[i][j];
                } else {
                    this.data[i * cols + j] = 0;
                }
            }
        }
    }


    static void print_(Matrix m) {
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                System.out.print(m.data[i * m.cols + j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    static void print_1(int [] tab, int n)
    {
        for (int i=0; i<n; i++)
        {
            System.out.print(tab[i]);
            System.out.print("\n");
        }
    }


    double[][] asArray() {
        double[][] nowa = new double[rows][cols];
        int l = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                nowa[i][j] = this.data[l];
                l++;
            }
        }
        return nowa;
    }

    double get(int r, int c) {
        double[][] tab2;
        tab2 = this.asArray();
        return tab2[r][c];
    }

    void set(int r, int c, double value) {
        double[][] tab2;
        tab2 = this.asArray();
        tab2[r][c] = value;
        Matrix M1 = new Matrix(tab2);
        this.data = M1.data;

    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i = 0; i < rows; i++) {
            buf.append("{");
            for (int j = 0; j < cols; j++) {

                buf.append(this.get(i, j));
                buf.append(" ");
            }
            buf.append("}");

        }
        buf.append("]");
        return buf.toString();
    }

    void reshape(int newRows, int newCols) {
        if (rows * cols != newRows * newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d", rows, cols, newRows, newCols));

    }

    int[] shape() {
        int[] tab = new int[2];
        tab[0] = this.rows;
        tab[1] = this.cols;
        return tab;
    }
    Matrix add(Matrix m)
    {
        Matrix n = new Matrix(this.rows, this.cols);
        double[][] nowa1 = new double[rows][cols];
        double[][] nowa2 = new double[rows][cols];
        double[][] nowa3 = new double[rows][cols];
        nowa1 =n.asArray();
        nowa2 = this.asArray();
        nowa3 = m.asArray();
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++) {
                nowa1[i][j] = nowa2[i][j] + nowa3[i][j];
                n.data[i * n.cols + j]=nowa1[i][j];
            }
        }
        return n;

    }
    Matrix sub(Matrix m)
    {
        Matrix n = new Matrix(this.rows, this.cols);
        double[][] nowa1 = new double[rows][cols];
        double[][] nowa2 = new double[rows][cols];
        double[][] nowa3 = new double[rows][cols];
        nowa1 =n.asArray();
        nowa2 = this.asArray();
        nowa3 = m.asArray();
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++) {
                nowa1[i][j] = nowa2[i][j] - nowa3[i][j];
                n.data[i * n.cols + j]=nowa1[i][j];
            }
        }
        return n;

    }
    Matrix mul(Matrix m)
    {
        Matrix n = new Matrix(this.rows, this.cols);
        double[][] nowa1 = new double[rows][cols];
        double[][] nowa2 = new double[rows][cols];
        double[][] nowa3 = new double[rows][cols];
        nowa1 =n.asArray();
        nowa2 = this.asArray();
        nowa3 = m.asArray();
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++) {
                nowa1[i][j] = nowa2[i][j] * nowa3[i][j];
                n.data[i * n.cols + j]=nowa1[i][j];
            }
        }
        return n;

    }
    Matrix add(double m)
    {
        Matrix n = new Matrix(this.rows, this.cols);
        double[][] nowa1 = new double[rows][cols];
        double[][] nowa2 = new double[rows][cols];
        nowa1 =n.asArray();
        nowa2 = this.asArray();
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++) {
                nowa1[i][j] = nowa2[i][j] +m;
                n.data[i * n.cols + j]=nowa1[i][j];
            }
        }
        return n;

    }
    Matrix sub(double m)
    {
        Matrix n = new Matrix(this.rows, this.cols);
        double[][] nowa1 = new double[rows][cols];
        double[][] nowa2 = new double[rows][cols];
        nowa1 =n.asArray();
        nowa2 = this.asArray();
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++) {
                nowa1[i][j] = nowa2[i][j] - m;
                n.data[i * n.cols + j]=nowa1[i][j];
            }
        }
        return n;

    }
    Matrix mul(double m)
    {
        Matrix n = new Matrix(this.rows, this.cols);
        double[][] nowa1 = new double[rows][cols];
        double[][] nowa2 = new double[rows][cols];
        nowa1 =n.asArray();
        nowa2 = this.asArray();
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++) {
                nowa1[i][j] = nowa2[i][j]*m;
                n.data[i * n.cols + j]=nowa1[i][j];
            }
        }
        return n;

    }
    Matrix div(double m)
    {
        Matrix n = new Matrix(this.rows, this.cols);
        double[][] nowa1 = new double[rows][cols];
        double[][] nowa2 = new double[rows][cols];
        nowa1 =n.asArray();
        nowa2 = this.asArray();
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++) {
                nowa1[i][j] = nowa2[i][j]/m;
                n.data[i * n.cols + j]=nowa1[i][j];
            }
        }
        return n;

    }
    Matrix dot(Matrix m)
    {
        double a;
        Matrix n = new Matrix(this.rows, m.cols);
        double[][] nowa1 = new double[rows][cols];
        double[][] nowa2 = new double[rows][cols];
        double[][] nowa3 = new double[this.rows][m.cols];
        nowa1=this.asArray();
        nowa2=m.asArray();
        nowa3=n.asArray();
        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<m.cols; j++)
            {
                for (int k=0; k<this.cols; k++)
                {
                    nowa3[i][j]+=nowa1[i][k] * nowa2[k][j];
                    a=nowa3[i][j];

                }
                n.data[i * n.cols + j]=nowa3[i][j];
            }
        }
        return n;

    }
    double frobenius()
    {
        double suma=0;
        double[][] nowa1 = new double[rows][cols];
        nowa1=this.asArray();
        for (int i=0; i<this.rows; i++)
        {
            for(int j=0; j<this.cols; j++)
                suma+=nowa1[i][j]*nowa1[i][j];
        }
        return suma;
    }
    //////////////////GRUPA D
    Matrix max(int n)
    {
        Matrix a = new Matrix(0, 0);
        if (n==1)
        {
            Matrix m = new Matrix(this.rows, 1);
            double max=0;
            int l=0;
            for (int j=0; j<this.rows; j++)
            {
                for(int k=0; k<this.cols; k++)
                {
                    if(data[j*this.cols+k]>max) max=data[j*this.cols+k];
                }
                m.data[l]=max;
                max=0;
                l++;
            }
        return m;
        }
        if (n==0)
        {
            Matrix m = new Matrix(1, this.cols);
            double max=0;
            int l=0;
            for (int j=0; j<this.cols; j++)
            {
                for(int k=0; k<this.rows; k++)
                {
                    if(data[k*this.rows+j]>max) max=data[k*this.rows+j];
                }
                m.data[l]=max;
                max=0;
                l++;
            }
            return m;
        }
        if (n==-1)
        {
            Matrix m = new Matrix(1, 1);
            double max=0;

            for (int j=0; j<this.rows; j++)
            {
                for(int k=0; k<this.cols; k++)
                {
                    if(data[k*this.rows+j]>max) max=data[k*this.rows+j];
                }
            }
            m.data[0]=max;
            return m;
        }
        return a;
    }
    ////////////////////////////////////////////

    public static void main(String[] args) {
        double[][] d = {{1, 2, 1}, {1, 1, 1}, {1, 1, 1}};
        Matrix M = new Matrix(d);
        print_(M);
        M.asArray();
        print_(M);
        System.out.print(M.get(0, 1));
//        M.set(1, 1, 12);
        print_(M);
        System.out.print(M.toString());
        print_1(M.shape(), M.shape().length);
        double[][] e = {{1, 1, 1}, {1, 2, 1}, {1, 1, 1}};
        Matrix M1 = new Matrix(e);
        System.out.print((M.add(M1)).toString());
        System.out.print("\n");
        System.out.print((M.sub(M1)).toString());
        System.out.print("\n");
        System.out.print((M.mul(M1)).toString());
        System.out.print("\n");
        System.out.print((M.add(1.5)).toString());
        System.out.print("\n");
        System.out.print((M.sub(1.5)).toString());
        System.out.print("\n");
        System.out.print((M.mul(1.5)).toString());
        System.out.print("\n");
        System.out.print((M.div(1.5)).toString());
        System.out.print("\n");
        System.out.print((M.dot(M1)).toString());
        System.out.print("\n");
        double[][] d2 = {{1, 2, 1}, {1, 1, 1}};
        double[][] d3 = {{1, 2}, {1, 1}, {1, 1}};
        Matrix M2 = new Matrix(d2);
        Matrix M3 = new Matrix(d3);
        System.out.print((M2.dot(M3)).toString());
        System.out.print("\n");
        System.out.print(M2.frobenius());
        Matrix m = new Matrix(new double[][]{{1,2,3},{4,5,6},{7,8,9}});
        Matrix col = m.max(1);
        System.out.print(col.toString());


    }
}



