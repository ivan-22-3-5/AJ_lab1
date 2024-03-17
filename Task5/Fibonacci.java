package Task5;

public class Fibonacci implements Function<Integer> {

    public Fibonacci(){}

    @Override
    public Integer apply(Integer num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return this.apply(num-1) + this.apply(num-2);
        }
    }
}
