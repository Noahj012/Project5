import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;



public class CalculateHammingDistance 
{
	private int[] node;
	private ArrayList<String> stationList = new ArrayList<String>();
	protected TreeSet<String> hd1Set, hd2Set, hd3Set, hd4Set;	
	
	public int calculatingHammingDstance(Object x, String y)
	{
		// keeps track of the different letters in the two stations code
		int diffCount = 0;

		//loops through the two given string codes letter by letter and incraments tje differences between them
		for (int i = 0; i < 4; ++i)
		{
			if (x.toString().charAt(i) != y.charAt(i))
			{
				++diffCount;
			}
		}
		
		return diffCount;
	}
	
	public void calculateNode(Object station1)
	{
		// declares two variables to keep track of the hamming distances of the stations code
		int diffCount = 0;
		node = new int[5];
		hd1Set = new TreeSet<String>();
		hd2Set = new TreeSet<String>();
		hd3Set = new TreeSet<String>();
		hd4Set = new TreeSet<String>();
		//loops through the remaining 119 station codes
		for (int i = 0; i < stationList.size(); ++i)
		{
			// this compares the current station code to the inputed stations codes from the constructor to calculate the hamming dist
			
			diffCount = calculatingHammingDstance(station1,stationList.get(i));
			

			// a layered if else statement to incrament the correct array index to keep track of the node distances
			if (diffCount == 0)
			{
				++node[0];
			}
			if (diffCount == 1)
			{
				++node[1];
				hd1Set.add(stationList.get(i));

			}
			if (diffCount == 2)
			{
				++node[2];
				hd2Set.add(stationList.get(i));
			}
			if (diffCount == 3)
			{
				++node[3];
				hd3Set.add(stationList.get(i));
			}
			if (diffCount == 4)
			{
				++node[4];
				hd4Set.add(stationList.get(i));
			}

			diffCount = 0;
			
		}

	}
	
	public void readFile (String filename) throws IOException
	{
		//Declares buffered reader object to read the Mesonet.txt file
		BufferedReader br = new BufferedReader(new FileReader(filename));

		//stores the 4th line of the Mesonet.txt file into a string
		filename = br.readLine();

		//this loops through the Mesonet.txt file and extracts the stations codes into the stationsCodes ArrayList
		while(!(filename == null))
		{
			stationList.add(filename);
			filename = br.readLine();
		}
		br.close();
	}
	
	public ArrayList<String> getStationList()
	{
		return stationList;
	}
	
	public int[] getNodeDistance()
	{
		return node;
	}
}
