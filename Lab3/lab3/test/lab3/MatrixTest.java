package lab3;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class MatrixTest {
//    @org.junit.Test
//    public void print_() throws Exception {
//        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
//        String diff = "1.0 2.0 \n 3.0 4.0";
//        assertEquals(diff, print_(a));
//
//
//    }
//
//    @org.junit.Test
//    public void print_1() throws Exception {
//    }
    @org.junit.Test
    public void Matrix() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4,5}});
        assertEquals(a.rows, 2);
        assertEquals(a.cols, 3);
        Matrix b = new Matrix (3,3);
        double [][] c = new double[a.rows][a.cols];
        c=b.asArray();
        assertEquals(b.rows*b.cols,c.length*c[0].length );
        for (int i = 0; i < b.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                assertEquals(b.get(i, j), 0,0.1);
            }
        }

    }


    @org.junit.Test
    public void asArray() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        double[][] nowa = new double[][]{{1,2},{3,4}};
        assertEquals(a.asArray(), nowa);
    }

    @org.junit.Test
    public void get() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        double result = 1;
        assertEquals(1.0, a.get(0,0), 0.1);
    }

    @org.junit.Test
    public void set() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        a.set(1, 1,10);
        assertEquals(10.0, a.get(1,1), 0.1);
    }


    @org.junit.Test
    public void testToString() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        String result = "[{1.0 2.0 }{3.0 4.0 }]";
        assertEquals(result, a.toString());
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void reshape() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        a.reshape(2,3);


    }

    @org.junit.Test
    public void shape() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,6},{2,4,1}});
        int[] tab = new int [2];
        tab[0]=2;
        tab[1]=3;
        assertEquals(tab[0], a.shape()[0]);
        assertEquals(tab[1], a.shape()[1]);
    }

    @org.junit.Test
    public void add() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix b = new Matrix(new double[][]{{0,5},{2,-4}});
        Matrix c = new Matrix(new double[][]{{1,7},{5,0}});
        Matrix d = a.add(b);
        for (int i=0; i<a.rows; i++)
        {
            for (int j=0; j<a.cols; j++)
            {
                assertEquals(d.get(i,j),c.get(i,j),1e-5);
            }
        }

    }

    @org.junit.Test
    public void sub() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix b = new Matrix(new double[][]{{0,5},{2,-4}});
        Matrix c = new Matrix(new double[][]{{1,-3},{1,8}});
        Matrix d = a.sub(b);
        for (int i=0; i<a.rows; i++)
        {
            for (int j=0; j<a.cols; j++)
            {
                assertEquals(d.get(i,j),c.get(i,j),1e-5);
            }
        }
    }

    @org.junit.Test
    public void mul() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix b = new Matrix(new double[][]{{0,5},{2,-4}});
        Matrix c = new Matrix(new double[][]{{0,10},{6,-16}});
        Matrix d = a.mul(b);
        for (int i=0; i<a.rows; i++)
        {
            for (int j=0; j<a.cols; j++)
            {
                assertEquals(d.get(i,j),c.get(i,j),1e-5);
            }
        }
    }

    @org.junit.Test
    public void add1() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix b = new Matrix(new double[][]{{3,4},{5,6}});

        Matrix d = a.add(2);
        for (int i=0; i<a.rows; i++)
        {
            for (int j=0; j<a.cols; j++)
            {
                assertEquals(d.get(i,j),b.get(i,j),1e-5);
            }
        }
    }

    @org.junit.Test
    public void sub1() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix b = new Matrix(new double[][]{{-1,0},{1,2}});

        Matrix d = a.sub(2);
        for (int i=0; i<a.rows; i++)
        {
            for (int j=0; j<a.cols; j++)
            {
                assertEquals(d.get(i,j),b.get(i,j),1e-5);
            }
        }
    }


    @org.junit.Test
    public void mul1() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix b = new Matrix(new double[][]{{2,4},{6,8}});

        Matrix d = a.mul(2);
        for (int i=0; i<a.rows; i++)
        {
            for (int j=0; j<a.cols; j++)
            {
                assertEquals(d.get(i,j),b.get(i,j),1e-5);
            }
        }
    }

    @org.junit.Test
    public void div() throws Exception {
        Matrix a = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix b = new Matrix(new double[][]{{0.5,1},{1.5,2}});

        Matrix d = a.div(2);
        for (int i=0; i<a.rows; i++)
        {
            for (int j=0; j<a.cols; j++)
            {
                assertEquals(d.get(i,j),b.get(i,j),1e-5);
            }
        }
    }

    @org.junit.Test
    public void dot() throws Exception {
        Matrix a = new Matrix(new double[][]{{1, 2, 1}, {1, 1, 1}});
        Matrix b = new Matrix(new double[][]{{1, 2}, {1, 1}, {1, 1}});
        Matrix c = new Matrix(new double[][]{{4,5},{3,4}});

        Matrix d = a.dot(b);
        for (int i=0; i<a.rows; i++)
        {
            for (int j=0; j<b.cols; j++)
            {
                assertEquals(d.get(i,j),c.get(i,j),1e-5);
            }
        }
    }

    @org.junit.Test
    public void frobenius() throws Exception {
        Matrix a = new Matrix(new double[][]{{1, 2, 1}, {1, 1, 1}});
        double sum = 9;
        assertEquals(a.frobenius(), sum, 1e-5);
    }

    @org.junit.Test
    public void main() throws Exception {
    }

    //////////////////// GRUPA D //////////////////////////////////////
    @org.junit.Test
    public void max() throws Exception {
        Random random = new Random();
        int m =random.nextInt(100)+1;
        int n=random.nextInt(100)+1;
        double[][] d = new double[m][n];
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
                d[i][j]=10*random.nextDouble()-5;
        }
        Matrix ma = new Matrix(d);
        Matrix max = ma.max(1);
        for (int r=0; r<m; r++)
        {
            Arrays.sort(d[r]);
            assertEquals(d[r][n-1],max.get(r,0), 1e-5 );
        }

    }
    /////////////////////////////////////////////////
}