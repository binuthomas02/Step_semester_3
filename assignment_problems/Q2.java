class PayrollAccount
{
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary)
    {
        if (basicSalary < 0)
        {
            System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        }
        else
        {
            this.basicSalary = basicSalary;
        }

        this.bonus = 0;
    }

    public void creditBonus(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Warning: Bonus amount must be positive. No bonus credited.");
        }
        else
        {
            this.bonus += amount;
        }
    }

    public void deductTax(double percent)
    {
        if (percent < 0 || percent > 100)
        {
            System.out.println("Invalid tax percentage.");
        }
        else
        {
            this.basicSalary -= this.basicSalary * (percent / 100);
        }
    }

    public double netSalary()
    {
        return this.basicSalary + this.bonus;
    }

    public double getBonus()
    {
        return this.bonus;
    }
}

public class Q2
{
    public static void main(String[] args)
    {
        PayrollAccount account = new PayrollAccount(50000);

        account.creditBonus(5000);
        account.deductTax(10);

        System.out.println("Bonus Credited: Rs " + account.getBonus());
        System.out.println("Tax deducted: " + "10%");
        System.out.println("Net Salary: Rs " + account.netSalary());
    }
}
