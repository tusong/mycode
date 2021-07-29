import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tusong
 * @version V1.0
 * @Package PACKAGE_NAME
 * @ClassName WeChatImgRevert.java
 * @date 2021/6/16
 * @Description: 此处添加类描述……
 */
public class WeChatImgRevert {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        final String dir = "C:/Users/tudayu/Documents/WeChat Files/wxid_drmv71n5ei9421/FileStorage/Image/1970-01/";

        Runnable r = () -> {
            String[] fileName = GetFileName.getFileName(dir);

            int i = 0;
            for (String name : fileName) {

                try (InputStream reader = new FileInputStream(dir + name)) {
                    try (OutputStream writer = new FileOutputStream("D:/photo/" + name + ".jpg")) {
                        byte[] bytes = new byte[1024];
                        int b;
                        while ((b = reader.read(bytes)) != -1) {//这里的in.read(bytes);就是把输入流中的东西，写入到内存中（buffer）。
//                        System.out.println("b = " + b + " b ^ 241 = " + (b ^ 241));
                            writer.write(b ^ 35);//241这个值是现算的，每个人电脑的值都不一致
                            writer.flush();
                        }
                    }
                    System.out.println(i++);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        pool.submit(r);
        pool.shutdown();
//        System.out.println("--------------------------------");
//
//        ArrayList<String> listFileName = new ArrayList<String>();
//
//        GetFileName.getAllFileName("F:/dat", listFileName);
//
//        for (String name : listFileName) {
//            System.out.println(name);
//        }

    }

}


class GetFileName {

    public static String[] getFileName(String path) {

        File file = new File(path);

        String[] fileName = file.list();

        return fileName;

    }

//    public static void getAllFileName(String path, ArrayList<String> fileName) {
//
//        File file = new File(path);
//
//        File[] files = file.listFiles();
//
//        String[] names = file.list();
//
//        if (names != null)
//
//            fileName.addAll(Arrays.asList(names));
//
//        for (File a : files) {
//
//            if (a.isDirectory()) {
//
//                getAllFileName(a.getAbsolutePath(), fileName);
//
//            }
//        }
//    }

}
