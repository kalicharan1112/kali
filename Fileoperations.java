//import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Fileoperations {
	String dir = "Test3";
	
	public void Retrievefiles()
	{
		List<String> listFile = Arrays.asList(new File(dir).list());	
		if(listFile.size()==0) {
			System.out.println("No files exist");
		}
		else {
			Collections.sort(listFile);
			System.out.println(listFile);
		}
	}
	
	public void CreateFile(String s) throws IOException {
		File f = new File(dir+File.separator+s);
		if(f.createNewFile()) {
			System.out.println("File " +s+ " Added");
		  /*  System.out.println("Do you want enter data in a file Y/N");
			String c=sc.next();
			if(c.equals("Y")) {
			System.out.println("Enter data in a file");
			String str=sc.nextLine();
			FileWriter fw = new FileWriter(f);
			fw.write(str);
			fw.close();
		 }else
				System.out.println("File created");			 */
	 }
		else {
		 System.out.println("File Exist");
	 }
	 }
	
	public void DeleteFile(String s) 
	{
		List<File> content = Arrays.asList(new File(dir).listFiles());
		for(File f : content) {
			if(f.getName().equals(s)) {
				f.delete();
				System.out.println("File "+s+ " Deleted");
			}
		}
		System.out.println("File Not Found");
	}
	
	public void SearchFile(String s)
	{
		List<String> content = Arrays.asList(new File(dir).list());
		if(content.contains(s)) {
			System.out.println("File " + s + " found");
		} else {
			System.out.println("File Not Found");
		}
	}
	
	public static void main(String [] args) throws IOException {
		System.out.println("Welcome to LockedMe.com \n Developed by Kalicharan \n");
		File dir = new File ("Test3");
		Scanner sc = new Scanner(System.in);
		Fileoperations fo= new Fileoperations();
		if(!dir.mkdir())
			System.out.println("Directory exist");
		else
		 System.out.println("Directory created");
	
	System.out.println("pick one of the below to perform operations on files: \n 1.Retrieve file \n 2.Business level operation \n 3.close application \n");
	String ch,ch1;
	ch= sc.next();	
	while(true) {
		switch(ch) {
		case "1":System.out.println("list of files");
		fo.Retrievefiles();
		break;
		case "2":
			while(true) {
				System.out.println("Select one of the below: \n 1.Add file \n 2.Delete file \n 3.Search file \n 4.Return to main menu \n");
				ch1= sc.next();
      		  if(ch1.equals("1")) 
      		  {
      			  System.out.println("Enter filename to add file: \n");
      			  String filename = sc.next();
      			  fo.CreateFile(filename);
      			  }
      		  else if(ch1.equals("2"))
      		  {
      			  System.out.println("Enter filename to perform Delete operation: \n");
      			  String deletefile = sc.next();
      			  fo.DeleteFile(deletefile);
      			  }
			 else if(ch1.equals("3"))
		     {
				 System.out.println("Enter filename to perform Search operation: \n");
				 String searchfile = sc.next();
				 fo.SearchFile(searchfile);
				 }
			 else if(ch1.equals("4"))
		     {
		    	break; 
		    	}
			 else 
				 System.out.println("Invalid input");
			 }
			 break;
			 case "3": System.out.println("Application Closed");
			 System.exit(0);
			default: System.out.println("Invalid input");
			}
		System.out.println("pick one of the below \n 1.Retrieve file \n 2.Business level operation \n 3.Close application \n");
		ch= sc.next();
		}
		}
	}
