#Project 5 Documentation

This project is a culmination of the first 3 project done in CS 2334. It builds off the 
previously etstablished calculations of hamming distance and node distance, and then 
creating a GUI application tot reflect these calculations. I will now describe my problem
solving process.

My first problem was deciding how many classes to make to roganize my code in a meaningful
fashion. Ultimately deciding to create 2 classes in total, one being the 
CalculateHammingDistance class, which takes all the proccesses required in reading the 
mesonet.txt file, sorting the ids in natural ordering ,calculating the node and hamming
distance for the selected station Id. My second classed, GraphHamming was soley comprised 
of managment of the GUI interface. By seperating the functionality of this project has 
allowed my code to be more organized, readable, and consistent.

CalculateHammingDistance Class
	1) calculatingHammingDstance(x: Object, y: String): int
	This method takes in an object, and a string and computes the hamming distance, 
	which is then returned as a int, to allow, comparison later on in the node method.
	I kept this method simple to allow it to be called in future methods, adhearing 
	to dry therom, and to not clutter the code.

	2) calculateNode(station: Object): void
	This method computes the node value of a given station, by comparing to the 
	remaining station Ids. Accomplished by calling the calcHamm method with in this 
	method, and storing the given results an organized array according to hammingDist
	
	3)readFile(filename: String): void
	reads the Mesonet.txt file and stores the stations ids in an ArrayList, later to 
	be sorted into organized TreeSets

	4) getter methods
	getStationList - allows encapsilation, and allows the data to be shared between
	the 2 classes
	getNodeDistance - allows encapsilation, and allows the data to be shared between
	the 2 classes

GraphHamming
	1) GraphHamming()
	the constructor that calls all the initialization methods and adds all components
	to the apporpriate panel, and adds the panels in the correct order to the frame
	
	2) Initialization methods
		*setPanels - intializes all panels declared as class fields
		*setHammDisDisplay - intializes all labels used for displaying calcHD results
		*setCombBox - intializes the combox, and sets it display to the originl 120
			station Ids.
		*setTextfields - intializes all textfields and sets the to not be editable
			so they will only be used for display
		*setFrame - intializes the main frame
		*setSlider - intializes the slider, and adds a changelistener to alter the
				displayed hamming distance

	3)setButtons - intializes all buttons, but is also where I add the action listeners
		*CalcHDButton - sets the text field according to the data calculated in 
		the calculateHammingDistance class
		*showStationButton - gets the appropriate treeSet from calcHammingDist class
		based on the number displayed from the slider, and updates the Jlist to show
		the data form the treeSet
		*colorPickerButton - opens a window pane to choose the different colors for 
		the background.