import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 作者：chenZY
 * 时间：2018/5/29 15:31
 * 描述：
 */
public class Main2 {

    public static void main(String[] args) {
        FileReader fr;
        try {
            fr = new FileReader("C:\\Users\\CZY\\Desktop\\2018-05-29.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("电压")) {
                    String[] arrs = line.split(" ");
//                    System.out.println("电压值: " + arrs[1]);
//                    System.out.println("剩余电量: " + arrs[2].split("：")[1]);
//                    System.out.println(arrs[1]);
                    System.out.println(arrs[2].split("：")[1]);
                } else if (line.contains("定时任务__***************************************************************")) {
//                    String[] arrs = line.split("\t1.0.8");
//                    System.out.println(arrs[0].replace("[","").replace("]",""));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}