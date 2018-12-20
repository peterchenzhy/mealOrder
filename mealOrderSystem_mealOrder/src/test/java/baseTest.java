import cn.czy.mealOrderSystem.orderMeal.OrderMealApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderMealApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"logging.path=logs",
                "spring.profiles.active=production"
        })
@DirtiesContext
public class baseTest {

}
