package com.pawanj09.omnicell;

import java.util.ArrayList;
import java.util.List;

public class OmnicellProblem {

	public static void main(String[] args) {
		SmallBin[] smallBinArr = new SmallBin[3];
		//Initialize objects
		for(int i=0; i<smallBinArr.length; i++) {
			smallBinArr[i] = new SmallBin();
		}
		//Populate Small Bin 1
		System.out.println("Adding units to Small Bin 1");
		for(int i=0; i<5; i++) {
			smallBinArr[0].addUnit(new Unit(i+1, "SmallBin-Medication"));
		}
		System.out.println("Display existing units in Small Bin 1");
		System.out.println(smallBinArr[0]);
		System.out.println();
		System.out.println();
		System.out.println("Removing Unit 2 from Small Bin 1");
		smallBinArr[0].removeUnit(new Unit(2, "SmallBin-Medication"));
		System.out.println("Display existing units in Small Bin 1");
		System.out.println(smallBinArr[0]);
		System.out.println();
		System.out.println();
		System.out.println("Removing other uinits to check threshold");
		smallBinArr[0].removeUnit(new Unit(3, "SmallBin-Medication"));
		smallBinArr[0].removeUnit(new Unit(4, "SmallBin-Medication"));
		smallBinArr[0].removeUnit(new Unit(5, "SmallBin-Medication"));
		System.out.println("Display existing units in Small Bin 1");
		System.out.println(smallBinArr[0]);
	}

}

class Unit {
	private int medicineId;
	private String medicineName;
	
	public Unit(int medicineId, String medicineName) {
		this.medicineId = medicineId;
		this.medicineName = medicineName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof Unit)) return false;
		Unit u = (Unit)obj;
		return u.medicineId == this.medicineId;
	}
	
	@Override 
	public String toString() {
		return "\nUnit [" + medicineId + ", " + medicineName + "]";
	}
	
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
}

interface Bin {
	public void addUnit(Unit u);
	public void removeUnit(Unit u);
	public void resetUnit(Unit u);
}

class SmallBin implements Bin {

	private final int maxCapacity = 5;
	private List<Unit> unitList = new ArrayList<Unit>();
	
	@Override
	public void addUnit(Unit u) {
		if(unitList.size()<maxCapacity) {
			unitList.add(u);
			System.out.println("Unit added in Small bin: " + u);
		} else {
			System.out.println("Cannot add more units to Small bin");
		}
		
	}

	@Override
	public void removeUnit(Unit u) {
		if(unitList.size()>0) {
			unitList.remove(u);
			System.out.println("Unit removed from Small bin: " + u);
		} else {
			System.out.println("No units to remove from Small bin");
			return;
		}
		if(unitList.size() <= ((int)Math.round(maxCapacity*0.2))) {
			System.out.println("Small Bin at threshold !!");
		}
	}

	@Override
	public void resetUnit(Unit u) {
		unitList.clear();
		System.out.println("Small bin reset");
	}
	
	@Override 
	public String toString() {
		return unitList.toString();
	}
	
}