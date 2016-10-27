import java.util.Scanner;

/**
 * Created by Administrator on 2016/10/25.
 */
//圆
public class Circle extends Shape{
    public void area(){
        System.out.println("请输入圆的半径：");
        Scanner cin_R = new Scanner(System.in);
        double radius = cin_R.nextDouble();
        outcome = pi*radius*radius;
        System.out.println("面积为"+outcome);
    }
}