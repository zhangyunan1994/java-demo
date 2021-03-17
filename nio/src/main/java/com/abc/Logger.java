package com.abc;


public class Logger {

  /**
   * 带着方法名输出，方法名称放在前面
   *
   * @param s 待输出的字符串形参
   */
  public static void debug(Object s) {
    String content = null;
    if (null != s) {
      content = s.toString().trim();
    } else {
      content = "";
    }

    System.out.println(content);
  }
}
