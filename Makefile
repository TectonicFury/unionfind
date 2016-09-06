all: Percolation clean
        javac-algs4 Percolation.java PercolationStats.java
        java-algs4 PercolationStats 200 200

clean:
        rm -f *.class


