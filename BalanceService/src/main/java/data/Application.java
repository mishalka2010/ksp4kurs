package data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.sql.SQLException;

@ServletComponentScan
@SpringBootApplication
public class Application
{
    public static void main(String args[]) throws SQLException
    {
          SpringApplication.run(Application.class);
    }
}
