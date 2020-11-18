
package com.yjdzm.exer;
import java.util.Scanner;
/**
 * @author YaoJin
 * @create 2020-11-18 17:04
 * @description:  实验1
 */
public class commodity {
  public static void main(String[] args) {
    double binggun = 1.5;
    double water = 2.0;
    double bread = 2.5;
    double fangbianmian = 4.5;
    // 商品费用
    double cost = 0.0;
    // 名称
    String name = "";
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入你的名称");
    name = sc.nextLine();
    System.out.println("1. 冰棍 2.矿泉水 3.面包 4.方便面");
    System.out.println("请输入你想购买的商品编号");
    int chooseNum = sc.nextInt();
    switch(chooseNum) {
      case 1:
        cost += 1.5;
        break;
      case 2:
        cost += 2.0;
        break;
      case 3:
        cost += 2.5;
        break;
      case 4:
        cost += 4.5;
        break;
      default:
    }
    System.out.println(name + "总共花费" + cost + "元");
  }
}
