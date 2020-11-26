package com.yjdzm.exer;
import java.util.Scanner;
/**
 * @author YaoJin
 * @create 2020-11-18 17:34
 * @description 实验3
 */
public class discounts {
  // 计算函数
  public static double countFun (double cost, int num, boolean isMain) {
    // 总价格
    double number = 0;

    if (num >= 2) {
      number = (cost * num) * 0.9;
      if (isMain == true) {
        if (number >= 20) {
          number -= 2;
        }
      }
    } else {
      number = cost;
    }
    return number;
  }

  public static void main(String[] args) {
    String name = "";
    int chooseNum = 0;
    int amountNum = 0;
    double costFinally = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入你的名称");
    name = sc.nextLine();
    System.out.println("你需要购买的商品(输入号码)/n1. 啤酒 2.方便面 3.矿泉水");
    chooseNum = sc.nextInt();
    System.out.println("请输入你想购买的数量");
    amountNum = sc.nextInt();
    Commodity discoutObj = new Commodity(chooseNum, amountNum);

    if (discoutObj.CommodityNum == 1) {
      costFinally = countFun(3.5, discoutObj.amountNum, false);
    } else if (discoutObj.CommodityNum == 2) {
      costFinally = countFun(4.5, discoutObj.amountNum, true);
    } else if (discoutObj.CommodityNum == 3) {
      costFinally = countFun(2.0, discoutObj.amountNum, false);
    }
    System.out.println("最后的价格是" + costFinally);
  }

}

// 创建商品类
class Commodity {
  int CommodityNum = 0;
  int amountNum = 0;
  public Commodity(int chooseNum, int amountNum) {
      this.CommodityNum = chooseNum;
      this.amountNum = amountNum;
  }
}
