import cn.czy.mealOrderSystem.orderMeal.business.MealOrderStatisticsBusiness;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: PeterChen
 * @Date: 2018/12/18 17:59
 * @Version 1.0
 */
@Slf4j
public class Test1 extends  baseTest{

    @Autowired
    private MealOrderStatisticsBusiness mealOrderStatistics;

    @Test
    public void test1(){

        log.warn("=============================");
        log.warn(String.valueOf(mealOrderStatistics.mealOrderStatisticsForShow("20180707").size()));

        mealOrderStatistics.mealOrderStatisticsUpdateCount();
    }
}
