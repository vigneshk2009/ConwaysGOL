# ConwaysGOL
Conways game of life problem

#Input
The input to this file is input.txt file that is placed under the project.
The first line in the input.txt file indicates the number of elements in the grid
The second line is the number of generations that needs to be printed
Rest of the lines will be initial alive nodes

Example:
10  ---> Matrix size
2   ---> Number of generations that needs to be performed
0,0  |
0,2  |
0,4  | ---> List of alive nodes
0,6  |
0,8  |

#Output:
The output of this problem is "output.txt" file that contains all the alive nodes after each iterartion.

Example:
0: [1, 1][1, 3][1, 5]
1: [1, 2][1, 4][2, 2][2, 4]