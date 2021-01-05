/* Alexis Arellano Tuesday November 17/2020 */

package ws7task1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetFile {
	static List<String> col1 = new ArrayList<String>();
	static List<String> col2 = new ArrayList<String>();
	static List<String> col3 = new ArrayList<String>();
	static List<String> col4 = new ArrayList<String>();
	static List<String> col5 = new ArrayList<String>();
	
	public void read() {
		System.out.print("Enter the file name: ");
		Scanner in = new Scanner(System.in);
		String fileName = in.next();
		
		String line;
		
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName,"r");
			StringBuffer buffer = new StringBuffer();
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) {
				buffer.append(raf.readLine() + System.lineSeparator());
			}
			line = buffer.toString();
			String[] rankings = line.split("\n");
			
			for (int i = 0; i < rankings.length; i++) {
				String[] rank = rankings[i].split("\t");
				
				
				col1.add(rank[0].trim());
				col2.add(rank[1].trim());
				col3.add(rank[2].trim());
				col4.add(rank[3].trim());
				col5.add(rank[4].trim());
				
			}
			raf.close();
		}
		catch(IOException e) {
			System.err.println(e.toString());
		}
		in.close();
		
	}
	
	public List<String> getCol(int num) {
		
		List<String> column = col1;
		if (num == 1) {
			 column = col1;
		}
		else if (num == 2) {
			column = col2;
		}
		else if (num == 3) {
			column = col3;
		}
		else if (num == 4) {
			column = col4;
		}
		else if (num == 5) {
			column = col5;
		}
		return column;
	}

}
