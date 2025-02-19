package entities;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double monthlyIncome = salaryIncome / 12;
		if (monthlyIncome >= 3000.00 && monthlyIncome < 5000.00) {
			return salaryIncome * 0.10;
		} 
		else if (monthlyIncome >= 5000.00) {
			return salaryIncome * 0.20;
		} 
		else {
			return 0;
		}
	}

	public double servicesTax() {
		return servicesIncome * 0.15;
	}

	public double capitalTax() {
		return capitalIncome * 0.20;
	}

	public double grossTax() {
		return servicesTax() + capitalTax() + salaryTax();
	}

	public double taxRebate() {
		double spending = healthSpending + educationSpending;
		double maxRebate = grossTax() * 0.30;
		
		return Math.min(spending, maxRebate);
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}
}
