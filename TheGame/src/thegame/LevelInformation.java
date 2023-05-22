

package thegame;

import java.util.ArrayList;

     //In this class exits all information about game like (number of strength ,number of lavel)
     //And the images of all levels and its reference image 
public class LevelInformation {
    
     //ArrayList for stored the information
    //the type of this ArrayList LevelRequirments (class)to can i store the image and the number of levels and the number of strength
    public static ArrayList<LevelRequirments> levelComponentsList;

    public LevelInformation(String strength) {
        levelComponentsList = new ArrayList<>();

        if (strength != null && strength.equals("easy")) {
            constructEasyLevels("pic/easy/");
        } else if (strength != null && strength.equals("medium")) {

            constructMediumLevels("pic/medium/");

        } else if (strength != null && strength.equals("hard")) {

            constructHardLevels("pic/hard");

        }

    }
                
           // Storing esay Strength
    private static void constructEasyLevels(String base) {
        levelComponentsList = new ArrayList<>();
        String[] iconsLevel0 = {base + "greenApple/1.jpg", base + "greenApple/2.jpg",
            base + "greenApple/3.jpg", base + "greenApple/4.jpg"};

        String[] iconsLevel1 = {base + "anab/1.jpg", base + "anab/2.jpg",
            base + "anab/3.jpg", base + "anab/4.jpg"};

        String[] iconsLevel2 = {base + "redApple/1.jpg", base + "redApple/2.jpg",
            base + "redApple/3.jpg", base + "redApple/4.jpg"};

        //Take an object from class LevelRequirments to dd 
        //We store the information in setter in class LevelRequirments and dd this to the Arraylist to save all information 
       
        LevelRequirments level0 = new LevelRequirments();
        level0.setDefaultIconPath(base + "greenApple/main.jpg");
        level0.setLevelNumber(0);
        level0.setDefaultSortedIconsArray(iconsLevel0);

        LevelRequirments level1 = new LevelRequirments();
        level1.setDefaultIconPath(base + "anab/main2.jpg");
        level1.setLevelNumber(1);
        level1.setDefaultSortedIconsArray(iconsLevel1);

        LevelRequirments level2 = new LevelRequirments();
        level2.setDefaultIconPath(base + "redApple/main3.jpg");
        level2.setLevelNumber(2);
        level2.setDefaultSortedIconsArray(iconsLevel2);
        levelComponentsList.add(level0);
        levelComponentsList.add(level1);
        levelComponentsList.add(level2);

    }
                // Storing medium Strength
    private static void constructMediumLevels(String base) {
        levelComponentsList = new ArrayList<>();

		String[] iconsLevel0 = { base + "butterfly/1.jpg", base + "butterfly/2.jpg", base + "butterfly/3.jpg",
				base + "butterfly/4.jpg", base + "butterfly/5.jpg", base + "butterfly/6.jpg",
				base + "butterfly/7.jpg", base + "butterfly/8.jpg", base + "butterfly/9.jpg" };
		
		String[] iconsLevel1 = { base + "cat/1.jpg", base + "cat/2.jpg", base + "cat/3.jpg",
				base + "cat/4.jpg", base + "cat/5.jpg", base + "cat/6.jpg",
				base + "cat/7.jpg", base + "cat/8.jpg", base + "cat/9.jpg" };
		
		String[] iconsLevel2 = { base + "flower/1.jpg", base + "flower/2.jpg", base + "flower/3.jpg",
				base + "flower/4.jpg", base + "flower/5.jpg", base + "flower/6.jpg",
				base + "flower/7.jpg", base + "flower/8.jpg", base + "flower/9.jpg" };
		
		String[] iconsLevel3 = { base + "duck/1.jpg", base + "duck/2.jpg", base + "duck/3.jpg",
				base + "duck/4.jpg", base + "duck/5.jpg", base + "duck/6.jpg",
				base + "/duck/7.jpg", base + "/duck/8.jpg", base + "/duck/9.jpg" };
		
		String[] iconsLevel4 = { base + "kaslan/1.jpg", base + "kaslan/2.jpg", base + "kaslan/3.jpg",
				base + "kaslan/4.jpg", base + "kaslan/5.jpg", base + "kaslan/6.jpg",
				base + "kaslan/7.jpg", base + "kaslan/8.jpg", base + "kaslan/9.jpg" };

      

		LevelRequirments level0 = new LevelRequirments();
		level0.setDefaultIconPath(base + "butterfly/main.jpg");
		level0.setLevelNumber(0);
		level0.setDefaultSortedIconsArray(iconsLevel0);

		LevelRequirments level1 = new LevelRequirments();
		level1.setDefaultIconPath(base + "cat/main.jpg");
		level1.setLevelNumber(1);
		level1.setDefaultSortedIconsArray(iconsLevel1);

		LevelRequirments level2 = new LevelRequirments();
		level2.setDefaultIconPath(base + "flower/main.jpg");
		level2.setLevelNumber(2);
		level2.setDefaultSortedIconsArray(iconsLevel2);

		LevelRequirments level3 = new LevelRequirments();
		level3.setDefaultIconPath(base + "duck/main.jpg");
		level3.setLevelNumber(3);
		level3.setDefaultSortedIconsArray(iconsLevel3);

		LevelRequirments level4 = new LevelRequirments();
		level4.setDefaultIconPath(base + "kaslan/main.jpg");
		level4.setLevelNumber(4);
		level4.setDefaultSortedIconsArray(iconsLevel4);
        
        
        levelComponentsList.add(level0);
        levelComponentsList.add(level1);
        levelComponentsList.add(level2);
        levelComponentsList.add(level3);
        levelComponentsList.add(level4);


    }
              // Storing hard Strength
    private static void constructHardLevels(String base) {
        levelComponentsList = new ArrayList<>();

        String[] iconsLevel0 = {base + "/blackFlower/1.jpg", base + "/blackFlower/2.jpg",
            base + "/blackFlower/3.jpg", base + "/blackFlower/4.jpg",
            base + "/blackFlower/5.jpg", base + "/blackFlower/6.jpg", base + "/blackFlower/7.jpg",
            base + "/blackFlower/8.jpg", base + "/blackFlower/9.jpg", base + "/blackFlower/10.jpg",
            base + "/blackFlower/11.jpg", base + "/blackFlower/12.jpg"};
        
        String[] iconsLevel1 = {base + "/bottle/1.jpg", base + "/bottle/2.jpg",
                base + "/bottle/3.jpg", base + "/bottle/4.jpg",
                base + "/bottle/5.jpg", base + "/bottle/6.jpg", base + "/bottle/7.jpg",
                base + "/bottle/8.jpg", base + "/bottle/9.jpg", base + "/bottle/10.jpg",
                base + "/bottle/11.jpg", base + "/bottle/12.jpg"};
        
        String[] iconsLevel2 = {base + "/java/1.jpg", base + "/java/2.jpg",
                base + "/java/3.jpg", base + "/java/4.jpg",
                base + "/java/5.jpg", base + "/java/6.jpg", base + "/java/7.jpg",
                base + "/java/8.jpg", base + "/java/9.jpg", base + "/java/10.jpg",
                base + "/java/11.jpg", base + "/java/12.jpg"};
        
        
        String[] iconsLevel3 = {base + "/road/1.jpg", base + "/road/2.jpg",
                base + "/road/3.jpg", base + "/road/4.jpg",
                base + "/road/5.jpg", base + "/road/6.jpg", base + "/road/7.jpg",
                base + "/road/8.jpg", base + "/road/9.jpg", base + "/road/10.jpg",
                base + "/road/11.jpg", base + "/road/12.jpg"};
        
        String[] iconsLevel4 = {base + "/smoke/1.jpg", base + "/smoke/2.jpg",
                base + "/smoke/3.jpg", base + "/smoke/4.jpg",
                base + "/smoke/5.jpg", base + "/smoke/6.jpg", base + "/smoke/7.jpg",
                base + "/smoke/8.jpg", base + "/smoke/9.jpg", base + "/smoke/10.jpg",
                base + "/smoke/11.jpg", base + "/smoke/12.jpg"};

      
        
        
        
        LevelRequirments level0 = new LevelRequirments();
        level0.setDefaultIconPath(base + "/blackFlower/main.jpg");
        level0.setLevelNumber(0);
        level0.setDefaultSortedIconsArray(iconsLevel0);
        
        LevelRequirments level1 = new LevelRequirments();
        level1.setDefaultIconPath(base + "/bottle/main.jpg");
        level1.setLevelNumber(1);
        level1.setDefaultSortedIconsArray(iconsLevel1);
        
        LevelRequirments level2 = new LevelRequirments();
        level2.setDefaultIconPath(base + "/java/main.jpg");
        level2.setLevelNumber(2);
        level2.setDefaultSortedIconsArray(iconsLevel2);
        
        LevelRequirments level3 = new LevelRequirments();
        level3.setDefaultIconPath(base + "/road/main.jpg");
        level3.setLevelNumber(3);
        level3.setDefaultSortedIconsArray(iconsLevel3);
        
        LevelRequirments level4 = new LevelRequirments();
        level4.setDefaultIconPath(base + "/smoke/main.jpg");
        level4.setLevelNumber(4);
        level4.setDefaultSortedIconsArray(iconsLevel4);
        
        levelComponentsList.add(level0);
        levelComponentsList.add(level1);
        levelComponentsList.add(level2);
        levelComponentsList.add(level3);
        levelComponentsList.add(level4);


    }

    public LevelRequirments getLevelById(int levelId) {
        return levelComponentsList.get(levelId);
    }

}
