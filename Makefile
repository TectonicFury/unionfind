all: clean Percolation

clean:
	rm -f Percolation.class

Percolation:
	javac-algs4 Percolation.java
	java-algs4 Percolation


