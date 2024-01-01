package Practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.StackWalker.Option;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
// method that r present in both child and parent must have same exception class or not




public class While  {
	 

	public static void main(String[] args){
	
		String s="temprature";
		s=s.toLowerCase();
//		StringBuilder sv=new StringBuilder("");
//		StringBuilder sc=new StringBuilder("");
		char c=' ';
//		for(int i=0;i<s.length();i++) {
//			c=s.charAt(i);
//			if(c== 'a'|| c== 'e'||c=='i'||c=='o'||c=='u') {
//				sv.append(c);
//			}
//			else {
//				sc=sc.append(c);
//			}
//		}
//		String res=sv.append(s.indexOf(sv.charAt(0))).append(sc).append(s.indexOf(sc.charAt(0))).toString();
		//System.out.println(res);
		
		List<Character> lv=new ArrayList<Character>();
		List<Character> lc=new ArrayList<Character>();
		for(int i=0;i<s.length();i++) {
			c=s.charAt(i);
			if(c== 'a'|| c== 'e'||c=='i'||c=='o'||c=='u') {
				lv.add(c);
			}
			else {
				lc.add(c);
			}
		}
		Collections.sort(lv);
		Collections.sort(lc);
		
		String res="";
		for(int i=0;i<lv.size();i++) {
			res=res+lv.get(i);
		}
		res=res+s.indexOf(res.charAt(0));
		for(int j=0;j<lc.size();j++) {
			res=res+lc.get(j);
		}
		res=res+s.indexOf(lc.get(0));
		System.out.println(res);
		
////		Scanner s = new Scanner(System.in);
////        String inputString = s.nextLine();
//		//String inputString="bharat32,5ravi,linga,monica45";
//		String inputString="sanju98,veera90,ganga007,yohesh23,john78";
//        String[] inputString1=inputString.split(",");
//        //List l=new ArrayList(Arrays.asList(inputString1));
//        //List ls=Arrays.asList(inputString1);
//        List ls=new ArrayList();
//        for(String s:inputString1){
//            ls.add(s);
//        }
//        
//        if(ls.size()==1){
//            System.out.println(ls.get(0));
//        }
//        
//        else{
//            for(int i=0;i<ls.size();i++){
//                ls.remove(i);
//                if(ls.size()==1){
//                    System.out.println(ls.get(0));
//                    break;
//                }
//            }
//            for(int i=ls.size()-1;i>=0;i--){
//                ls.remove(i);
//                if(ls.size()==1){
//                	 System.out.println(ls.get(0));
//                     break;
//                 }
//             }
//         }
//        
	}
}





















