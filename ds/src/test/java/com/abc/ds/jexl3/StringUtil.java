package com.abc.ds.jexl3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
  private static final char UNDERLINE = '_';

  /**
   * Is empty boolean.
   *
   * @param param the param
   * @return the boolean
   */
  public static boolean isEmpty(String param) {
    return param == null || param.length() == 0;
  }

  /**
   * Is blank boolean.
   *
   * @param cs the cs
   * @return the boolean
   */
  public static boolean isBlank(String cs) {
    int strLen;
    if (cs != null && (strLen = cs.length()) != 0) {
      for(int i = 0; i < strLen; ++i) {
        if (!Character.isWhitespace(cs.charAt(i))) {
          return false;
        }
      }
      return true;
    } else {
      return true;
    }
  }

  /**
   * Is not blank boolean.
   *
   * @param param the param
   * @return the boolean
   */
  public static boolean isNotBlank(String param) {
    return !isBlank(param);
  }

  /**
   * First char to lower case string.
   *
   * @param param the param
   * @return the string
   */
  public static String firstCharToLowerCase(String param) {
    if (isBlank(param)) {
      return param;
    }

    char[] resultArray = param.toCharArray();
    if (resultArray[0] >= 'A' && resultArray[0] <= 'Z') {
      resultArray[0] = (char) (resultArray[0] + 32);
    }
    return new String(resultArray);
  }

  public static String convertColumnNameToUpperCamelCase(String str) {
    if (isBlank(str)) {
      throw new IllegalArgumentException("参数不能为空");
    }
    String[] words = null;
    if (str.contains("_")) {
      words = str.split("_");
    } else {
      words = new String[]{str};
    }
    StringBuilder result = new StringBuilder();
    for (int index = 0; index < words.length; ++index) {
      String param = words[index];
      if (index == 0) {
        result.append(param);
        continue;
      }
      char[] ch = param.toCharArray();
      if (ch[0] >= 'a' && ch[0] <= 'z') {
        ch[0] = (char) (ch[0] - 32);
      }
      result.append(ch);
    }
    return result.toString();
  }


  public static String camelToUnderline(String param) {
    if (param == null || "".equals(param.trim())) {
      return "";
    }
    int len = param.length();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      char c = param.charAt(i);
      if (Character.isUpperCase(c)) {
        sb.append(UNDERLINE);
        sb.append(Character.toLowerCase(c));
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static List<String> matches(String str, String regex) {
    List<String> empty = new ArrayList<>();
    if (str == null) {
      return empty;
    }
    return matcheAll(regex, str, empty);
  }

  /**
   * Matche all e.
   *
   * @param <E>        the type parameter
   * @param regex      the regex
   * @param str        the str
   * @param collection the collection
   * @return the e
   */
  public static <E> E matcheAll(String regex, String str, Collection<String> collection) {
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(str);
    String val;
    while (m.find()) {
      val = m.group();
      collection.add(val);
    }
    return (E) collection;
  }
}
