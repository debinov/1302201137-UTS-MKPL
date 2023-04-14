package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String idNumber;
	private int monthWorkingInYear;
	
	private LocalDate tglJoin; 

	private boolean isForeigner;	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseIdNumber;
	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee( String idNumber, LocalDate tglJoin, boolean isForeigner) {
	
		this.idNumber = idNumber;
		
		this.tglJoin = tglJoin;
		this.isForeigner = isForeigner;
		
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	public void setMonthlySalary(int grade) {	
		switch(grade) {
			case 1:
				monthlySalary = 3000000;
				if (isForeigner) {
					monthlySalary = (int) (3000000 * 1.5);
				}
			    break;
			
			case 2:
				monthlySalary = 5000000;
				if (isForeigner) {
					monthlySalary = (int) (3000000 * 1.5);
				}
			    break;
		   
			case 3:
				monthlySalary = 7000000;
				if (isForeigner) {
					monthlySalary = (int) (3000000 * 1.5);
				}
			    break;

			default:
			    System.out.println("Invalid Number");
				break;
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse( String spouseIdNumber) {
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == tglJoin.getYear()) {
			monthWorkingInYear = date.getMonthValue() - tglJoin.getMonthValue();
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
