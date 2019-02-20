import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Main {

    public static void main(String[] args){

        System.out.println("Current Date : " + LocalDate.now() + "\n");
        System.out.println("Current Time : " + LocalTime.now() + "\n");
        System.out.println("Current Date and Time : " + LocalDateTime.now() + "\n");


        LocalDate db = LocalDate.of(1996,Month.JUNE, 12);
        LocalTime dbt = LocalTime.of(23, 52);

        //Checking whether the current date is matched with the given date
        if(LocalDate.now().isEqual(db)){
            System.out.println("Matched date\n");
        }
        else{
            System.out.println("Today is not the day you need\n");
        }


        LocalDate sample_date = LocalDate.of(2019, Month.FEBRUARY, 21);
        LocalTime sample_time = LocalTime.of(12, 45);

        //Subtract 10 days from sample_date
        sample_date = sample_date.minusDays(10);

        //Add 1 hour to sample_time
        sample_time = sample_time.plusHours(1);

        System.out.println(sample_date);
        System.out.println(sample_time);
    }


}
