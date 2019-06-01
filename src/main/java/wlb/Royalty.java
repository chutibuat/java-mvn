package wlb;

public class Royalty {
    public Point calculate(double totalPrice) {
        return new Point(new Double(totalPrice).intValue() / 10);
    }
}