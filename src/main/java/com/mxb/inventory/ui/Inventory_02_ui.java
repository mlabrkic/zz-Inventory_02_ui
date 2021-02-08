
// #################################
// 08.10.2020.

// SikuliX, Java
// http://sikulix.com/
// http://sikulix.com/quickstart/
// https://answers.launchpad.net/sikuli

// SikuliX-IDE, Run
// C:\xxx\JDK\bin\java -jar C:\xxx\SIKULIX_IDE\sikulix-2.0.0.jar

// https://github.com/RaiMan/SikuliX1
// Source and target level for Java is version 8 as long as supported by Oracle

// ---------------------------------
// 1) SikuliX Documentation
// http://sikulix-2014.readthedocs.org/en/latest/index.html
// Be aware: The online javadocs are created from the latest nightly builds.

// Try the Table of Contents
// https://sikulix-2014.readthedocs.io/en/latest/toc.html

// Look through the Index
// https://sikulix-2014.readthedocs.io/en/latest/genindex.html

// Use the Search Page
// https://sikulix-2014.readthedocs.io/en/latest/search.html

// ---------------------------------
// 2) SikuliX Documentation (built-in class)
// Look through the Index:
// https://sikulix-2014.readthedocs.io/en/latest/genindex.html

// (built-in class) :
// https://sikulix-2014.readthedocs.io/en/latest/appclass.html#App
// https://sikulix-2014.readthedocs.io/en/latest/screen.html#Screen
// https://sikulix-2014.readthedocs.io/en/latest/pattern.html#Pattern
// https://sikulix-2014.readthedocs.io/en/latest/keys.html#Key
// https://sikulix-2014.readthedocs.io/en/latest/region.html#Region
// https://sikulix-2014.readthedocs.io/en/latest/match.html#Match

// https://sikulix-2014.readthedocs.io/en/latest/finder.html#Finder.find

// image-search-path
// https://sikulix-2014.readthedocs.io/en/latest/scripting.html#image-search-path-where-sikulix-looks-for-image-files

// FindFailed
// https://sikulix-2014.readthedocs.io/en/latest/region.html?highlight=FindFailed#exception-findfailed

// https://sikulix-2014.readthedocs.io/en/latest/region.html#extracting-text-from-a-region

// import org.sikuli.script.Pattern;   # SikuliX, Java

// ---------------------------------
// 3) SikuliX Documentation (other)

// https://sikulix-2014.readthedocs.io/en/latest/region.html#Region.findAll
// https://sikulix-2014.readthedocs.io/en/latest/match.html#iteratingmatches

// https://stackoverflow.com/questions/47467133/how-to-check-in-sikuli-that-image-is-exist-in-screen-or-not-and-perform-if-else
// Because that will return a "match" object.

// https://stackoverflow.com/questions/811851/how-do-i-read-input-character-by-character-in-java
// http://eugenesautomation.blogspot.com/2015/01/optimizing-pattern-matching-using-sikuli_21.html

// ---------------------------------
// 4) SikuliX issues

// SikuliX 2.0.2:  screen.Paste and Key. dont work
// https://github.com/RaiMan/SikuliX1/issues/305
// https://github.com/RaiMan/SikuliX1/issues/241
// As long as English (United States) is in my language list, it works fine.

// -->
// Settings.AutoDetectKeyboardLayout = false;

// ---------------------------------
// 5) QUICKSTART

// https://sikulix-2014.readthedocs.io/en/latest/faq/030-java-dev.html
// http://www.gofreetodream.com/java-sikulix-windows-mac/java-sikulix-example-on-windows-machine/
// https://javapointers.com/tutorial/sikuli/sikuli-java-tutorial-and-example/

// ---------------------------------
// 6) JAVA

// https://kodejava.org/how-do-i-load-file-from-resources-directory/
// https://www.geeksforgeeks.org/throw-throws-java/
//
// https://www.baeldung.com/java-current-directory
// Get the Current Working Directory in Java | Baeldung

// https://www.baeldung.com/java-system-exit
// System.exit(0);


// ---------------------------------
// 7) SikuliX OCR

// https://sikulix-2014.readthedocs.io/en/latest/textandocr.html#textandocr
// Simply start using the text/OCR features with Region or Image (see the summary below).

// https://github.com/RaiMan/SikuliX1/wiki/How-to-get-the-best-from-OCR-and-text-features

// https://github.com/tesseract-ocr/tesseract
// https://mvnrepository.com
// tess4j

// https://sikulix-2014.readthedocs.io/en/latest/region.html#extracting-text-from-a-region

// import org.sikuli.script.OCR;

// Settings.OcrDataPath = "C:\\xxx\\Tesseract-OCR\\tessdata\\";
// Settings.OcrTextSearch = true;
// Settings.OcrTextRead = true;
// OCR.PSM.SINGLE_WORD; !?

// ---------------------------------
// https://github.com/suniljayaprakash/sikuli-ocr/blob/master/com/nanni/ExtractTextFromImageSikuli.java
// https://github.com/sarxos/sikuli-ocr


// #################################


package com.mxb.inventory.ui;


import org.sikuli.basics.Settings;

// import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.sikuli.script.Pattern;
import org.sikuli.script.Key;

import org.sikuli.script.Region;
// import org.sikuli.script.Match;

import org.sikuli.script.FindFailed;

// ---------------------------------
// import org.sikuli.script.Finder;
// import org.sikuli.script.ImagePath;

// ---------------------------------
// import java.net.URISyntaxException;
// import java.net.URL;
// import java.net.MalformedURLException;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;

// import java.util.*;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Iterator;

// ---------------------------------


/**
 * Hello world!
 *
 */

public class Inventory_02_ui
{

    // private App myApp;

    private Screen scr;
    private String basePath;

    private String equipment;
    private String port;

    private String uiTemplate = "TEMPLATExxx";

    private Region r1Top_GenID;
    private Region r2Bottom;


    // constructor to initialize the variable
    // httpstom.mcqueeney.tech/blog/the-terribly-misunderstood-super/
    public Inventory_02_ui()
    {
        // General Settings and Access to Environment Information
        // https://sikulix-2014.readthedocs.io/en/latest/globals.html
        // Settings.AutoWaitTimeout = 2;  // (default 3 seconds)

        Settings.AutoDetectKeyboardLayout = false;
        Settings.AutoWaitTimeout  = 120;
        scr = new Screen(0);
        // scr.setAutoWaitTimeout(120);

        r1Top_GenID = new Region(0,0,1920,155);
        r2Bottom = new Region(0,939,1920,141);

        // https://www.baeldung.com/java-current-directory
        // Get the Current Working Directory in Java | Baeldung
        String currentWorkingDir = System.getProperty("user.dir");
        basePath = currentWorkingDir + "/images/";

    }


    // instance method
    private void startApp() throws FindFailed
    {
        m1MaximizeApp();

        m2OpenPath();
        m3Insert_EQ();
        m4SelectPort();
    }


    // instance method
    private void m1MaximizeApp() throws FindFailed
    {
        // Java 1.8
        // By default, float numbers are double in java.
        // In order to store them into float variable, you need to explicitly add the suffix 'f' or 'F'.
        // scr.wait(p3Search_For_Path.similar(0.7F));

        try {
            // INV app, Click on the icon
            // Pattern p1AppIcon = new Pattern("C:\\xxx\\INV_01_ikona.png");
            Pattern p1AppIcon = new Pattern(basePath + "p1AppIkona.png");
            r2Bottom.click(p1AppIcon.similar(0.8));

            // myApp = new App("Inventory");
            // myApp.focus();

            // INV app, Wait for it to open
            Pattern p2AppWait = new Pattern(basePath + "p2AppWait.png");
            r1Top_GenID.wait(p2AppWait.similar(0.8));

        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        }

    }


    // instance method
    private void m2OpenPath() throws FindFailed
    {

        try {
            // INV: Equipment - Slot/Card
            scr.type("o", Key.ALT);   // Menu - Object
            scr.wait(0.1);   // wait 0.1 seconds
            scr.type("p");   // Path

            // ---------------------------------
            Pattern p3Search_For_Path = new Pattern(basePath + "p3Search_For_Path.png");
            r1Top_GenID.wait(p3Search_For_Path.similar(0.7));
            System.out.println("found p3Search_For_Path");

            scr.type("a", Key.CTRL);   // Select All
            scr.wait(0.1);
            scr.type(Key.DELETE);

            scr.wait(0.5);
            scr.paste(uiTemplate);
            scr.type(Key.ENTER);

            // ---------------------------------
            Pattern p4SearchResults = new Pattern(basePath + "p4SearchResults.png");
            r1Top_GenID.wait(p4SearchResults.similar(0.7));
            System.out.println("found p4SearchResults");

            r1Top_GenID.doubleClick(p4SearchResults.similar(0.7).targetOffset(100, 57));

            // ---------------------------------
            r1Top_GenID.waitVanish(p4SearchResults.similar(0.7));

            Pattern p5ViewPath = new Pattern(basePath + "p5ViewPath.png");
            r1Top_GenID.wait(p5ViewPath.similar(0.7));
            System.out.println("found p5ViewPath");

            scr.type("m", Key.CTRL);   // Modify
            scr.wait(0.5);

            // ---------------------------------
            r1Top_GenID.waitVanish(p5ViewPath.similar(0.7));

            Pattern p6ModifyPath = new Pattern(basePath + "p6ModifyPath.png");
            r1Top_GenID.wait(p6ModifyPath.similar(0.7));
            System.out.println("found p6ModifyPath");

            // scr.wait(1.0);   // wait 1 second
            scr.wait(0.1);

            // ---------------------------------
            // INV: Equipment - Slot/Card
            scr.type("p", Key.ALT);   // Menu - Operations
            scr.wait(0.1);   // wait 0.1 seconds
            scr.type("w");   // Save As New

            // ---------------------------------
            Pattern p7New_UI_name = new Pattern(basePath + "p7New_UI_name.png");
            scr.wait(p7New_UI_name.similar(0.7));
            System.out.println("found p7New_UI_name");

            scr.type(Key.TAB);
            scr.wait(0.1);
            scr.type(Key.TAB);
            scr.wait(0.1);
            scr.type(Key.ENTER);
            scr.wait(0.1);

            // ---------------------------------
            scr.waitVanish(p7New_UI_name.similar(0.7));

            // ---------------------------------
            scr.wait(5.0);  // wait 5 seconds

        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Some other exception occured " + e.getMessage());
        }

    }


    // instance method
    private void m3Insert_EQ() throws FindFailed
    {

        try {
            // ---------------------------------
            scr.wait(0.1);
            Pattern p8Insert_EQ = new Pattern(basePath + "p8Insert_EQ.png");
            scr.click(p8Insert_EQ.similar(0.8).targetOffset(0,10));
            System.out.println("found p8Insert_EQ");

            scr.wait(0.5);
            scr.type(Key.DOWN);
            scr.wait(0.1);
            scr.type(Key.ENTER);
            scr.wait(0.1);

            // ---------------------------------
            Pattern p9SelectShelf = new Pattern(basePath + "p9SelectShelf.png");
            scr.wait(p9SelectShelf.similar(0.7));
            System.out.println("found p9SelectShelf");


            // #################################
            // if error, manually!!!
            scr.wait(2.0);   // wait 2 seconds

            scr.wait(1.0);
            scr.type(Key.PAGE_DOWN, Key.CTRL);  // in case of error comment
            scr.wait(0.1);
            scr.type(Key.PAGE_DOWN, Key.CTRL);  // in case of error comment
            scr.wait(0.1);
            // if error, manually!!!

            // #################################

            Pattern p10Shelf_port = new Pattern(basePath + "p10Shelf_port.png");
            scr.wait(p10Shelf_port.similar(0.7));
            System.out.println("found p10Shelf_port");

            // scr.wait(3.0);
            scr.wait(0.5);

            // ---------------------------------
            scr.paste(port);
            scr.wait(0.1);

            // Pattern p11Port = new Pattern(basePath + "p11Port.png");
            // scr.waitVanish(p11Port.similar(0.88));

            // ---------------------------------
            scr.click(p9SelectShelf.similar(0.7).targetOffset(260, 134));
            scr.wait(0.1);
            scr.paste(equipment);
            scr.wait(0.5);   // čekaj 0.5 sekundi
            scr.type(Key.ENTER);

            // ---------------------------------
            Pattern p12Shelf_search_results = new Pattern(basePath + "p12Shelf_search_results.png");
            scr.wait(p12Shelf_search_results.similar(0.7));
            System.out.println("found p12Shelf_search_results");

            scr.doubleClick(p12Shelf_search_results.targetOffset(100, 50));

            // ---------------------------------

        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Some other exception occured " + e.getMessage());
        }

    }


    // instance method
    private void m4SelectPort() throws FindFailed
    {

        try {
            // INV: Port- priprema rednog broja u slotu
            Pattern p13Select_port = new Pattern(basePath + "p13Select_port.png");
            scr.wait(p13Select_port);
            System.out.println("found p13Select_port");

            scr.doubleClick(p13Select_port.similar(0.7).targetOffset(100, 180));

            // ---------------------------------
            scr.waitVanish(p13Select_port.similar(0.7));
            Pattern p14Save = new Pattern(basePath + "p14Save.png");

            scr.type("s", Key.CTRL);   // Save
            scr.waitVanish(p14Save.similar(0.9));

            // ---------------------------------
            scr.type("a", Key.CTRL);   // Select All
            scr.wait(0.1);
            scr.type("x", Key.CTRL);   // Cut
            scr.wait(1.0);

            Pattern p15Gen_IDa = new Pattern(basePath + "p15Gen_IDa.png");
            r1Top_GenID.wait(p15Gen_IDa.similar(0.98));
            System.out.println("found p15Gen_IDa");

            r1Top_GenID.click(p15Gen_IDa.similar(0.7).targetOffset(-19, 0));

            // ---------------------------------
            Pattern p16Temp_path_name = new Pattern(basePath + "p16Temp_path_name.png");
            scr.wait(p16Temp_path_name.similar(0.7));
            System.out.println("found p16Temp_path_name");

            scr.type("v", Key.CTRL);   // Paste
            scr.wait(0.1);
            scr.type(Key.TAB);
            scr.wait(0.1);
            scr.type(Key.ENTER);

            // ---------------------------------
            scr.waitVanish(p16Temp_path_name.similar(0.7));
            scr.type("a", Key.CTRL);   // Select All
            scr.wait(0.1);
            scr.type("c", Key.CTRL);   // Copy
            scr.wait(0.1);
            scr.type("s", Key.CTRL);   // Save

            // ---------------------------------
            scr.waitVanish(p14Save.similar(0.9));
            // scr.type(Key.F4, Key.CTRL);   // Close

        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        }

	}


   // this is a static method and cannot call an instance method without a object
    public static void main(String[] args) throws FindFailed
    {
        System.out.println( "Hello World!" );
        // create instance of object
        Inventory_02_ui uiObj = new Inventory_02_ui();

        // Windows bat file (Look at the end!)
        // set EQUIPMENT=%1
        // set PORT=%2
        // String equipment = "xxx";
        // String port = "xxx";
        uiObj.equipment = args[0].toString();
        uiObj.port = args[1].toString();

        uiObj.startApp();
    }

}


// Windows bat file
// Run_inventory_02_UI.bat

// -------------------------------------------------------------
// set EQUIPMENT=%1
// set PORT=%2

// :: Change Current Directory to the location of this batch file
// :: http://ss64.com/nt/cd.html
// CD /d "%~dp0"

// CMD /c %JAVA_HOME%bin\java -cp Inventory_02_UI-1.0-SNAPSHOT.jar;C:\xxx\dependency204/* com.mxb.inventory.ui.Inventory_02_ui %EQUIPMENT% %PORT%

