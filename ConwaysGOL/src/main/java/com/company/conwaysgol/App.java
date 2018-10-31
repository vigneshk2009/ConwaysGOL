package com.company.conwaysgol;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;


public class App 
{

	public static void main( String[] args )
    {
    	
    	ConwaysGOLValidator conwaysGOLValidator = new ConwaysGOLValidator();
    	try {
    		FileReader file =  new FileReader(new File("input.txt"));
    		BufferedReader bufferedReader = new BufferedReader(file);
    		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt")));
    		
    		int gridSize = Integer.parseInt(bufferedReader.readLine());
    		int generationValue = Integer.parseInt(bufferedReader.readLine());
    		int[][] initialGrid = new int[gridSize][gridSize];
    		
    		String inputValue;
    		List<String> aliveList;
    		
    		/**
    		 * Read the initial alive nodes from the input file
    		 */
    		while((inputValue = bufferedReader.readLine()) != null) {
    			String coordinates[] = inputValue.split(",");
    			if (coordinates.length != 2) {
    				continue;
    			}
    			
    			initialGrid[Integer.parseInt(coordinates[0])][Integer.parseInt(coordinates[1])] = 1;
    		}
    		bufferedReader.close();
    		
    		
    		conwaysGOLValidator.setGrid(initialGrid);
    		conwaysGOLValidator.setGridSize(gridSize);
    		
    		/**
    		 * Loop the required number of generations
    		 */
    		for (int generationCounter = 0; generationCounter < generationValue; generationCounter++) {
    		
    			/**
    			 * Apply the conways game of life rule and generate new alive nodes
    			 */
    			conwaysGOLValidator.validateConwaysRule();
    			
    			/**
    			 * Cache the alive nodes after each generation so the we can print the 
    			 * same to the putput file
    			 */
    			aliveList = conwaysGOLValidator.getAliveList();
    			bufferedWriter.append(generationCounter + ": ");
    			for (String alive : aliveList) {
    				bufferedWriter.append("[" + alive + "]");
    			}
    			bufferedWriter.append("\n");
    		} // End generation loop
    		
    		/**
    		 * close the output buffer
    		 */
    		bufferedWriter.flush();
    		bufferedWriter.close();
     	} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    } // End of main
} // End APP class
