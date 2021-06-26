package models.validators;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import models.Food;
public class FoodValidator {
    public static List<String> validate(Food f) {
        List<String> errors = new ArrayList<String>();
        String food_name_error = validateFood_name(f.getFood_name());
        if(!food_name_error.equals("")) {
            errors.add(food_name_error);
        }
        String amount_error = validateAmount(f.getAmount());
        if(!amount_error.equals("")) {
            errors.add(amount_error);
        }
        String open_flag_error = validateOpen_flag(f.getOpen_flag());
        if(!open_flag_error.equals("")) {
            errors.add(open_flag_error);
        }
        String time_limit_error = validateTime_limit(f.getTime_limit());
        if(!time_limit_error.equals("")) {
            errors.add(time_limit_error);
        }
        return errors;
    }
    // 商品名の必須入力チェック
    private static String validateFood_name(String food_name) {
        // 必須入力チェック
        if(food_name == null || food_name.equals("")) {
            return "商品名を入力してください。";
        }
        return "";
    }
    // 内容量の必須入力チェック
    private static String validateAmount(String amount) {
        if(amount == null || amount.equals("")) {
            return "内容量を入力してください。";
        }
        return "";
    }
    // 開封or未開封の必須入力チェック
    private static String validateOpen_flag(Integer open_flag) {
        if(open_flag == 2) {
            return "開封or未開封を入力してください。";
        }
        return "";
    }
    // 賞味期限の必須入力チェック
    private static String validateTime_limit(Date time_limit) {
        if(time_limit == null || time_limit.toString().equals("1972-01-01")) {
            return "賞味期限を入力してください。";
        }
        return "";
    }
}