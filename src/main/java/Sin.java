import java.util.Map;

public class Sin extends UnaryExpression{

    public Sin(Expression e) {
        super(e);
    }

    public Sin(double num) {
        super(num);
    }

    public Sin(String var) {
        super(var);
    }

    public double evaluate(Map<String, Double> assignment) {
        return Math.sin(Math.toRadians(this.getE().evaluate(assignment)));
    }

     public String toString() {
        return String.format("Sin(%s)", this.getE().toString());
    }

    public Expression assign(String var, Expression expression) {
        Expression eAss = this.getE().assign(var, expression);
        return new Sin(eAss).getE();
    }

    public Expression differentiateCalculator(Expression eDiff, String var) {
        return new Mult(String.valueOf(new Cos(this.getE())), eDiff);
    }

    public Sin simplify() {
        if (super.simplify() != null) {
            return super.simplify();
        } else {
            return new Sin(this.getE().simplify());
        }
    }
}