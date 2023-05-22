

package thegame;

    //This class to set in it the information and save it in ArrayList in LevelInformation class 
public class LevelRequirments {
    
    private String []defaultSortedIconsArray;   //the correct arrangement for intermittent pictures
    private int levelNumber;
    private String defaultIconPath;         //the reference image
	
	public LevelRequirments() {
		super();
	}
	
	
	public LevelRequirments(String[] defaultSortedIconsArray, int levelNumber, String defaultIconPath) {
		super();
		this.defaultSortedIconsArray = defaultSortedIconsArray;
		this.levelNumber = levelNumber;
		this.defaultIconPath = defaultIconPath;
	}

               //  setter and getter for defaultSortedArray and levelNumber and the finalImage
	public String[] getDefaultSortedIconsArray() {
		return defaultSortedIconsArray;
	}
	public void setDefaultSortedIconsArray(String[] defaultSortedIconsArray) {
		this.defaultSortedIconsArray = defaultSortedIconsArray;
	}
	public int getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	public String getDefaultIconPath() {
		return defaultIconPath;
	}
	public void setDefaultIconPath(String defaultIconPath) {
		this.defaultIconPath = defaultIconPath;
	}
	

	
}
