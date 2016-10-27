import java.util.Scanner;

/**
 * Created by Administrator on 2016/10/25.
 */
//正方形
public class Square extends Shape{
    public void area(){
        System.out.println("请输入正方形的边长");
        Scanner cin_square = new Scanner(System.in);
        double square_a = cin_square.nextDouble();
        outcome = square_a*square_a;
        System.out.println("正方形面积为"+outcome);
    }
}