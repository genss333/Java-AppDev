package ChooseFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileFor {
	
	public static void main(String[] args) {
		System.out.println("ReadFileFor.main()");
		String fileName = "files/StudentMarks.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			StringBuffer buf = new StringBuffer();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				buf.append(line + "\n");
			}
			System.out.println("buf------\n" + buf);
			String temp = buf.toString();
			String[] lines = temp.split("\n");
			int[] ids = new int[lines.length];
			String[] names = new String[lines.length];
			String[] surnames = new String[lines.length];
			double[] marks = new double[lines.length];
			char[] grades = new char[lines.length];
			for(int i=0; i<lines.length; i++) {
				String[] tempArray = lines[i].split(",");
				int id = Integer.parseInt(tempArray[0]);
				String name = tempArray[1];
				String surname = tempArray[2];
				double mark = Double.parseDouble(tempArray[3]);
				ids[i] = id;
				names[i] = name;
				surnames[i] = surname;
				marks[i] = mark;
				if(mark<50) {
					grades[i] = 'F';
				} else if(mark<60) {
					grades[i] = 'D';
				} else if(mark<70) {
					grades[i] = 'C';
				} else if(mark<80) {
					grades[i] = 'B';
				} else {
					grades[i] = 'A';
				}
			}
			System.out.println("ID\t|\tNames\t|\tSurnames\t|\tMarks\t|\tGrades\t");
			for(int i=0; i<ids.length; i++) {
				System.out.println(ids[i]
						+ "\t|\t" + names[i]
						+ "\t|\t" + surnames[i]
						+ "\t|\t" + marks[i]
						+ "\t|\t" + grades[i]);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
