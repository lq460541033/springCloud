package com.cjs.example.price;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import technology.tabula.CommandLineApp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CjsPriceServiceApplicationTests {

    @Test
    public void contextLoads() throws Exception{
//        String[] args = new String[]{"-f=JSON", "-p=2", "E:\\JobRoom\\1111.pdf"};
//        String[] args = new String[]{"-i","-r","-l","-o=d:/output24.csv", "-p=2","E:\\JobRoom\\1111.pdf"};
        String[] args = new String[]{"-l","-o=d:/output00.csv", "-p=all","-r","-t","-u","E:\\JobRoom\\1111.pdf"};
//        String[] args = new String[]{"-a=269.875,12.75,790.5,561.","-o=d:/output2.csv", "-p=2","-t", "E:\\JobRoom\\1111.pdf"};
//        String[] args = new String[]{"-a=%0,0,200,50.","-o=d:/output222.csv", "-p=2","-t", "E:\\JobRoom\\1111.pdf"};

//        CommandLineApp.main(args);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(CommandLineApp.buildOptions(), args);
        StringBuilder stringBuilder = new StringBuilder();
        new CommandLineApp(stringBuilder, cmd).extractTables(cmd);
        System.out.println("============");
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void contextLoads2() throws Exception{
////
        String cmd = "java -jar tabula-1.0.2.jar E:\\JobRoom\\1111.pdf -o  E:\\JobRoom\\output1.csv";

        Runtime.getRuntime().exec(cmd);
    }

}
