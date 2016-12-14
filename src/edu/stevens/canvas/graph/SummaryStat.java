package edu.stevens.canvas.graph;

import java.util.*;

public class SummaryStat {
	private StringBuilder sb;
	
	public SummaryStat(ArrayList<Double> grade) {		
		sb = new StringBuilder("");
		
		sb.append(count(grade) + " students participate in the exam" + "\r\n" + "\r\n");
		sb.append("Highest score: " + max(grade) + "\r\n" + "\r\n");
		sb.append("Lowest score: " + min(grade) + "\r\n" + "\r\n");
		
		sb.append("Average: " + average(grade) + "\r\n" + "\r\n");
		sb.append("Variance: " + variance(grade) + "\r\n" + "\r\n");
		sb.append("Standard Deviation: " + StdDev(grade) + "\r\n" + "\r\n");
		sb.append("Median: " + median(grade) + "\r\n" + "\r\n");
		
		sb.append("Mode(s): " + mode(grade) + "\r\n" + "\r\n");
	}
	
	public static int count(ArrayList<Double> list) {
		return list.size();
	}
	
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++){
		   sum = sum + list.get(i);
		}
		return sum;
	}
	
	public static double average(ArrayList<Double> list) {
		double average = sum(list) / list.size();
		return average;
	}
	
	public static double median(ArrayList<Double> list) {
		Collections.sort(list);
		int middle = list.size() / 2;
		if (list.size() % 2 == 0) {
			return (list.get(middle - 1) + list.get(middle)) / 2.0;
		}
		else {
			return list.get((list.size() - 1) / 2);
		}
	}
	
	public static ArrayList<Integer> mode(final ArrayList<Double> list) {
		final ArrayList<Integer> modes = new ArrayList<Integer>();
		final Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		int max = -1;

		for (final double n : list) {
			int n2 = (int) n;
			int count = 0;
			if (countMap.containsKey(n2)) {
				count = countMap.get(n2) + 1;
			}
			else {
				count = 1;
			}
			
			countMap.put(n2, count);
			
			if (count > max) {
				max = count;
			}
		}

		for (final Map.Entry<Integer, Integer> tuple : countMap.entrySet()) {
			if (tuple.getValue() == max) {
				modes.add(tuple.getKey());
			}
		}
		return modes;
	}
	
	public static double variance(ArrayList<Double> list) {
		double var = 0;
		for(int i = 0; i < list.size(); i++) {
			var += (list.get(i) - average(list)) * (list.get(i) - average(list));
		}
		return var / (list.size());
	}
	
	public static double StdDev(ArrayList<Double> list) {
		double var = 0;
		for(int i = 0; i < list.size(); i++) {
			var += (list.get(i) - average(list)) * (list.get(i) - average(list));
		}
		return Math.sqrt(var / (list.size()));
	}
	
	public static double max(ArrayList<Double> list) {
		double max = Integer.MIN_VALUE;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) > max){
				max = list.get(i);
			}
		}
		return max;
	}
	
	public static double min(ArrayList<Double> list) {
		double min = Integer.MAX_VALUE;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) < min){
				min = list.get(i);
			}
		}
		return min;
	}
	
	public StringBuilder getStr() {
		return sb;
	}
}