import java.util.Scanner;

/**
 * Created by Administrator on 2016/10/25.
 */
public class Triangle extends Shape{
    public void area(){
        System.out.println("请输入三角形的底");
        Scanner cin_triangle_a = new Scanner(System.in);
        double triangle_a = cin_triangle_a.nextDouble();
        System.out.println("好的！现在请输入三角形的高");
        Scanner cin_triangle_h = new Scanner(System.in);
        double triangle_h = cin_triangle_h.nextDouble();
        outcome = 0.5*triangle_a*triangle_h;
        System.out.println("三角形面积为"+outcome);
    }
}
