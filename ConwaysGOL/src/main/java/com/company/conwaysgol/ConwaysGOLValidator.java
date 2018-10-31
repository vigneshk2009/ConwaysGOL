package com.company.conwaysgol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vignesh
 * This class contains all the data related to Conway's game of life related data
 * It also contains function to apply conway's GOL rule on each node. 
 * It maintains a List<String> which holds all the alive nodes at the current generation
 * After each generation the grid values are updated with new grid values
 */
public class ConwaysGOLValidator {

	private int grid[][];
	
	private List<String> aliveList;

	private int gridSize;
	
	public List<String> getAliveList() {
		return aliveList;
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setAliveList(List<String> aliveList) {
		this.aliveList = aliveList;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	public int getGridSize() {
		return gridSize;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	/**
	 * Decides if the given node gets to be alive or die
	 */
	private int isNodeAlive(int x, int y) {
		
		int aliveCount = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == x && j == y) {
					continue;
				}
				
				aliveCount += this.grid[x + i][y + j];
			}
		}
		if (aliveCount < 2 || aliveCount > 3) {
			return 0;
		} else {
			return 1;
		}
		
	}
	
	/**
	 * Validate each node in the grid against Conway's GOL rules
	 * Updates the grid value with the new values
	 * Updates the aliveList with new set of node values
	 */
	public void validateConwaysRule() {
		int newGrid[][] = new int[this.gridSize][this.gridSize];
		aliveList = new ArrayList<String>();
		newGrid = new int[gridSize][gridSize];
		for(int i = 1; i < gridSize - 1; i++) {
			for (int j = 1; j < gridSize - 1; j++) {
				newGrid[i][j] = isNodeAlive(i, j);
				if (newGrid[i][j] == 1) {
					aliveList.add(i + ", " + j);
				}
			}
		}
		this.grid = newGrid;
	}
	
}
