package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/")
    public String index() {

        return "Hello Sp";
    }

    /*
    @GetMapping("/dayofweek/{yyyy}/{mm}/{dd}")
    public String dispDayOfWeek(@PathVariable int yyyy,@PathVariable int mm,@PathVariable int dd) {

        int ye = yyyy;
        int mo = mm;
        int da = dd;

        LocalDate date = LocalDate.of(ye, mo, da);
        DayOfWeek day = date.getDayOfWeek();

        return "実行結果" + day;
    }
    */

    @GetMapping("/dayofweek/{yyyymmdd}")
    public String dispDayOfWeek(@PathVariable String yyyymmdd) {

        String showday = "";

        String ye1 = yyyymmdd.substring(0,4);
        String mo1 = yyyymmdd.substring(4,6);
        String da1 = yyyymmdd.substring(6,8);

        int ye = Integer.parseInt(ye1);
        int mo = Integer.parseInt(mo1);
        int da = Integer.parseInt(da1);

        /*int ye = yyyymmdd / 10000;
        int mo = (yyyymmdd - ye*10000)/100 ;
        int da = yyyymmdd - ye*10000 - mo*100;
        */

        //System.out.println("ye");

        LocalDate date = LocalDate.of(ye, mo, da);
        DayOfWeek day = date.getDayOfWeek();

        int daykari = day.getValue();

        switch(daykari) {
            case 1:
                showday = "Monday";
                break;

            case 2:
                showday = "Tuesday";
                break;

            case 3:
                showday = "Wednesday";
                break;

            case 4:
                showday = "Thursday";
                break;

            case 5:
                showday = "Friday";
                break;

            case 6:
                showday = "Saturday";
                break;

            case 7:
                showday = "Sunday";
                break;

        }

        return "実行結果：" + showday;
    }



    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2 ;
        return "計算結果" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2 ;
        return "計算結果" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2 ;
        return "計算結果" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 /     val2 ;
        return "計算結果" + res;
    }


}
