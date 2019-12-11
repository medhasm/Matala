package Ex1;
import java.awt.Color;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 



public class Functions_GUI implements functions {
	
	ArrayList<function> func=new ArrayList<function>();
	@Override
	public boolean add(function arg0) {
		// TODO Auto-generated method stub
		func.add(arg0);
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		func.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof function )
		{
			return func.contains(arg0);
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		
		return func.containsAll(arg0);
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return func.isEmpty();
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		
		return this.func.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 instanceof function )
			 return func.remove(arg0);
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		
		return func.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return func.retainAll(arg0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return func.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return func.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return func.toArray(arg0);
	}

	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub
		//InputStream fis = new FileInputStream(file);
		///JsonReader jsonReader = Json.createReader(fis);
		try {

		FileReader file_reader=new FileReader(file);
		BufferedReader br = new BufferedReader(file_reader);
		String st; 
		ComplexFunction cf = new ComplexFunction();
		  while ((st = br.readLine()) != null) 
		    System.out.println(st); 
		  func.add(cf.initFromString(st));
		}
		catch(IOException e) {
		e.printStackTrace();
	}
		
	}
	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub
		StringBuffer bf = new StringBuffer();
		String s=new String();
		File file1 = new File (file);
        BufferedWriter out = new BufferedWriter(new FileWriter(file1));
		for(int i=0;i<func.size();i++) {
			bf=new StringBuffer ((i+1)+")"+func.get(i).toString());
			out.write(new String(bf));
			out.newLine();
		}
		out.close();
	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub
		int n = resolution;
		StdDraw.setCanvasSize(width, height);
		int size = func.size();
		double[] x = new double[n+1];
		double[][] yy = new double[size][n+1];
		double x_step = (rx.get_max()-rx.get_min())/n;
		double x0 = rx.get_min();
		for (int i=0; i<=n; i++) {
			x[i] = x0;
			for(int a=0;a<size;a++) {
				yy[a][i] = func.get(a).f(x[i]);
			}
			x0+=x_step;
		}
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		
		
		// plot the approximation to the function
		for(int a=0;a<size;a++) {
			int c = a%Colors.length;
			StdDraw.setPenColor(Colors[c]);
		
			System.out.println(a+") "+Colors[a]+"  f(x)= "+func.get(a));
			for (int i = 0; i < n; i++) {
				StdDraw.line(x[i], yy[a][i], x[i+1], yy[a][i+1]);
			}
		}
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub	
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader(
                    "/Users/<username>/Documents/file1.txt"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            int Width = (int) jsonObject.get("Width");
            int Height = (int) jsonObject.get("Height");
            JSONArray  = (JSONArray) jsonObject.get("Company List");
 
            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public function get(int i) {
		// TODO Auto-generated method stub
		return this.func.get(i);
	}
	public static Color[] Colors = {Color.blue, Color.cyan,
			Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK};
	public static void main(String[] args) {
	    ComplexFunction cf1 = new ComplexFunction("Plus(-1.0x^4+2.4x^2+3.1,+0.1x^5-1.2999999999999998x+5.0)");
        ComplexFunction cf2 = new ComplexFunction("plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)");
        ComplexFunction cf3 = new ComplexFunction("div(Plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)");
        ComplexFunction cf4 = new ComplexFunction("-1.0x^4 +2.4x^2 +3.1");
        ComplexFunction cf5 = new ComplexFunction("max(max(max(max(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)");
        ComplexFunction cf6 = new ComplexFunction("min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)");
        ComplexFunction cf7 = new ComplexFunction("0.1x^5 -1.2999999999999998x +5.0");
        Functions_GUI a=new Functions_GUI();
        a.add(cf1);
        a.add(cf2);
        a.add(cf3);
        a.add(cf4);
        a.add(cf5);
        a.add(cf6);
        a.add(cf7);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a);
        }
	}
}
